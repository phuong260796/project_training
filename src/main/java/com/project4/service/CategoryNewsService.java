package com.project4.service;

import com.project4.DTO.LogActionsDTO;
import com.project4.entity.CategoryNews;
import com.project4.entity.LogActions;
import com.project4.entity.News;

import javax.persistence.criteria.CriteriaBuilder;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

public interface CategoryNewsService {

    List<CategoryNews> categoryNew();
    Boolean addAndUpdate(CategoryNews categoryNews/*,String CookieValue*/, HttpServletRequest httpServletRequest);
    Boolean delete(CategoryNews categoryNews, HttpServletRequest httpServletRequest);
    CategoryNews findById(Integer id);
    List<LogActionsDTO> getlog();
}
