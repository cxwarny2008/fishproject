package com.tyb.fish.model;

import lombok.Data;

import java.io.Serializable;

@Data
public class QueryFilter implements Serializable {

    private Integer pageIndex = 1;

    private Integer pageSize = 10;

    private Integer totalRecord;

    public Integer getBeginRow() {
        return (pageIndex - 1) * pageSize;
    }

    public Integer getEndRow() {
        return (pageIndex) * pageSize;
    }
}
