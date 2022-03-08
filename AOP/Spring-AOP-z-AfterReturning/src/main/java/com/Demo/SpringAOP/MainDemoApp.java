package com.Demo.SpringAOP;

import com.Demo.SpringAOP.DAO.AccountDAO;
import com.Demo.SpringAOP.DAO.MembershipDAO;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MainDemoApp {

    public static void main(String[] args) {
        //read the spring config
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DemoConfig.class);

        //get the bean from container

        AccountDAO theAccountDAO = context.getBean("accountDAO",AccountDAO.class);

        MembershipDAO theMembershipDAO = context.getBean("membershipDAO",MembershipDAO.class);

        // call the business method
        Account myAccount = new Account();
        myAccount.setName("Madhu");
        myAccount.setLevel("Platinum");
        theAccountDAO.addAccount(myAccount, true);
        theAccountDAO.doWork();
        // call the accountDao getter/setter methods
        theAccountDAO.setName("foobar");
        theAccountDAO.setServiceCode("silver");

        String name = theAccountDAO.getName();
        String code = theAccountDAO.getServiceCode();

        // call the membership business method
        theMembershipDAO.addAccount();
        theMembershipDAO.goToSleep();

        // close the context
        context.close();
    }
}
