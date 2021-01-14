package com.charlie.ctmpas.service.impl;

import com.charlie.ctmpas.entity.*;
import com.charlie.ctmpas.mapper.OperationInfoMapper;
import com.charlie.ctmpas.service.OperationInfoService;
import com.charlie.ctmpas.service.OperationInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 商品品牌Service实现类
 * Created by macro on 2018/4/26.
 */
@Service
public class OperationInfoServiceImpl implements OperationInfoService {

    @Autowired
    OperationInfoMapper operationInfoMapper;


    @Override
    public List<OperationInfo> getAllList() {
        return operationInfoMapper.selectByExample(new OperationInfoExample());
    }

}
