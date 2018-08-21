package com.tyb.fish.service.impl;

import com.tyb.fish.service.interfaces.IPersonService;
import com.tyb.fish.mapper.PersonMapper;
import com.tyb.fish.model.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
}
