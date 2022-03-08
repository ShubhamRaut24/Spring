package com.demo.SpringAnnotation;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AnnotationDemoApp {
    public static void main(String[] args) {

        // read the spring configure file

        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        //get bean from spring container
         Coach theCoach = context.getBean("tennisCoach",Coach.class); // default bean id used here

//        Coach theCoach = context.getBean(Coach.class);

        //call the method on bean
        System.out.println(theCoach.getDailyWorkout());
        System.out.println(theCoach.getDailyFortune());
        // close the context
      context.close();
    }
}
