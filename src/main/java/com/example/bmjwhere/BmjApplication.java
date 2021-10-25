package com.example.bmjwhere;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@SpringBootApplication
public class BmjApplication {

    public static void main(String[] args) {
        SpringApplication.run(BmjApplication.class, args);
    }

}
