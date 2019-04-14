package com.source.domain;

import lombok.Data;

/**
 * @description:
 * @author:niepu
 * @version:1.0
 * @date:2019/4/5 13:44
 **/

@Data
public class Employee {
    private long id;
    private String lastName;
    private String email;
    private String gender;
    private long did;
    private String empStatus;

    public Employee(long id, String lastName, String email, String gender, long did, String empStatus) {
        this.id = id;
        this.lastName = lastName;
        this.email = email;
        this.gender = gender;
        this.did = did;
        this.empStatus = empStatus;
    }

    public Employee(String lastName, String email, String gender, long did, String empStatus) {
        this.lastName = lastName;
        this.email = email;
        this.gender = gender;
        this.did = did;
        this.empStatus = empStatus;
    }

    public Employee() {
    }
}
