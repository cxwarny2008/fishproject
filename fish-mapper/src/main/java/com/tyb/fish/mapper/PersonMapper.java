package com.tyb.fish.mapper;

import com.tyb.fish.model.Person;
import com.tyb.fish.model.QueryFilter;
import com.tyb.fish.model.QueryPage;
import com.tyb.fish.model.QueryResult;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface PersonMapper {
    int deleteByPrimaryKey(Integer sysNo);

    int insert(Person record);

    int insertSelective(Person record);

    Person selectByPrimaryKey(Integer sysNo);

    int updateByPrimaryKeySelective(Person record);

    int updateByPrimaryKey(Person record);

    List<Person> getPersonList();

    List<Person> queryPersonList();

    QueryPage<Person> selectWithPage(@Param("page") QueryPage page);

}