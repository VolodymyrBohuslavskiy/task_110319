package com.task_110319.task_110319.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class startUpController {
    @GetMapping("/")
    public String hone(){
        return "forward:/index.html";
    }
}
