package com.demo.SpringJavaCodeConfig;

import com.demo.SpringAnnotation.Coach;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Swim_JavaConfigDemoApp {
    public static void main(String[] args) {

        // read the spring configure java class

        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(SportConfig.class);
        //get bean from spring container
         SwimCoach theCoach = context.getBean("swimCoach",SwimCoach.class); // default bean id used here

//        Coach theCoach = context.getBean(Coach.class);

        //call the method on bean
        System.out.println(theCoach.getDailyWorkout());
        System.out.println(theCoach.getDailyFortune());
        System.out.println(theCoach.getEmail());
        System.out.println(theCoach.getTeam());
        // close the context
      context.close();
    }
}
