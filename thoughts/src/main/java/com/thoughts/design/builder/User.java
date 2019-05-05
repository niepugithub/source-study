package com.thoughts.design.builder;

import lombok.Data;

/**
 * @description: 很多成员变量，使用有参构造器比较复杂，可以考虑使用建造者模式
 * @author:niepu
 * @version:1.0
 * @date:2019/5/5 22:30
 **/
@Data
public class User {
    private String name;// 必须
    private int age;// 非必须
    private String gender;// 非必须
    private String address;// 非必须

    // 构造器私有比较合理
    private User(Builder builder) {
        this.name = builder.name;
        this.age = builder.age;
        this.gender = builder.gender;
        this.address = builder.address;
    }


    public static class Builder {
        // 建造者内部类与外部需要创建对象成员一样
        private String name;
        private int age;
        private String gender;
        private String address;

        // 必须具有的成员
        public Builder(String name) {
            this.name = name;
        }

        public Builder age(int age) {
            this.age = age;
            return this;
        }

        public Builder gender(String gender) {
            this.gender = gender;
            return this;
        }

        public Builder address(String address) {
            this.address = address;
            return this;
        }

        public User builder() {
            return new User(this);
        }
    }

}
