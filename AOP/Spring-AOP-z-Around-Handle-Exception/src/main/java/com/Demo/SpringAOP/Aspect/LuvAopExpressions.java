package com.Demo.SpringAOP.Aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class LuvAopExpressions {

    @Pointcut("execution(* com.Demo.SpringAOP.DAO.*.*(..))")
    public void daoPackage(){}

    // create pointcut for getter methods
    @Pointcut("execution(* com.Demo.SpringAOP.DAO.*.get*(..))")
    public void getter() {}

    // create pointcut for setter methods
    @Pointcut("execution(* com.Demo.SpringAOP.DAO.*.set*(..))")
    public void setter() {}

    @Pointcut("daoPackage() && !(getter()|| setter() )")
    public void forDaoPackageNoGetterSetter() {}
}
