package com.charlie.ctmpas.service.impl;

import com.charlie.ctmpas.common.CommonUtils;
import com.charlie.ctmpas.common.ConstantMsg;
import com.charlie.ctmpas.dto.PatientInfoParam;
import com.charlie.ctmpas.entity.PatientInfo;
import com.charlie.ctmpas.entity.PatientInfoExample;
import com.charlie.ctmpas.entity.SymptomInfo;
import com.charlie.ctmpas.entity.SymptomInfoExample;
import com.charlie.ctmpas.mapper.PatientInfoMapper;
import com.charlie.ctmpas.mapper.SymptomInfoMapper;
import com.charlie.ctmpas.service.PatientInfoService;
import com.charlie.ctmpas.service.SymptomInfoService;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.BeanUtils;
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
