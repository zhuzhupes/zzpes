package com.xiaozhu.core.service.impl;


import com.github.pagehelper.PageHelper;
import com.xiaozhu.core.dao.BaseMapper;
import com.xiaozhu.core.service.BaseService;
import org.apache.ibatis.session.RowBounds;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public abstract class BaseServiceImpl<T> implements BaseService<T> {

    @Autowired
    private BaseMapper<T> mapper;

    @Override
    public int deleteByPrimaryKey(Object o) {
        return mapper.deleteByPrimaryKey(o);
    }

    @Override
    public int delete(T t) {
        return mapper.delete(t);
    }

    @Override
    public int insert(T t) {
        return mapper.insert(t);
    }

    @Override
    public int insertSelective(T t) {
        return mapper.insertSelective(t);
    }

    @Override
    public boolean existsWithPrimaryKey(Object o) {
        return mapper.existsWithPrimaryKey(o);
    }

    @Override
    public List<T> selectAll() {
        List<T> list = mapper.selectAll();
        return list;
    }

    @Override
    public T selectByPrimaryKey(Object o) {
        return null;
    }

    @Override
    public int selectCount(T t) {
        return mapper.selectCount(t);
    }

    @Override
    public List<T> select(T t) {
        List<T> list = mapper.select(t);
        return list;
    }

    @Override
    public T selectOne(T t) {
        return null;
    }

    @Override
    public int updateByPrimaryKey(T t) {
        return mapper.updateByPrimaryKey(t);
    }

    @Override
    public int updateByPrimaryKeySelective(T t) {
        return mapper.updateByPrimaryKeySelective(t);
    }

    @Override
    public int deleteByExample(Object o) {
        return mapper.deleteByExample(o);
    }

    @Override
    public List<T> selectByExample(Object o) {
        List<T> list = mapper.selectByExample(o);
        return list;
    }

    @Override
    public int selectCountByExample(Object o) {
        return mapper.selectCountByExample(o);
    }

    @Override
    public T selectOneByExample(Object o) {
        return null;
    }

    @Override
    public int updateByExample(T t, Object o) {
        return mapper.updateByExample(t,o);
    }

    @Override
    public int updateByExampleSelective(T t, Object o) {
        return mapper.updateByExampleSelective(t,o);
    }

    @Override
    public List<T> selectByExampleAndRowBounds(Object o, RowBounds rowBounds) {
        List<T> list = mapper.selectByExampleAndRowBounds(o,rowBounds);
        return list;
    }

    @Override
    public List<T> selectByRowBounds(T t, RowBounds rowBounds) {
        List<T> list = mapper.selectByRowBounds(t,rowBounds);
        return list;
    }

    @Override
    public int insertList(List<? extends T> list) {
        int result = 0;
        for (T t : list) {
            result += mapper.insertSelective(t);
        }
        return result;
    }

    @Override
    public int insertUseGeneratedKeys(T t) {
        return 1;
    }

    @Override
    public BaseServiceImpl<T> page(int page,int rows) {
        if (rows>0 && page>0) {
            PageHelper.startPage(page,rows);
        }
        return this;
    }

    @Override
    public int total(){
        return this.selectCount(null);
    }

}