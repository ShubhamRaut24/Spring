package com.Demo.SpringAOP.Service;

import org.springframework.stereotype.Component;

import java.util.concurrent.TimeUnit;

@Component
public class TrafficFortuneService {

    public String getFortune()
    {
        try{

            TimeUnit.SECONDS.sleep(5);
        }catch (Exception e)
        {
            e.printStackTrace();
        }

        return "Expect Heavy Traffic This Morning..!";
    }
}
