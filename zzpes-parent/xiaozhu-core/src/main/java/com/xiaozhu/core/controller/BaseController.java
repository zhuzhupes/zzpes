package com.xiaozhu.core.controller;

import com.xiaozhu.common.BeanMapUtils;
import com.xiaozhu.common.Xzutils;
import com.xiaozhu.core.dao.BaseMapper;
import com.xiaozhu.core.service.BaseService;
import com.xiaozhu.http.api.CommonPage;
import com.xiaozhu.http.api.CommonResult;
import net.sf.cglib.beans.BeanMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tk.mybatis.mapper.common.Mapper;
import tk.mybatis.mapper.entity.Example;

import java.lang.reflect.ParameterizedType;
import java.util.List;
import java.util.Map;

public class BaseController<T> extends AbstractController<T> {

    @Autowired
    protected   BaseService<T> service;

    protected Class<T> cls = (Class<T>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];


    @PostMapping("/insert")
    @Override
    public CommonResult insert(@RequestBody T t) {
        return null;
    }

    @PostMapping("/update")
    @Override
    public CommonResult update(Object o) {
        return null;
    }

    @Override
    public CommonResult delete(Object id) {
        return null;
    }

    @Override
    public CommonResult get(Object Id) {
        return null;
    }

    @GetMapping("/allList")
    @Override
    @ResponseBody
    public CommonResult<CommonPage<T>> queryList(@RequestParam Map<String, Object> params) {
        List<T> resList = null;
        Example example = new Example(cls);
        example.createCriteria().andEqualTo(params);
        resList = service.selectByExample(example);
        return CommonResult.success(CommonPage.restPage(resList));
    }



    @Override
    public CommonResult<CommonPage<T>> queryPageList(int pageSize, int pageIndex, Map params) {
        return null;
    }
}