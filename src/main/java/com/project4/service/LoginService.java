package com.project4.service;

import com.project4.entity.User;

public interface LoginService {
    Boolean checkLogin(User user);

    Boolean register(User user);

}
