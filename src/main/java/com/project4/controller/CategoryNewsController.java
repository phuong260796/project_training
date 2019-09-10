package com.project4.controller;

import com.project4.DTO.LogActionsDTO;
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
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping
public class CategoryNewsController {
    @Autowired
    private CategoryNewsService categoryService;


    @GetMapping("/updatedetail/{id}")
    public ResponseEntity<CategoryNews> getById(@PathVariable Integer id) {
        CategoryNews categoryNews = categoryService.findById(id);
        return new ResponseEntity<>(categoryNews, HttpStatus.OK);
    }

    @GetMapping()
    public ModelAndView welcome() {
        ModelAndView model = new ModelAndView();
        List<CategoryNews> categoryNews = categoryService.categoryNew();
        model.addObject("categoryNews", categoryNews);
        model.setViewName("indexxx");
        return model;
    }


    @PostMapping("/add-update")
    public Boolean addAndUpdate(@RequestBody CategoryNews categoryNews, HttpServletRequest request) {
        if (categoryService.addAndUpdate(categoryNews, request)) {
            return true;
        }
        return false;
    }

    @PostMapping("/delete/{id}")
    public ResponseEntity delete(@PathVariable Integer id, HttpServletRequest httpServletRequest) {
        if (categoryService.delete(id, httpServletRequest)) {
            return new ResponseEntity(HttpStatus.OK);
        }
        return new ResponseEntity(HttpStatus.NOT_FOUND);
    }

    @GetMapping("/check-delete/{id}")
    public ResponseEntity checkDelete(@PathVariable Integer id) {
        Integer newsByCategoryId = categoryService.checkDelete(id);
        return new ResponseEntity(newsByCategoryId, HttpStatus.OK);
    }


    @GetMapping(value = {"/check-log", "/check-log/{userName}"})
    public ModelAndView getLogByUserName(@PathVariable(required = false) Optional<String> userName) {
        ModelAndView model = new ModelAndView();
        if (!userName.isPresent()) {
            model.addObject("log", categoryService.getlog());
        } else {
            model.addObject("log", categoryService.getlogByUserName(userName.get()));
            model.addObject("inputSearch", userName.get());
        }
        model.setViewName("checklog");
        return model;
    }

}
