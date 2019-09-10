/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.project4.repository;

import com.project4.entity.CategoryNews;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * @author admin
 */
@Repository
public interface CategoryNewsRepository extends JpaRepository<CategoryNews, Integer> {
    Optional<CategoryNews> findByName(String name);
}
