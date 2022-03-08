package com.demo.one2one.Entity;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Bi_Direction_Demo {
    public static void main(String[] args) {
        // create session factory
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Instructor.class)
                .addAnnotatedClass(InstructorDetail.class)
                .buildSessionFactory();

        // create session
        Session session = factory.getCurrentSession();

        try {

            // start a transaction
            session.beginTransaction();

            int theId = 87;

            InstructorDetail instructorDetail = session.get(InstructorDetail.class,theId);

            System.out.println("The Instruction details are: "+instructorDetail);
            System.out.println("The Instructor is: "+instructorDetail.getInstructor());
            // commit transaction
            session.getTransaction().commit();

            System.out.println("Done!");
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        finally {
            session.close();
            factory.close();
        }

    }
}
