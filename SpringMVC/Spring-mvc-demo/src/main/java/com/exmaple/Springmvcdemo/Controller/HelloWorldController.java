package com.exmaple.Springmvcdemo.Controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import java.util.Locale;

@Controller
@RequestMapping("/hello")
public class HelloWorldController {

    //need a controller method to show initial HTML form

    @RequestMapping("/showForm")
    public String showForm()
    {
        return "helloworld-form";
    }


    //need a controller method to process HTML form

    @RequestMapping("/processForm")
    public String processForm()
    {
        return "helloworld";
    }

    //new controller method to read from form data and add it to model

    @RequestMapping("/processFormVersion2")
    public String letShoutDude(HttpServletRequest request, Model model)
    {
        String theName = request.getParameter("studentName");

        theName = theName.toUpperCase();

        String result = "YO !   "+ theName;

        model.addAttribute("message",result);

        return "helloworld";
    }

    @RequestMapping("/processFormVersion3")
    public String requestParams(@RequestParam("studentName") String theName, Model model)
    {

        theName = theName.toUpperCase();

        String result = "HEY..   "+ theName;

        model.addAttribute("message",result);

        return "helloworld";
    }
}
