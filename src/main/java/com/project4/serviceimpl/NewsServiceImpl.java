package com.project4.serviceimpl;

import com.project4.Commom.Commom;
import com.project4.DTO.NewsDTO;
import com.project4.entity.CategoryNews;
import com.project4.entity.LogActions;
import com.project4.entity.News;
import com.project4.entity.User;
import com.project4.repository.CategoryNewsRepository;
import com.project4.repository.LogActionsRepository;
import com.project4.repository.NewsRepository;
import com.project4.repository.UserRepository;
import com.project4.service.NewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import java.net.InetAddress;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class NewsServiceImpl implements NewsService {

    @Autowired
    private NewsRepository newsRepositoty;

    @Autowired
    private LogActionsRepository logActionsRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private CategoryNewsRepository categoryNewsRepository;

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    @Transactional
    public List<NewsDTO> getNewByCategoryId(Integer id) {
        List<News> newsList = newsRepositoty.findAllByCategoryId(id);
        List<NewsDTO> listDTO = new ArrayList<>();
        for (int i = 0; i < newsList.size(); i++) {
            NewsDTO newsDTO = new NewsDTO();
            newsDTO.setId(newsList.get(i).getId());
            newsDTO.setActive(newsList.get(i).getActive());
            newsDTO.setCategoryId(newsList.get(i).getCategoryId());
            newsDTO.setContent(newsList.get(i).getContent());
            newsDTO.setTitle(newsList.get(i).getTitle());
            String dateformat = new java.text.SimpleDateFormat("MM/dd/yyyy HH:mm:ss").format(new java.util.Date(newsList.get(i).getCreateTime()));

            newsDTO.setCreateTime(dateformat);
            listDTO.add(newsDTO);
        }
        return listDTO;
    }


    @Override
    public Boolean addNew(News news, HttpServletRequest ttpServletRequest) {
        if (news == null) {
            return false;
        }
        News news1 = newsRepositoty.findByTitle(news.getTitle());
        if (news1 != null) {
            return false;
        }
        if (news.getId()!=null){
            Cookie[] cookies = ttpServletRequest.getCookies();
            LogActions logActions = new LogActions();
            for (int i = 0; i < cookies.length; i++) {
                User user = userRepository.findByPassword(cookies[i].getValue());
                if (user != null) {
                    logActions.setUserName(user.getUserName());
                }
            }
            if (StringUtils.isEmpty(logActions.getUserName().isEmpty())) {
                return false;
            }
//        User user = userRepository.findByPassword(CookieValue);

            logActions.setComputerName(Commom.getComputerName());
            logActions.setUserWindow(Commom.getUserWindow());

            Optional<News> optionalNews = newsRepositoty.findById(news.getId());
            News newsoption = optionalNews.get();

            Optional<CategoryNews> categoryNewsOptional = categoryNewsRepository.findById(news.getCategoryId());
            CategoryNews categoryNews = categoryNewsOptional.get();

            Optional<CategoryNews> category = categoryNewsRepository.findById(newsoption.getCategoryId());
            CategoryNews categ = category.get();

            logActions.setActionDescription("sửa tin tức - title :"+newsoption.getTitle()+"=>"+news.getTitle()+"  content:"+newsoption.getContent()+"=>"+news.getContent()+"  createTime"+newsoption.getCreateTime()+"  CategoryName:"+categ.getName()+"=>"+categoryNews.getName());
            logActions.setFormAction(Commom.updateNews);
            Date date = new Date();
            Long createTimee = date.getTime();
            logActions.setTimeAction(createTimee);
            logActionsRepository.save(logActions);

            Long createTime = date.getTime();
            news.setCreateTime(createTime);
            newsRepositoty.save(news);
            return true;
        }

        Cookie[] cookies = ttpServletRequest.getCookies();
        LogActions logActions = new LogActions();
        for (int i = 0; i < cookies.length; i++) {
            User user = userRepository.findByPassword(cookies[i].getValue());
            if (user != null) {
                logActions.setUserName(user.getUserName());
            }
        }
        if (StringUtils.isEmpty(logActions.getUserName().isEmpty())) {
            return false;
        }
//        User user = userRepository.findByPassword(CookieValue);

        logActions.setComputerName(Commom.getComputerName());
        logActions.setUserWindow(Commom.getUserWindow());

        Optional<CategoryNews> categoryNewsOptional = categoryNewsRepository.findById(news.getCategoryId());
        CategoryNews categoryNews = categoryNewsOptional.get();
        logActions.setActionDescription("thêm tin tức - title :"+news.getTitle()+"  content:"+news.getContent()+"  CategoryName:"+categoryNews.getName());
        logActions.setFormAction(Commom.addnews);
        Date date = new Date();
        Long createTimee = date.getTime();
        logActions.setTimeAction(createTimee);
        logActionsRepository.save(logActions);

        Long createTime = date.getTime();
        news.setCreateTime(createTime);
        newsRepositoty.save(news);
        return true;
    }

    @Override
    public Boolean delete(Integer id, HttpServletRequest ttpServletRequest) {
        if (id != null) {
            Cookie[] cookies = ttpServletRequest.getCookies();
            LogActions logActions = new LogActions();
            for (int i = 0; i < cookies.length; i++) {
                User user = userRepository.findByPassword(cookies[i].getValue());
                if (user != null) {
                    logActions.setUserName(user.getUserName());
                }
            }
            if (StringUtils.isEmpty(logActions.getUserName().isEmpty())) {
                return false;
            }
//        User user = userRepository.findByPassword(CookieValue);

            logActions.setComputerName(Commom.getComputerName());
            logActions.setUserWindow(Commom.getUserWindow());

            Optional<News> optionalNews = newsRepositoty.findById(id);
            News news = optionalNews.get();

            Optional<CategoryNews> categoryNewsOptional = categoryNewsRepository.findById(news.getCategoryId());
            CategoryNews categoryNews = categoryNewsOptional.get();
            logActions.setActionDescription("xóa tin tức - title :"+news.getTitle()+"  content:"+news.getContent()+"  createTime"+news.getCreateTime()+"  CategoryName:"+categoryNews.getName());
            logActions.setFormAction(Commom.news);
            Date date = new Date();
            Long createTimee = date.getTime();
            logActions.setTimeAction(createTimee);
            logActionsRepository.save(logActions);

            newsRepositoty.deleteById(id);
            return true;
        }
        return false;
    }

    @Override
    public News findById(Integer id) {
        if (id != null) {
            Optional<News> categoryNewsOptional = newsRepositoty.findById(id);
            if (categoryNewsOptional.isPresent()) {
                return categoryNewsOptional.get();
            }
        }
        return null;
    }
}
