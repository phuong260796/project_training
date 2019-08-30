package com.project4.DTO;

import lombok.Data;

@Data
public class NewsDTO {

    private Integer id;

    private String title;

    private Integer categoryId;

    private String content;
    
    private String active;
     
    private String createTime;
    
}
