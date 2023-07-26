package com.example.qlnv.controller.login;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginController {
    @GetMapping(value = "/loginPage")
    public String login(){
        return "login";
    }
}
