package com.xiaozhu.core.controller;

import com.xiaozhu.core.dao.BaseMapper;
import com.xiaozhu.core.service.BaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import tk.mybatis.mapper.common.Mapper;

import java.lang.reflect.ParameterizedType;
import java.util.List;
import java.util.Map;

public class BaseController<T> extends AbstractController<T> {

    @Autowired
    private  BaseService<T> service;

    Class<T> cls = (Class<T>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];


    @PostMapping("/insert")
    @Override
    public T insert(@RequestBody T t) {
        return null;
    }

    @PostMapping("/update")
    @Override
    public T update(Object o) {
        return null;
    }

    @Override
    public T delete(Object id) {
        return null;
    }

    @Override
    public T get(Object Id) {
        return null;
    }

    @GetMapping("/allList")
    @Override
    public List<T> queryList(@RequestParam Map<String, Object> params) {
        return service.selectAll();
    }

    @Override
    public T queryPageList(int pageSize, int pageIndex, Map params) {
        return null;
    }
}