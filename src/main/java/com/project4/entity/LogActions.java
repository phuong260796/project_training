package com.project4.entity;

import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.Id;
import java.math.BigInteger;

@Document("log_actions")
@Data
public class LogActions {

    @Id
    private BigInteger _id;

    private String computerName;

    private String userWindow;

    private String userName;
     
    private String actionDescription;

    private String formAction;

    private Long timeAction;


}
