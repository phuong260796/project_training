package com.project4.serviceimpl;


import com.project4.Commom.Commom;
import com.project4.DTO.LogActionsDTO;
import com.project4.entity.CategoryNews;
import com.project4.entity.LogActions;
import com.project4.entity.News;
import com.project4.entity.User;
import com.project4.repository.CategoryNewsRepository;
import com.project4.repository.LogActionsRepository;
import com.project4.repository.NewsRepository;
import com.project4.repository.UserRepository;
import com.project4.service.CategoryNewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class CategoryNewsServiceImpl implements CategoryNewsService {

    @Autowired
    private CategoryNewsRepository categoryNewsRepositoty;

    @Autowired
    private NewsRepository newsRepository;

    @Autowired
    private LogActionsRepository logActionsRepository;

    @Autowired
    private UserRepository userRepository;

    @PersistenceContext
    private EntityManager entityManager;




    @Override
    public List<CategoryNews> categoryNew() {
        String sqlString = "select * from category_new cn where cn.active =\"Y\"  ";
        return entityManager.createNativeQuery(sqlString,CategoryNews.class).getResultList();
    }

    @Override
    public Boolean addAndUpdate(CategoryNews categoryNews/*, String CookieValue*/, HttpServletRequest httpServletRequest) {
        if (categoryNews == null) {
            return false;
        }
        if (categoryNews.getId() == null) {
            Optional<CategoryNews> ob = categoryNewsRepositoty.findByName(categoryNews.getName());
            if (ob.isPresent()) {
                return false;
            }
        }
        if (categoryNews.getId()!=null){
            Cookie[] cookies = httpServletRequest.getCookies();
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

            Optional<CategoryNews> ctnew = categoryNewsRepositoty.findById(categoryNews.getId());
            if (ctnew.isPresent()){
                CategoryNews category = ctnew.get();
                logActions.setActionDescription("sửa danh mục -"+category.getName()+" ==>"+ categoryNews.getName() );
            }

            logActions.setFormAction(Commom.updateCategory);
            Date date = new Date();
            Long createTime = date.getTime();
            logActions.setTimeAction(createTime);
            logActionsRepository.save(logActions);

            categoryNewsRepositoty.save(categoryNews);
            return true;
        }

        Cookie[] cookies = httpServletRequest.getCookies();
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

            logActions.setActionDescription("thêm danh mục -"+categoryNews.getName());
            logActions.setFormAction(Commom.index);
            Date date = new Date();
            Long createTime = date.getTime();
            logActions.setTimeAction(createTime);
            logActionsRepository.save(logActions);

            categoryNewsRepositoty.save(categoryNews);
            return true;

    }

    @Override
    public Boolean delete(CategoryNews categoryNews, HttpServletRequest httpServletRequest) {
        if (categoryNews.getId() != null) {
            List<News> listNews = newsRepository.findAllByCategoryId(categoryNews.getId());
            if (!CollectionUtils.isEmpty(listNews)) {
                newsRepository.deleteAll(listNews);
            }
            Cookie[] cookies = httpServletRequest.getCookies();
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

            logActions.setActionDescription("xóa danh mục -"+categoryNews.getName());
            logActions.setFormAction(Commom.index);
            Date date = new Date();
            Long createTime = date.getTime();
            logActions.setTimeAction(createTime);
            logActionsRepository.save(logActions);

            categoryNewsRepositoty.deleteById(categoryNews.getId());
            return true;
        }
        return false;
    }

    @Override
    public CategoryNews findById(Integer id) {
        if (id != null) {

            Optional<CategoryNews> categoryNewsOptional = categoryNewsRepositoty.findById(id);
            if (categoryNewsOptional.isPresent()) {
                return categoryNewsOptional.get();
            }
        }
        return null;
    }

    @Override
    public List<LogActionsDTO> getlog() {
        List<LogActions> logActions = logActionsRepository.findAll();
        List<LogActionsDTO> logActionsDTOS = new ArrayList<>();
        for (int i=0;i<logActions.size();i++){
            LogActionsDTO logActionsDTO = new LogActionsDTO();
            String dateformat = new java.text.SimpleDateFormat("MM/dd/yyyy HH:mm:ss").format(new java.util.Date(logActions.get(i).getTimeAction()));
            logActionsDTO.setId(i+1);
            logActionsDTO.setActionDescription(logActions.get(i).getActionDescription());
            logActionsDTO.setComputerName(logActions.get(i).getComputerName());
            logActionsDTO.setFormAction(logActions.get(i).getFormAction());
            logActionsDTO.setUserName(logActions.get(i).getUserName());
            logActionsDTO.setUserWindow(logActions.get(i).getUserWindow());
            logActionsDTO.setTimeAction(dateformat);
            logActionsDTOS.add(logActionsDTO);
        }
       return logActionsDTOS;
}

}
