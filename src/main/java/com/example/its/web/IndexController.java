package com.example.its.web;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class IndexController {
    //handle GET /
    @GetMapping //@GetMapping{"/"}
    public String index(){
        return "index";
    }
}
