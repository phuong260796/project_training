package com.project4.repository;

import com.project4.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {
    User findByUserNameAndAndPassword(String userName, String Pass);

    User findByUserName(String userName);

}
