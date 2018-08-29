package com.tyb.fish.model;

import lombok.Data;

import java.io.Serializable;

/**
 * 查询类基类
 */
@Data
public class QueryFilter implements Serializable {

    /**
     * 当前页
     */
    private int pageNo=1;

    /**
     * 每页的数量
     */
    private int pageSize=10;

    /**
     * 总记录数
     */
    private int totalRecord;

    /**
     * 计算起始记录行
     * @return
     */
    public Integer getBeginRow() {
        return (pageNo - 1) * pageSize;
    }

    /**
     * 计算结束行
     * @return
     */
    public Integer getEndRow() {
        return (pageNo) * pageSize;
    }
}
