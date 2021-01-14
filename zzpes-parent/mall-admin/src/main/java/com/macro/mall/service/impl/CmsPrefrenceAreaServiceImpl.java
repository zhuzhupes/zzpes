package com.macro.mall.service.impl;

import com.xiaozhu.zzpes.mapper.CmsPrefrenceAreaMapper;
import com.xiaozhu.zzpes.entity.CmsPrefrenceArea;
import com.xiaozhu.zzpes.entity.CmsPrefrenceAreaExample;
import com.macro.mall.service.CmsPrefrenceAreaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 商品优选Service实现类
 * Created by macro on 2018/6/1.
 */
@Service
public class CmsPrefrenceAreaServiceImpl implements CmsPrefrenceAreaService {
    @Autowired
    private CmsPrefrenceAreaMapper prefrenceAreaMapper;

    @Override
    public List<CmsPrefrenceArea> listAll() {
        return prefrenceAreaMapper.selectByExample(new CmsPrefrenceAreaExample());
    }
}
