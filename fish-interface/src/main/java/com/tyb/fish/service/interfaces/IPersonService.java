package com.tyb.fish.service.interfaces;

import com.github.pagehelper.PageInfo;
import com.tyb.fish.model.*;

import java.util.List;

public interface IPersonService {
    Person loadPersonBySysNo(int sysNo);

    List<Person> getPersonList(QF_Person qfPerson);

    void insert(Person person);

    void updateByPrimaryKey(Person person);

    void deleteByPrimaryKey(int sysNo);

    PageInfo<Person> queryPersonList(Integer pageNum, Integer pageSize);

    QueryResult<Person> selectWithCondition(QF_Person page);
}
