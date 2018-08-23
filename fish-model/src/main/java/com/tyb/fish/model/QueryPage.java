package com.tyb.fish.model;

import lombok.Data;

import java.io.Serializable;
import java.util.*;

/**
 * Created by liubo on 2015/12/26.
 */
@Data
public class QueryPage<T> implements List<T>, Serializable {
    private int pageSize = 20;
    private int currentPageNo = 1;
    private int totalRecord;
    private String pageHtml;
    private List<T> result;

    public QueryPage() {
        this.result = new ArrayList<T>();
    }

    public QueryPage(Integer pageIndex, Integer pageSize) {
        this.currentPageNo = pageIndex;
        this.pageSize = pageSize;
        this.result = new ArrayList<T>();
    }

    public QueryPage(Integer totalRecord, List<T> result) {
        this.totalRecord = totalRecord;
        this.result = result;
    }

    public QueryResult<T> ctorQueryResult() {
        return new QueryResult<T>(this);
    }

    /**
     * 获取总页数
     *
     * @return int
     */
    public int getTotalPage() {
        int totalPage = 0;
        if (this.getTotalRecord() % this.pageSize == 0) {
            totalPage = this.getTotalRecord() / this.pageSize;
        } else {
            totalPage = this.getTotalRecord() / this.pageSize + 1;
        }
        return totalPage;
    }

    /**
     * 获取开始行
     *
     * @return int
     */
    public int getBeginRow() {
        return (this.currentPageNo - 1) * this.pageSize;
    }

    /**
     * 获取结束行
     *
     * @return
     */
    public int getEndRow() {
        return this.currentPageNo * this.pageSize;
    }


    @Override
    public int size() {
        return this.result.size();
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public boolean contains(Object o) {
        return false;
    }

    @Override
    public Iterator<T> iterator() {
        return this.result.iterator();
    }

    @Override
    public Object[] toArray() {
        return new Object[0];
    }

    @Override
    public <T1> T1[] toArray(T1[] a) {
        return this.result.toArray(a);
    }

    @Override
    public boolean add(T t) {
        return false;
    }

    @Override
    public boolean remove(Object o) {
        return false;
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        return false;
    }

    @Override
    public boolean addAll(Collection<? extends T> c) {
        return false;
    }

    @Override
    public boolean addAll(int index, Collection<? extends T> c) {
        return false;
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        return false;
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        return false;
    }

    @Override
    public void clear() {

    }

    @Override
    public T get(int index) {
        return this.result.get(index);
    }

    @Override
    public T set(int index, T element) {
        return this.result.set(index, element);
    }

    @Override
    public void add(int index, T element) {
        this.result.add(index, element);
    }

    @Override
    public T remove(int index) {
        return this.result.remove(index);
    }

    @Override
    public int indexOf(Object o) {
        return this.result.indexOf(o);
    }

    @Override
    public int lastIndexOf(Object o) {
        return this.result.lastIndexOf(o);
    }

    @Override
    public ListIterator<T> listIterator() {
        return this.result.listIterator();
    }

    @Override
    public ListIterator<T> listIterator(int index) {
        return this.result.listIterator(index);
    }

    @Override
    public List<T> subList(int fromIndex, int toIndex) {
        return this.result.subList(fromIndex, toIndex);
    }

    @Override
    public String toString() {
        return "total=" + this.getTotalRecord() + this.result.toString();
    }
}
