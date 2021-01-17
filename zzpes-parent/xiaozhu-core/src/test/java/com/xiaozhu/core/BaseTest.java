package com.xiaozhu.core;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.xiaozhu.core.dao.BaseMapper;
import com.xiaozhu.core.service.BaseService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import tk.mybatis.mapper.common.Mapper;
import tk.mybatis.mapper.entity.Example;

import java.lang.reflect.ParameterizedType;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class BaseTest <T extends Object>{

    @Autowired
    private BaseService<T> objectService;

    @Autowired
    private BaseMapper<T> objectMapper;

    @Test
    public void contextLoads() {
    }

    Class<T> cls = (Class<T>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
    
    @Test
    public void insertSelective(T data) throws IllegalAccessException, InstantiationException {
        objectService.insertSelective(data);
    }

    @Test
    public void insertList(List<T> list){
        objectService.insertList(list);
    }

    @Test
    public void  updateByExampleSelective(T object, Example example){
        objectService.updateByExampleSelective(object,example);
    }

    @Test
    public void updateByPrimaryKeySelective(T object){
        objectService.updateByPrimaryKeySelective(object);
    }

    @Test
    public void select(T object) throws JsonProcessingException {
//        System.out.println(objectMapper.writeValueAsString(objectService.select(object)));
    }

    @Test
    public void selectPage() throws JsonProcessingException {
//        System.out.println(objectMapper.writeValueAsString(objectService.page(0,3).selectAll()));
        System.out.println(objectService.total());
    }

}
