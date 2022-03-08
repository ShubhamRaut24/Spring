package com.demo.SpringAnnotation;

import org.springframework.stereotype.Component;

@Component
public class HappyFortuneService implements  FortuneService{

    @Override
    public String getFortune() {
        return "Today is your bad day!!";
    }
}
