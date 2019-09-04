package com.project4.controller;

import com.project4.Commom.EncryptMd5;
import com.project4.entity.User;
import com.project4.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.*;

@RestController
public class LoginController {
    @Autowired
    private LoginService loginService;

    @GetMapping("/login")
    public ModelAndView login(HttpServletResponse response,HttpServletRequest request){
        ModelAndView modelAndView = new ModelAndView();
        Cookie[] cookies = request.getCookies();
        if (cookies != null) {
            for(int i = 0; i< cookies.length ; i++){
                if(cookies[i].getName().equals("EncryptMd5")){
                    //Cookie cookie = new Cookie("user", cookies[i].getValue());
                    //cookie.setMaxAge(0);
                    //response.addCookie(cookie);
                    cookies[i].setMaxAge(0);
                    cookies[i].setHttpOnly(true);
                    response.addCookie(cookies[i]);
                }
            }
        }

        return modelAndView;
    }

    @GetMapping("/register")
    public ModelAndView register(){
        ModelAndView modelAndView = new ModelAndView();

        modelAndView.setViewName("register");
        return modelAndView;
    }

    @PostMapping("/check-login")
    private Boolean checkLogin(@RequestBody  User user,HttpServletResponse response){
        if(loginService.checkLogin(user)){
            EncryptMd5 encryptMd5 = new EncryptMd5();
            String EncryptMd5 = encryptMd5.encryMd5(user.getPassword());
            Cookie cookie = new Cookie("EncryptMd5",EncryptMd5);
            response.addCookie(cookie);
           return true;
        }
        return false;
    }

    @PostMapping("/register")
    private Boolean register(@RequestBody  User user){
        if(loginService.register(user)){
            return true;
        }
        return false;
    }


    @GetMapping("/ck")
    public String đaa(@CookieValue String EncryptMd5){

        return EncryptMd5;
    }


}
