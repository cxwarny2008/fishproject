package com.tyb.fish.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.tyb.fish.mapper.PersonMapper;
import com.tyb.fish.model.Person;
import com.tyb.fish.model.QF_Person;
import com.tyb.fish.model.QueryResult;
import com.tyb.fish.service.interfaces.IPersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * PersonService
 *
 * @author Garry
 */
@Service(value = "personService")
public class PersonServiceImpl implements IPersonService {

    @Autowired
    private PersonMapper personMapper;

    /**
     * 加载人员信息
     *
     * @param sysNo
     * @return
     */
    @Override
    public Person loadPersonBySysNo(int sysNo) {
        return personMapper.loadPersonBySysNo(sysNo);
    }

    /**
     * 获取人员列表
     *
     * @param qfPerson
     * @return
     */
    @Override
    public List<Person> getPersonList(QF_Person qfPerson) {
        return personMapper.getPersonList(qfPerson);
    }

    /**
     * 新增人员
     *
     * @param person
     */
    @Override
    public void insertPerson(Person person) {
        personMapper.insertPerson(person);
    }

    /**
     * 更新人员
     *
     * @param person
     */
    @Override
    public void updatePerson(Person person) {
        personMapper.updatePerson(person);
    }

    /**
     * 删除人员
     *
     * @param sysNo
     */
    @Override
    public void deletePerson(int sysNo) {
        personMapper.deletePerson(sysNo);
    }

    /**
     * 分页查询人员
     *
     * @param filter
     * @return
     */
    @Override
    public QueryResult<Person> queryPersonList(QF_Person filter) {
        return personMapper.queryPersonList(filter).getQueryResult();
    }

   /*
    @Override
    public PageInfo<Person> queryPersonListPageHelper(Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum, pageSize, true);
        List<Person> personList = personMapper.queryPersonList();
        return new PageInfo<Person>(personList);
    }
    */


}
