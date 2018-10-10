package com.tyb.fish.model;

import lombok.Data;

import java.text.SimpleDateFormat;
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
     * 生日Str
     */
    private String birthdayStr;

    public String getBirthdayStr() {
        Date birthDate=this.getBirthday();
        if (birthDate == null) {
            return null;
        }
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        return formatter.format(birthDate);
    }

    /**
     * 地址
     */
    private String address;

}