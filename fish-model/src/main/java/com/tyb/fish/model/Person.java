package com.tyb.fish.model;

import lombok.Data;

import java.util.Date;

/**
 * Person实体类
 */
@Data
public class Person {

    /**
     * 编号
     */
    private Integer sysNo;

    /**
     * 姓名
     */
    private String name;

    /**
     * 性别
     */
    private Integer gender;

    /**
     * 年龄
     */
    private Integer age;

    /**
     * 生日
     */
    private Date birthday;

    /**
     * 地址
     */
    private String address;

}