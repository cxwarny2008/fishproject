package com.tyb.fish.model;

import lombok.Data;

/**
 * Person实体类
 */
@Data
public class Person {

    /**
     * 人员编号
     */
    private Integer sysNo;

    /**
     * 人员姓名
     */
    private String name;
}