package com.demo.WebCustomerTracker.Aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import java.util.logging.Logger;

@Aspect
@Component
public class CRMLoggingAspect {

    private Logger myLogger = Logger.getLogger(getClass().getName());

    //setup pointcut declarations
    @Pointcut("execution(* com.demo.WebCustomerTracker.Controller.*.*(..))")
    public void forControllerPackage(){}

    @Pointcut("execution(* com.demo.WebCustomerTracker.Service.*.*(..))")
    public void forServicePackage(){}

    @Pointcut("execution(* com.demo.WebCustomerTracker.DAO.*.*(..))")
    public void forDAOPackage(){}

    @Pointcut("forControllerPackage() || forServicePackage() || forDAOPackage()")
    public void forAppFlow(){}

    //add @Before Advice

    @Before("forAppFlow()")
    public void before(JoinPoint joinPoint)
    {
        String method = joinPoint.getSignature().toShortString();
        myLogger.info("=====>> in @Before: calling method: " + method);

        // display the arguments to the method
        // get the arguments
        Object[] args = joinPoint.getArgs();

        // loop thru and display args
        for (Object tempArg : args) {
            myLogger.info("=====>> Argument: " + tempArg);
        }
    }

    @AfterReturning(
            pointcut="forAppFlow()",
            returning="theResult")
    public void afterReturning(JoinPoint theJoinPoint, Object theResult) {

        // display method we are returning from
        String theMethod = theJoinPoint.getSignature().toShortString();
        myLogger.info("=====>> in @AfterReturning: from method: " + theMethod);

        // display data returned
        myLogger.info("=====>> Result: " + theResult);

    }



}
