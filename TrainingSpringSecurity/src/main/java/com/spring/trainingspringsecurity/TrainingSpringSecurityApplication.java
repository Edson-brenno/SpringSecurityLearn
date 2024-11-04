package com.spring.trainingspringsecurity;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EntityScan(basePackages = "com.spring.Entity")
@EnableJpaRepositories(basePackages = "com.spring.Repository")
@ComponentScan(basePackages = "com.spring")
public class TrainingSpringSecurityApplication {

    public static void main(String[] args) {
        SpringApplication.run(TrainingSpringSecurityApplication.class, args);
    }

}