package com.tyb.fish.mapper;

import com.tyb.fish.model.*;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface PersonMapper {

    int deletePerson(Integer sysNo);

    int insertPerson(Person record);

    Person loadPersonBySysNo(Integer sysNo);

    int updatePerson(Person record);

    List<Person> getPersonList(QF_Person qfPerson);

    PageaResult<Person> queryPersonList(@Param("filte") QF_Person qfPerson);

}