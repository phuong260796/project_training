package com.project4.service;

import com.project4.entity.CategoryNews;
import com.project4.entity.News;

import javax.persistence.criteria.CriteriaBuilder;
import java.util.List;

public interface CategoryNewsService {

    List<CategoryNews> categoryNew();
    Boolean addAndUpdate(CategoryNews categoryNews);
    Boolean delete(CategoryNews categoryNews);
    CategoryNews findById(Integer id);
}
