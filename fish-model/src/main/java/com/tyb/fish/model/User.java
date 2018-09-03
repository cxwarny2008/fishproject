package com.tyb.fish.model;

import lombok.Data;

/**
 * 系统用户相关
 *
 * @author 陈小伟
 */
@Data
public class User {

    /**
     * 用户账号
     */
    private String userId;

    /**
     * 用户名称
     */
    private String userName;

    /**
     * 用户密码
     */
    private String password;

    /**
     * 用户电话号码
     */
    private String phone;
}
