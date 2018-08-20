package com.tyb.service.impl;

import com.tyb.fish.interfaces.IPersonService;
import com.tyb.fish.mapper.PersonMapper;
import com.tyb.fish.model.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service(value="personService")
public class PersonServiceImpl implements IPersonService {

    @Autowired
    PersonMapper personMapper;

    @Override
    public Person loadPersonBySysNo(int sysNo) {
        return personMapper.selectByPrimaryKey(1);
    }
}
