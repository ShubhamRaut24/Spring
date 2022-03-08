package com.Demo.SpringAOP.Aspect;


import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Order(-2)
public class MyDemoLoggingAspect {

    @Before("com.Demo.SpringAOP.Aspect.LuvAopExpressions.forDaoPackageNoGetterSetter()")
    public void beforeAddAccountAdvice() {
        System.out.println("=====>>> Executing @Before advice on method");
    }

}
