package com.project4.serviceimpl;


import com.project4.constant.Constant;
import com.project4.entity.CategoryNews;
import com.project4.entity.News;
import com.project4.repository.CategoryNewsRepository;
import com.project4.repository.NewsRepository;
import com.project4.service.CategoryNewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;
import java.util.Optional;

@Service
public class CategoryNewsServiceImpl implements CategoryNewsService {

    @Autowired
    private CategoryNewsRepository categoryNewsRepositoty;

    @Autowired
    private NewsRepository newsRepository;

    @PersistenceContext
    private EntityManager entityManager;


    @Override
    public List<CategoryNews> categoryNew() {
        String sqlString = "select * from category_new cn where cn.active =\"Y\"  ";
        return entityManager.createNativeQuery(sqlString).getResultList();
    }

    @Override
    public Boolean addAndUpdate(CategoryNews categoryNews) {
        if (categoryNews == null) {
            return false;
        }
        if (categoryNews.getId() == null) {
            Optional<CategoryNews> ob = categoryNewsRepositoty.findByName(categoryNews.getName());
            if (ob.isPresent()) {
                return false;
            }
        }
        categoryNewsRepositoty.save(categoryNews);
        return true;
    }

    @Override
    public Boolean delete(CategoryNews categoryNews) {
        if (categoryNews.getId() != null) {
            List<News> listNews = newsRepository.findAllByCategoryId(categoryNews.getId());
            if (!CollectionUtils.isEmpty(listNews)) {
                newsRepository.deleteAll(listNews);
            }
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


}
