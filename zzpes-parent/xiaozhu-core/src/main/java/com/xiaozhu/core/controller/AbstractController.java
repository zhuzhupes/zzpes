package com.xiaozhu.core.controller;

import com.xiaozhu.http.api.CommonPage;
import com.xiaozhu.http.api.CommonResult;

import java.util.List;
import java.util.Map;

public abstract class AbstractController<T>{

    /**
     * 新增
     * @param t
     * @return
     */
    public abstract CommonResult insert(T t);

    /**
     * 修改
     * @param t
     * @return
     */
    public abstract CommonResult update(T t);

    /**
     * 删除
     * @param
     * @return
     */
    public abstract CommonResult delete(T t);

    /**
     * 按主键查询
     * @param
     * @return
     */
    public abstract CommonResult get(T t);

    /**
     * 分页查询
     * @return
     */
    public abstract CommonResult<CommonPage<T>> queryPageList(int pageSize, int pageIndex, Map<String,Object> params);

    /**
     * 多条件查询
     * @return
     */
    public abstract CommonResult<CommonPage<T>> queryList(Map<String,Object> params);

}
