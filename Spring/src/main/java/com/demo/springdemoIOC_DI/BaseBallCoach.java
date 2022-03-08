package com.demo.springdemoIOC_DI;

public class BaseBallCoach implements Coach {

//define the private field for dependency

    private FortuneService fortuneService;

    //create the constructor dependency Injection
    public BaseBallCoach(FortuneService fortuneService) {
        this.fortuneService = fortuneService;
    }

    public BaseBallCoach() {
    }

    @Override
    public String getDailyWorkout() {
        return "spend 30 min in gym";
    }

    @Override
    public String getDailyFortune() {

        // use my fortuneService to get fortune
        return fortuneService.getFortune();
    }
}
