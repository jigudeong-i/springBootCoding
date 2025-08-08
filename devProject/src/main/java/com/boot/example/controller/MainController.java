package com.boot.example.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller

public class MainController {

    @GetMapping("/")  //검색할 주소 http://localhost:8080/
    public String main(){
        return "/main";
    }
}
