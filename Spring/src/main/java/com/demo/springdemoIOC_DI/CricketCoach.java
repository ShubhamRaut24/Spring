package com.demo.springdemoIOC_DI;

public class CricketCoach implements Coach {

    // inject literal values
    private String emailAddress;
    private  String team;



    private FortuneService fortuneService;

    // create no-arg constructor
    public CricketCoach()
    {
        System.out.println("inside no-arg cricketCoach constructor");
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public void setTeam(String team) {
        this.team = team;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public String getTeam() {
        return team;
    }

    // setter method
    public void setFortuneService(FortuneService fortuneService) {
        System.out.println("inside no-arg setter method");
        this.fortuneService = fortuneService;
    }

    @Override
    public String getDailyWorkout() {
        return "Practice batting for 2hr a day";
    }

    @Override
    public String getDailyFortune() {
        return fortuneService.getFortune();
    }


}
