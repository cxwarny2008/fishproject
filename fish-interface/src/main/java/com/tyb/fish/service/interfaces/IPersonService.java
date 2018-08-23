package com.tyb.fish.service.interfaces;

import com.github.pagehelper.PageInfo;
import com.tyb.fish.model.Person;
import com.tyb.fish.model.QueryFilter;
import com.tyb.fish.model.QueryPage;
import com.tyb.fish.model.QueryResult;

import java.util.List;

public interface IPersonService {
    Person loadPersonBySysNo(int sysNo);

    List<Person> getPersonList();

    void insert(Person person);

    void updateByPrimaryKey(Person person);

    void deleteByPrimaryKey(int sysNo);

    PageInfo<Person> queryPersonList(Integer pageNum, Integer pageSize);

    QueryResult<Person> selectWithCondition(QueryPage page);
}
