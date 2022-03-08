package com.demo.SpringAnnotation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PostMapping;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@Component
@Scope("singleton")
public class TennisCoach implements Coach{

    @Autowired
    @Qualifier("randomFortuneService")
    private FortuneService fortuneService;

    public TennisCoach()
    {
        System.out.println("inside default constructor of tennisCoach");
    }
    /*   1) constructor auto-wiring
    @Autowired
    public TennisCoach(FortuneService fortuneService) {
        this.fortuneService = fortuneService;
    }
     */

/*
   @Autowired 2) setter auto-wire
    public void setFortuneService(FortuneService fortuneService) {
       System.out.println("inside setFortuneService");
        this.fortuneService = fortuneService;
    }

 */

    @Override
    public String getDailyWorkout() {
        return "Work on your back-Hand!!";
    }

    @Override
    public String getDailyFortune() {
        return fortuneService.getFortune();
    }

    //add init method


    @PostConstruct
    public void doMyStartupStuff()
    {
        System.out.println("inside the doMyStartupStuff method");
    }
    //add destroy method
    @PreDestroy
    public void doMyCleanupStuff()
    {
        System.out.println("inside the doMyCleanupStuff method");
    }
}
