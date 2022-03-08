package com.Demo.SpringAOP.Aspect;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MyDemoLoggingAspect {

    @Pointcut("execution(* com.Demo.SpringAOP.DAO.*.*(..))")
    private void daoPackage(){}

    // create pointcut for getter methods
    @Pointcut("execution(* com.Demo.SpringAOP.DAO.*.get*(..))")
    private void getter() {}

    // create pointcut for setter methods
    @Pointcut("execution(* com.Demo.SpringAOP.DAO.*.set*(..))")
    private void setter() {}

    @Pointcut("daoPackage() && !(getter()|| setter() )")
    private void forDaoPackageNoGetterSetter() {}

    @Before("daoPackage()")
    public void beforeAddAccountAdvice()
    {
        System.out.println("\n=====>>> Executing @Before advice on addAccount()");
    }

    @After("forDaoPackageNoGetterSetter()")
    public void performApiAnalytics()
    {
        System.out.println("=====>>> Performing API Analytics");
    }

}
