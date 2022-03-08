package com.Demo.SpringAOP.Aspect;


import com.Demo.SpringAOP.Account;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Order(2)
public class MyDemoLoggingAspect {

    @Before("com.Demo.SpringAOP.Aspect.LuvAopExpressions.forDaoPackageNoGetterSetter()")
    public void beforeAddAccountAdvice(JoinPoint point) {
        System.out.println("=====>>> Executing @Before advice on method");

        // display method signature
        MethodSignature signature = (MethodSignature) point.getSignature();
        System.out.println("Method:"+signature);

        // display the arguments
        Object[] agres = point.getArgs();

        for(Object temp : agres)
        {
            System.out.println(temp);

            if (temp instanceof Account) {

                // downcast and print Account specific stuff
                Account theAccount = (Account) temp;

                System.out.println("account name: " + theAccount.getName());
                System.out.println("account level: " + theAccount.getLevel());

            }


        }

    }

}
