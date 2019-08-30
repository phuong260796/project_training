package com.project4.entity;

import java.util.Date;
import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "news")
@Data
public class News {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "title")
    private String title;

    @Column(name = "category_id")
    private Integer categoryId;

    @Column(name = "content")
    private String content;
    
     @Column(name = "active")
    private String active;
     
      @Column(name = "createTime")
    private Long createTime;

}
