package com.tyb.fish.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.sun.image.codec.jpeg.JPEGEncodeParam;
import com.tyb.fish.service.interfaces.IPersonService;
import com.tyb.fish.mapper.PersonMapper;
import com.tyb.fish.model.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.lang.model.element.VariableElement;
import java.util.List;

@Service(value = "personService")
public class PersonServiceImpl implements IPersonService {

    @Autowired
    private PersonMapper personMapper;

    @Override
    public Person loadPersonBySysNo(int sysNo) {
        return personMapper.selectByPrimaryKey(1);
    }

    @Override
    public List<Person> getPersonList() {
        return personMapper.getPersonList();
    }

    @Override
    public void insert(Person person) {
        personMapper.insert(person);
    }

    @Override
    public void updateByPrimaryKey(Person person) {
        personMapper.updateByPrimaryKey(person);
    }

    @Override
    public void deleteByPrimaryKey(int sysNo) {
        personMapper.deleteByPrimaryKey(sysNo);
    }

    @Override
    public PageInfo<Person> queryPersonList(Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum, pageSize, true);
        List<Person> personList = personMapper.getPersonList();
        return new PageInfo<Person>(personList);
    }
}
