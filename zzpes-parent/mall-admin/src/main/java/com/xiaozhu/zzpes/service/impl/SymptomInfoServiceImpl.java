package com.xiaozhu.zzpes.service.impl;

import com.xiaozhu.zzpes.entity.PatientInfo;
import com.xiaozhu.zzpes.entity.SymptomInfo;
import com.xiaozhu.zzpes.entity.SymptomInfoExample;
import com.xiaozhu.zzpes.mapper.SymptomInfoMapper;
import com.xiaozhu.zzpes.service.SymptomInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 商品品牌Service实现类
 * Created by macro on 2018/4/26.
 */
@Service
public class SymptomInfoServiceImpl implements SymptomInfoService {

    @Autowired
    SymptomInfoMapper symptomInfoMapper;


    @Override
    public List<SymptomInfo> getAllList() {
        return symptomInfoMapper.selectByExample(new SymptomInfoExample());
    }


    @Override
    public int createSymptom(SymptomInfo symptomInfo) {
        return 0;
    }

    @Override
    public List<PatientInfo> getList(Integer pageSize, Integer pageNum) {
        return null;
    }

    @Override
    public int update(Long id, SymptomInfo symptomInfo) {
        return 0;
    }
}
