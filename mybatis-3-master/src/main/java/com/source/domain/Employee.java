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
}
