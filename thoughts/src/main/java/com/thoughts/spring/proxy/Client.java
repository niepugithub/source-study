package com.thoughts.spring.proxy;

import org.springframework.aop.framework.Advised;
import org.springframework.aop.framework.AopConfigException;
import org.springframework.aop.framework.ProxyFactory;

/**
 * @description: 观察advice和advisor，adviced的区别
 * <p>
 * Advised:   包含所有的Advised 和 Advice
 * Advice:    通知拦截器
 * Advisor:   通知 + 切入点的适配器
 * @author:niepu
 * @version:1.0
 * @date:2019/4/20 12:49
 **/
public class Client {

    public static void main(String[] args) throws Exception, AopConfigException {
        ProxyFactory proxyFactory = new ProxyFactory();
        proxyFactory.setTarget(new HelloWorld());

        // 1.分别 添加前置增强 、后置增强
        // proxyFactory.addAdvice(new HelloBeforeAdvice());
        // proxyFactory.addAdvice(new HelloAfterAdvice());

        // 2.同时 实现前置增强、后置增强
        // proxyFactory.addAdvice(new HelloBeforeAfterAdvice());

        // 3.环绕增强
        // proxyFactory.addAdvice(new HelloAroundAdvice());
        // proxyFactory.addAdvice(new HelloThrowAdvice());
        HelloWorld hello = (HelloWorld) proxyFactory.getProxy();
        Advised advised = (Advised) hello;
        advised.addAdvice(new HelloBeforeAdvice());
        advised.addAdvice(new HelloAfterAdvice());
        System.out.println(hello instanceof Advised);

        hello.sayHello();

    }

}
