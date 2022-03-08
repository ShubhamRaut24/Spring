package com.demo.springdemoIOC_DI;

public class HappyFortuneService implements FortuneService{
    @Override
    public String getFortune() {
        return "Today is your lucky day!!!";
    }
}
