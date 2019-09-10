package com.project4.repository;

import com.project4.entity.LogActions;
import com.project4.entity.News;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LogActionsRepository extends MongoRepository<LogActions, Integer> {
    List<LogActions> findAllByUserNameIsLike(String username);
}
