package com.exmaple.Springmvcdemo.Controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {

    @RequestMapping("/")
    public String showPage()
    {
        return "main-menu";
    }
}

