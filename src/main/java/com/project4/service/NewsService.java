package com.project4.service;

import com.project4.DTO.NewsDTO;
import com.project4.entity.News;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

public interface NewsService {
    List<NewsDTO> getNewByCategoryId(Integer id);

    Boolean addNew(News news, HttpServletRequest ttpServletRequest);

    Boolean delete(Integer id, HttpServletRequest ttpServletRequest);

    News findById(Integer id);
}
