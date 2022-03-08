package com.demo.SpringJavaCodeConfig;

import com.demo.SpringAnnotation.Coach;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class JavaConfigDemoApp {
    public static void main(String[] args) {

        // read the spring configure java class

        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(SportConfig.class);
        //get bean from spring container
         Coach theCoach = context.getBean(Coach.class); // default bean id used here

//        Coach theCoach = context.getBean(Coach.class);

        //call the method on bean
        System.out.println(theCoach.getDailyWorkout());
        System.out.println(theCoach.getDailyFortune());
        // close the context
      context.close();
    }
}
