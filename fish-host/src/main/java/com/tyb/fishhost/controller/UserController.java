package com.tyb.fishhost.controller;

import com.tyb.fish.model.User;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * 用户相关API
 *
 * @author 陈小伟
 */
@Api(value = "用户相关API")
@RestController
@RequestMapping("user")
public class UserController {

    /**
     * 用户登录
     *
     * @param loginUser
     * @return
     */
    @ApiOperation(value = "用户登录")
    @ApiImplicitParam(name = "loginUser", value = "用户账户与密码", required = true, dataType = "User")
    @RequestMapping(value = "login", method = RequestMethod.POST)
    public User Login(@RequestBody User loginUser) {
        loginUser.setUserId("cxw");
        loginUser.setUserName("测试用户");
        loginUser.setPhone("15989877876");
        return loginUser;
    }

}
