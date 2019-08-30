package com.project4.repository;

import com.project4.entity.News;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface NewsRepository extends JpaRepository<News,Integer> {
//    Optional<News> findById(Integer id);
    List<News> findAllByCategoryId(Integer categoryId);
    News findByTitle(String title);
}
