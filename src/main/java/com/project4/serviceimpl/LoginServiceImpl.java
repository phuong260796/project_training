package com.project4.serviceimpl;

import com.project4.Commom.EncryptMd5;
import com.project4.entity.User;
import com.project4.repository.UserRepository;
import com.project4.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoginServiceImpl implements LoginService {

    @Autowired
    private UserRepository userRepository;


    @Override
    public Boolean checkLogin(User user) {
        EncryptMd5 encryptMd5 = new EncryptMd5();
        String EncryptMd5 = encryptMd5.encryMd5(user.getPassword());
        User use = userRepository.findByUserName(user.getUserName());
        if (userRepository.findByUserNameAndAndPassword(user.getUserName(), EncryptMd5) != null) {

            return true;
        }
        return false;
    }

    @Override
    public Boolean register(User user) {
        EncryptMd5 encryptMd5 = new EncryptMd5();
        String EncryptMd5 = encryptMd5.encryMd5(user.getPassword());
        user.setPassword(EncryptMd5);
        if (userRepository.findByUserName(user.getUserName()) != null) {
            return false;
        }
        userRepository.save(user);
        return true;
    }


}
