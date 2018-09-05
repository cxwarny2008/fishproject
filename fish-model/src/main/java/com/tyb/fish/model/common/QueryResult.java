package com.tyb.fish.model.common;

import com.tyb.fish.model.common.PageaResult;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * 分页查询公共返回类型
 *
 * @param <T>
 * @author Garry
 */
@Data
public class QueryResult<T> implements Serializable {

    /**
     * 当前页
     */
    private int pageNo;

    /**
     * 每页的数量
     */
    private int pageSize;

    /**
     * 总记录数
     */
    private int totalRecord;

    /**
     * 结果集
     */
    private List<T> list;

    /**
     * 构造函数
     *
     * @param pageResult
     */
    public QueryResult(PageaResult<T> pageResult) {
        this.pageNo = pageResult.getCurrentPageNo();
        this.pageSize = pageResult.getPageSize();
        this.totalRecord = pageResult.getTotalRecord();
        this.setList(pageResult.getResult());
    }

}
