package com.project4.service;

import com.project4.DTO.NewsDTO;
import com.project4.entity.News;

import java.util.List;

public interface NewsService {
    List<NewsDTO> getNewByCategoryId(Integer id);
    Boolean addNew(News news);
    Boolean delete(Integer id);
    News findById(Integer id);
}
