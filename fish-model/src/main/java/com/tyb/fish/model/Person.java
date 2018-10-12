package com.tyb.fish.model;

import com.tyb.fish.core.DateHelper;
import com.tyb.fish.model.Enum.EGender;
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
    private EGender gender;

    /**
     * 性别Str
     */
    private String genderStr;

    public String getGenderStr() {
        return this.getGender().getDisplayName();
    }

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
        return DateHelper.DateToString(this.getBirthday(), "yyyy-MM-dd");
    }

    /**
     * 地址
     */
    private String address;

}