package com.tyb.fishhost.controller;

import com.tyb.fish.model.Person;
import com.tyb.fish.model.QF_Person;
import com.tyb.fish.model.QueryResult;
import com.tyb.fish.service.interfaces.IPersonService;
import com.tyb.fishhost.depend.IComputeService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author 陈小伟
 * @version V1.0
 * @Title: 启动类
 * @Package com.yzw.cloudhost
 * @Description: 启动类
 * @date 2018-08-17
 */
@Api(value = "Person服务", description = "PersonRest接口")
@RestController
@RequestMapping("person")
public class PersonController {

    @Autowired
    private IComputeService computeService;

    @Autowired
    private IPersonService personService;

    @ApiOperation(value = "Feign客户端测试类")
    @RequestMapping(value = "get", method = RequestMethod.GET)
    public String getPersonName() {
        int result = computeService.add(100, 100);
        return "test" + String.valueOf(result);
    }

    /**
     * 通过SysNo加载人员信息
     *
     * @param sysNo
     * @return Person
     */
    @ApiOperation(value = "加载人员信息")
    @ApiImplicitParam(name = "sysNo", value = "用户sysNo", required = true, dataType = "Integer", paramType = "path")
    @RequestMapping(value = "load/{sysNo}", method = RequestMethod.GET)
    public Person loadPerson(@PathVariable int sysNo) {
        return personService.loadPersonBySysNo(sysNo);
    }

    /**
     * 新增人员
     *
     * @param person
     */
    @ApiOperation(value = "新增人员")
    @ApiImplicitParam(name = "person", value = "Person属性值", required = true, dataType = "Person")
    @RequestMapping(value = "add", method = RequestMethod.POST)
    public void addPerson(@RequestBody Person person) {
        personService.insertPerson(person);
    }

    /**
     * 编辑人员信息
     *
     * @param person
     */
    @ApiOperation(value = "编辑人员信息")
    @ApiImplicitParam(name = "person", value = "Person属性值", required = true, dataType = "Person")
    @RequestMapping(value = "update", method = RequestMethod.POST)
    public void editPerson(@RequestBody Person person) {
        personService.updatePerson(person);
    }

    /**
     * 删除人员信息
     *
     * @param sysNo
     */
    @ApiOperation(value = "删除人员信息")
    @ApiImplicitParam(name = "sysNo", value = "sysNo值", required = true, dataType = "Integer", paramType = "path")
    @RequestMapping(value = "delete/{sysNo}", method = RequestMethod.POST)
    public void deletePerson(@PathVariable int sysNo) {
        personService.deletePerson(sysNo);
    }

    /**
     * 分页查询人员信息
     *
     * @param qfPerson
     * @return
     */
    @ApiOperation(value = "分页查询人员信息")
    @ApiImplicitParam(name = "qfPerson", value = "qfPerson属性值", required = true, dataType = "QF_Person")
    @RequestMapping(value = "query", method = RequestMethod.POST)
    public QueryResult<Person> QueryPersonList(QF_Person qfPerson) {
        return personService.queryPersonList(qfPerson);
    }

}
