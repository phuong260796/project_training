package com.project4.service;

import com.project4.DTO.LogActionsDTO;
import com.project4.entity.CategoryNews;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

public interface CategoryNewsService {

    List<CategoryNews> categoryNew();

    Boolean addAndUpdate(CategoryNews categoryNews, HttpServletRequest httpServletRequest);

    Boolean delete(Integer id, HttpServletRequest httpServletRequest);

    Integer checkDelete(Integer id);

    CategoryNews findById(Integer id);

    List<LogActionsDTO> getlog();

    List<LogActionsDTO> getlogByUserName(String userName);
}
