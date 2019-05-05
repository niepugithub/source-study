package com.thoughts.spring.proxy;

import org.springframework.aop.AfterReturningAdvice;

import java.lang.reflect.Method;

/**
 * @description:
 * @author:niepu
 * @version:1.0
 * @date:2019/4/20 12:56
 **/
public class HelloAfterAdvice implements AfterReturningAdvice {

    @Override
    public void afterReturning(Object returnValue, Method method, Object[] args, Object target) throws Throwable {
        System.out.println("AfterReturningAdvice后置增强");
    }
}
