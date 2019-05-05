package com.thoughts.spring.proxy;

import org.springframework.aop.MethodBeforeAdvice;

import java.lang.reflect.Method;

/**
 * @description:
 * @author:niepu
 * @version:1.0
 * @date:2019/4/20 12:54
 **/
public class HelloBeforeAdvice implements MethodBeforeAdvice {
    @Override
    public void before(Method method, Object[] args, Object target) throws Throwable {
        System.out.println("MethodBeforeAdvice前前前置增强通知");
//        System.out.println("method.getName() :" + method.getName());
//        System.out.println("target.getClass() :" + target.getClass());
//        System.out.println("target :" + target);
    }
}
