package com.demo.SpringAnnotation;

import org.springframework.stereotype.Component;

@Component
public class DataBaseService implements FortuneService{
    @Override
    public String getFortune() {
        return null;
    }
}
