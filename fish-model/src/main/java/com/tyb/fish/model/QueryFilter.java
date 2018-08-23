package com.tyb.fish.model;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class QueryFilter {

    private Integer pageIndex;

    private Integer pageSize;

    public QueryFilter(Integer pageIndex, Integer pageSize) {
        this.setPageIndex(pageIndex);
        this.setPageSize(pageSize);
    }
}
