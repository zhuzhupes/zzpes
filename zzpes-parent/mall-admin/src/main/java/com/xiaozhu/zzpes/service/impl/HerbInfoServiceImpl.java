package com.xiaozhu.zzpes.service.impl;

import com.xiaozhu.zzpes.entity.*;
import com.xiaozhu.zzpes.mapper.HerbInfoMapper;
import com.xiaozhu.zzpes.service.HerbInfoService;
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
