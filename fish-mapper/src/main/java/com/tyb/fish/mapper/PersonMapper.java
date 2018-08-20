package com.tyb.fish.mapper;

import com.tyb.fish.model.Person;

import java.util.List;

public interface PersonMapper {
    int deleteByPrimaryKey(Integer sysNo);

    int insert(Person record);

    int insertSelective(Person record);

    Person selectByPrimaryKey(Integer sysNo);

    int updateByPrimaryKeySelective(Person record);

    int updateByPrimaryKey(Person record);

    List<Person> getPersonList();
}