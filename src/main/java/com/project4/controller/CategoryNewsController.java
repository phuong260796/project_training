package com.project4.controller;

import com.project4.entity.CategoryNews;
import com.project4.entity.News;
import com.project4.service.CategoryNewsService;
import com.project4.serviceimpl.CategoryNewsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@RestController
@RequestMapping("/category")
public class CategoryNewsController {
    @Autowired
    private CategoryNewsService categoryService;

    @GetMapping("/updatedetail/{id}")
    public ModelAndView getById( @PathVariable  Integer id){
        CategoryNews categoryNews = categoryService.findById(id);
        ModelAndView model = new ModelAndView();
        model.addObject("categoryNews", categoryNews);
        model.setViewName("updatecatelory");
        return model;
    }

    @GetMapping(value= "/index")
    public ModelAndView welcome() {
        ModelAndView model = new ModelAndView();
        List<CategoryNews> categoryNews = categoryService.categoryNew();
        model.addObject("categoryNews", categoryNews);
        model.setViewName("index");
        return model;
    }


    @PostMapping("/add-update")
    public String addAndUpdate(@RequestBody CategoryNews categoryNews){
        if (categoryService.addAndUpdate(categoryNews)){
            return  "thêm thành công";
        }
        return "thêm thất bại";
    }

    @PostMapping("/delete")
    public String delete(@RequestBody CategoryNews categoryNews){
        if (categoryService.delete(categoryNews)){
            return  "Xóa thành công";
        }
        return "Xóa thất bại";
    }
}
