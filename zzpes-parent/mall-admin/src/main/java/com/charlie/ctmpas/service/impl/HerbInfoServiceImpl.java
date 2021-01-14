package com.charlie.ctmpas.service.impl;

import com.charlie.ctmpas.entity.*;
import com.charlie.ctmpas.mapper.HerbInfoMapper;
import com.charlie.ctmpas.mapper.SymptomInfoMapper;
import com.charlie.ctmpas.service.HerbInfoService;
import com.charlie.ctmpas.service.SymptomInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 商品品牌Service实现类
 * Created by macro on 2018/4/26.
 */
@Service
public class HerbInfoServiceImpl implements HerbInfoService {

    @Autowired
    HerbInfoMapper herbInfoMapper;


    @Override
    public List<HerbInfo> getAllList() {
        return herbInfoMapper.selectByExample(new HerbInfoExample());
    }
}
