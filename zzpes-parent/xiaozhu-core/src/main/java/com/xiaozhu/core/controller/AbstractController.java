package com.xiaozhu.core.controller;

import java.util.List;
import java.util.Map;

public abstract class AbstractController<T>{

    /**
     * 新增
     * @param t
     * @return
     */
    public abstract T insert(T t);

    /**
     * 修改
     * @param t
     * @return
     */
    public abstract T update(T t);

    /**
     * 删除
     * @param
     * @return
     */
    public abstract T delete(T t);

    /**
     * 按主键查询
     * @param
     * @return
     */
    public abstract T get(T t);

    /**
     * 分页查询
     * @return
     */
    public abstract T queryPageList(int pageSize, int pageIndex, Map<String,Object> params);

    /**
     * 多条件查询
     * @return
     */
    public abstract List<T> queryList(Map<String,Object> params);

}
