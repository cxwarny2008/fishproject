package com.tyb.fishhost.controller;


import com.tyb.fishhost.expand.RedisAopCache;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Aop 测试类
 *
 * @author 陈小伟
 */
@RestController
@RequestMapping("aop")
@Api("Aop测试类")
public class AopController {

    /**
     * 获取人员姓名
     *
     * @param code
     * @return
     */
    @ApiParam(name = "code", value = "code", type = "String", required = true)
    @ApiOperation("获取人员姓名")
    @RequestMapping(value = "get/{code}", method = RequestMethod.GET)
    @RedisAopCache(type = String.class)
    public String getName(@PathVariable String code) throws Exception {
        if (code.equals("23")) {
            throw new Exception("ces");
        }
        return "测试人员";
    }
}
