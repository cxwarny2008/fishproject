package com.tyb.fish.interfaces;

import com.tyb.fish.model.Person;

public interface IPersonService {
    Person loadPersonBySysNo(int sysNo);
}
