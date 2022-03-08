package com.demo.SpringAnnotation;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AnnotationBeanScopeDemoApp {

    public static void main(String[] args) {


        // read the spring configure file

        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

        Coach theCoach = context.getBean( Coach.class);
        Coach alphaCoach = context.getBean( Coach.class);

        // check the bean scope

        boolean result = (theCoach == alphaCoach);

        //display results
        System.out.println("\nPointing to the same object : "+result);
        System.out.println("\nMemory location of theCoach : "+theCoach);
        System.out.println("\nMemory location of alphaCoach : "+alphaCoach);

        context.close();
    }
}
