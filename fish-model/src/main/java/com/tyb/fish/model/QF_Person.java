package com.tyb.fish.model;

import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
public class QF_Person extends QueryFilter {

    private String name;
}
