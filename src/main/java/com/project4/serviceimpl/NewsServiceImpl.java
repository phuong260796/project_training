package com.project4.serviceimpl;

import com.project4.DTO.NewsDTO;
import com.project4.entity.News;
import com.project4.repository.NewsRepository;
import com.project4.service.NewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class NewsServiceImpl implements NewsService {

    @Autowired
    private NewsRepository newsRepositoty;

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
    public Boolean addNew(News news) {
        if (news == null) {
            return false;
        }
        News news1 = newsRepositoty.findByTitle(news.getTitle());
        if (news1 != null) {
            return false;
        }
        Date date = new Date();
        Long createTime = date.getTime();
        news.setCreateTime(createTime);
        newsRepositoty.save(news);
        return true;
    }

    @Override
    public Boolean delete(Integer id) {
        if (id != null) {
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
