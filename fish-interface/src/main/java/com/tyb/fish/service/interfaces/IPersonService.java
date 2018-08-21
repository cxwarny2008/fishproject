package com.tyb.fish.service.interfaces;

import com.tyb.fish.model.Person;

import java.util.List;

public interface IPersonService {
    Person loadPersonBySysNo(int sysNo);

    List<Person> getPersonList();

    void insert(Person person);

    void updateByPrimaryKey(Person person);

    void deleteByPrimaryKey(int sysNo);
}
