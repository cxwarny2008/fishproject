package com.tyb.fish.mapper;

import com.tyb.fish.model.*;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface PersonMapper {
    int deleteByPrimaryKey(Integer sysNo);

    int insert(Person record);

    int insertSelective(Person record);

    Person selectByPrimaryKey(Integer sysNo);

    int updateByPrimaryKeySelective(Person record);

    int updateByPrimaryKey(Person record);

    List<Person> getPersonList(QF_Person qfPerson);

    List<Person> queryPersonList();

    PageaResult<Person> selectWithPage(@Param("queryPage") QF_Person qfPerson);

}