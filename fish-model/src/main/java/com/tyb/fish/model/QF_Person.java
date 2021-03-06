package com.tyb.fish.model;

import com.tyb.fish.model.common.QueryFilter;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 人员信息查询类
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class QF_Person extends QueryFilter {

    private String name;
}
