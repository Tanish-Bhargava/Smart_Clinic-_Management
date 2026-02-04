package com.example.demo;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class WebController {

    // HOME PAGE
    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("welcomeMessage", "Welcome to my Spring Boot App!");
        return "index";   // templates/index.html
    }

}