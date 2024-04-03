package com.works;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
public class JpaRestApplication {

    public static void main(String[] args) {
        SpringApplication.run(JpaRestApplication.class, args);
    }

}
