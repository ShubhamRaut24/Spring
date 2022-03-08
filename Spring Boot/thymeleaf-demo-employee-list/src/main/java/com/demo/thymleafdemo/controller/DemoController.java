package com.demo.thymleafdemo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Controller
public class DemoController {

    @GetMapping("/hello")
    public String sayHello(Model model)
    {
        model.addAttribute("theDate",new java.util.Date());

        return "hello-world";
    }

}
