package com.project4.controller;

import com.project4.entity.CategoryNews;
import com.project4.entity.LogActions;
import com.project4.entity.News;
import com.project4.entity.User;
import com.project4.service.CategoryNewsService;
import com.project4.serviceimpl.CategoryNewsServiceImpl;
import com.project4.serviceimpl.LoginServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.List;

@RestController
@RequestMapping
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

    @GetMapping()
    public ModelAndView welcome(HttpServletRequest request) {
        Cookie[] cookies = request.getCookies();
        ModelAndView model = new ModelAndView();
        List<CategoryNews> categoryNews = categoryService.categoryNew();
        model.addObject("categoryNews", categoryNews);
        model.setViewName("index");
        return model;
    }


    @PostMapping("/add-update")
    public String addAndUpdate(@RequestBody CategoryNews categoryNews,/*@CookieValue( required = false) String cookieValue,*/HttpServletRequest request){
        if (categoryService.addAndUpdate(categoryNews/*,cookieValue*/,request)){
            return  "thêm thành công";
        }
        return "thêm thất bại";
    }

    @PostMapping("/delete")
    public String delete(@RequestBody CategoryNews categoryNews, HttpServletRequest httpServletRequest){
        if (categoryService.delete(categoryNews,httpServletRequest)){
            return  "Xóa thành công";
        }
        return "Xóa thất bại";
    }

    @GetMapping("/check-log")
    public ModelAndView getLog(){
        ModelAndView model = new ModelAndView();
        model.addObject("log",categoryService.getlog());
        model.setViewName("checklog");
        return model;
    }

}
