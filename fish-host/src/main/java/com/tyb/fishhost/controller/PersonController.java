package com.tyb.fishhost.controller;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageInfo;
import com.tyb.fish.service.interfaces.IPersonService;
import com.tyb.fish.model.Person;
import com.tyb.fishhost.depend.IComputeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
    private IPersonService personService;

    @RequestMapping("get")
    public String getPersonName() {
        int result = computeService.add(100, 100);
        return "test" + String.valueOf(result);
    }

    @RequestMapping("load/{sysNo}")
    public Person loadPerson(@PathVariable int sysNo) {
        return personService.loadPersonBySysNo(sysNo);
    }

    @RequestMapping("query")
    public PageInfo<Person> QueryPersonList(Integer pageNum, Integer pageSize) {
        return personService.queryPersonList(pageNum,pageSize);
    }
    @RequestMapping("list")
    public List<Person> GetPersonList() {
        return personService.getPersonList();
    }

    @RequestMapping(value = "add", method = RequestMethod.POST)
    public void AddPerson(@RequestBody Person person) {
        personService.insert(person);
    }


    @RequestMapping(value = "update", method = RequestMethod.POST)
    public void EditPerson(@RequestBody Person person) {
        personService.updateByPrimaryKey(person);
    }


    @RequestMapping(value = "delete/{sysNo}", method = RequestMethod.POST)
    public void DeletePerson(@PathVariable int sysNo) {
        personService.deleteByPrimaryKey(sysNo);
    }
}
