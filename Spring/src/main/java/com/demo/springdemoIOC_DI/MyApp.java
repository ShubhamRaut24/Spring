package com.demo.springdemoIOC_DI;

public class MyApp {
    public static void main(String[] args) {
        // create object
        Coach theCoach = new BaseBallCoach();

        // use object

        System.out.println(theCoach.getDailyWorkout());
    }
}
