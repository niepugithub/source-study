package com.thoughts.springmvc.bridge;

import java.util.HashMap;
import java.util.Map;

/**
 * @description: 值传递测试
 * @author:niepu
 * @version:1.0
 * @date:2019/4/11 22:01
 **/
public class Test {

    Map<String, String> map = new HashMap<>();

    public static void main(String[] args) {
        Test test = new Test();
        test.map.put("aa", "111");
        test.map.put("bb", "222");
        test.map.put("cc", "333");
        // 这里传递完值之后，map自身还是保持原样的！！！至于方法入参接收到
        // 这个之后，想怎么办，那是他自己的事
        change(test.map);
        System.out.println("3333" + test.map);
    }

    public static void change(Map map1) {
        System.out.println("1111" + map1);
        map1 = new HashMap();
        System.out.println("2222" + map1);
    }
}
