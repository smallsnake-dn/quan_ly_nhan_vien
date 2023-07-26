package com.example.qlnv;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;

@SpringBootApplication
@EnableWebSecurity
public class Demo1Application {


    public static void main(String[] args) {
//        IMG_DIR = "/opt/img/";
        SpringApplication.run(Demo1Application.class, args);
    }

}
