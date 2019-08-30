package com.project4.controller;

import com.project4.DTO.NewsDTO;
import com.project4.entity.CategoryNews;
import com.project4.entity.News;
import com.project4.service.CategoryNewsService;
import com.project4.service.NewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.sql.Timestamp;
import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/new")
public class NewsController {
    @Autowired
    private NewsService newsService;

    @Autowired
    private CategoryNewsService categoryService;

    @GetMapping("/get-news/{id}")
    public ModelAndView getCategory(@PathVariable Integer id) {
        ModelAndView model = new ModelAndView();
        List<NewsDTO> news = newsService.getNewByCategoryId(id);
        CategoryNews categoryNews = categoryService.findById(id);
        model.addObject("news", news);
        model.addObject("categoryId", id);
        model.addObject("name", categoryNews.getName());
        model.setViewName("news");
        return model;
    }


    @GetMapping("/updatenewsdetail/{id}")
    public ModelAndView getById(@PathVariable Integer id) {
        News updateNews = newsService.findById(id);
        ModelAndView model = new ModelAndView();
        model.addObject("updateNews", updateNews);
        model.setViewName("updatenews");
        return model;
    }

    @PostMapping("/add-update")
    public ResponseEntity addEndUpdate(@RequestBody News addObject) {
        if (newsService.addNew(addObject)) {
            return new ResponseEntity(HttpStatus.OK);
        }
        return new ResponseEntity(HttpStatus.EXPECTATION_FAILED);
    }

    @GetMapping("/add-news/{categoryId}")
    public ModelAndView addNew(@PathVariable Integer categoryId) {
        ModelAndView model = new ModelAndView();
        model.addObject("categoryId", categoryId);
        model.setViewName("addnews");
        return model;
    }

    @PostMapping("/delete/{id}")
    public ResponseEntity delete(@PathVariable Integer id) {
        if (newsService.delete(id)) {
            return new ResponseEntity(HttpStatus.OK);
        }
        return new ResponseEntity(HttpStatus.EXPECTATION_FAILED);
    }


}

