package com.SpringBoot.Demo.MyCoolApp.Rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;

@RestController
public class FunRestController {

    @GetMapping("/")
    public String sayHello()
    {
        return "Hello World!! Time on server is "+ LocalDateTime.now();
    }

    @GetMapping("/workout")
    public String workout()
    {
        return  "workout for 1 hour";
    }
    @GetMapping("/fortune")
    public String fortune()
    {
        return  "Today is lucky day!1!";
    }
}
