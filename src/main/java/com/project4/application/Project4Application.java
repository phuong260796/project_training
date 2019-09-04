package com.project4.application;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import org.springframework.scheduling.annotation.EnableAsync;

@SpringBootApplication(exclude = {SecurityAutoConfiguration.class })
@ComponentScan(value = "com.project4")
@EnableJpaRepositories("com.project4")
@EnableMongoRepositories("com.project4")
@EntityScan("com.project4")
public class Project4Application {
    public static void main(String[] args) {
        SpringApplication.run(Project4Application.class, args);
    }
}
