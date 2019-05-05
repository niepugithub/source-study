package com.thoughts.design;

import com.thoughts.design.builder.User;
import org.junit.Test;

/**
 * @description:
 * @author:niepu
 * @version:1.0
 * @date:2019/5/5 22:38
 **/
public class PatternTest {


    // 测试建造者模式
    @Test
    public void testBuilder() {
        User user = new User.Builder("必须要有姓名").builder();
        System.out.println(user);

        user = new User.Builder("哈哈").age(10).gender("男").address("杭州").builder();
        System.out.println(user);
    }
}
