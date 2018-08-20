package com.tyb.fishhost.controller;

import com.tyb.fish.interfaces.IPersonService;
import com.tyb.fish.model.Person;
import com.tyb.fishhost.depend.IComputeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author 陈小伟
 * @version V1.0
 * @Title: 启动类
 * @Package com.yzw.cloudhost
 * @Description: 启动类
 * @date 2018-08-17
 */
@RestController
@RequestMapping("person")
public class PersonController {

    @Autowired
    private IComputeService computeService;


    @Autowired
    IPersonService personService;

    @RequestMapping("get")
    public String getPersonName() {
        int result = computeService.add(100, 100);
        return "test" + String.valueOf(result);
    }

    @RequestMapping("load/{sysNo}")
    public Person loadPerson(@PathVariable int sysNo) {
        return personService.loadPersonBySysNo(sysNo);
    }

}
