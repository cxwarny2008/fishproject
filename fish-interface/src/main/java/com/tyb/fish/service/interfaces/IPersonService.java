package com.tyb.fish.service.interfaces;

import com.tyb.fish.model.*;
import com.tyb.fish.model.common.QueryResult;

import java.util.List;

/**
 * Person服务接口类
 */
public interface IPersonService {

    Person loadPersonBySysNo(int sysNo);

    List<Person> getPersonList(QF_Person qfPerson);

    void insertPerson(Person person);

    void updatePerson(Person person);

    void deletePerson(int sysNo);

    QueryResult<Person> queryPersonList(QF_Person page);

}
