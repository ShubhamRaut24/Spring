package com.demo.SpringJavaCodeConfig;

import com.demo.SpringAnnotation.FortuneService;

public class SadFortuneService implements FortuneService {
    @Override
    public String getFortune() {
        return "Tod@y is sad day!";
    }
}
