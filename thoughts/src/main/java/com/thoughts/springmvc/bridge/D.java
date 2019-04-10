package com.thoughts.springmvc.bridge;

import java.lang.reflect.Method;

/**
 * @description:查看泛型方法在底层是有两个同名参数个数相同的方法存在的
 * @author:niepu
 * @version:1.0
 * @date:2019/4/10 22:15
 **/
public class D extends C<String> {
    @Override
    public String id(String x) {
        return x;
    }

    public static void main(String[] args) {
        Method[] methods = D.class.getMethods();
        /**
         * public java.lang.String com.thoughts.springmvc.bridge.D.id(java.lang.String)
         * public java.lang.Object com.thoughts.springmvc.bridge.D.id(java.lang.Object)
         */
        // 泛型方法，果然是有两个方法存在的，其实是Object方法调用String方法的
        // Object id(Object x){return id((String)x);}
        for (Method method : methods) {
            if (method.getName().equals("id")) {
                System.out.println(method);
            }
        }
    }
}
