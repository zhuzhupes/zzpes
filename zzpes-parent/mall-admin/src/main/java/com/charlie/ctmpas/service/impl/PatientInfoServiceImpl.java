package com.charlie.ctmpas.service.impl;

import com.charlie.ctmpas.common.CommonUtils;
import com.charlie.ctmpas.common.ConstantMsg;
import com.charlie.ctmpas.dto.PatientInfoParam;
import com.charlie.ctmpas.dto.UnitInfoParam;
import com.charlie.ctmpas.entity.PatientInfo;
import com.charlie.ctmpas.entity.PatientInfoExample;
import com.charlie.ctmpas.entity.UnitInfo;
import com.charlie.ctmpas.entity.UnitInfoExample;
import com.charlie.ctmpas.mapper.PatientInfoMapper;
import com.charlie.ctmpas.mapper.UnitInfoMapper;
import com.charlie.ctmpas.service.ParamManageUnitService;
import com.charlie.ctmpas.service.PatientInfoService;
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
public class PatientInfoServiceImpl implements PatientInfoService {

    @Autowired
    PatientInfoMapper patientInfoMapper;

    @Override
    public int createPatient(PatientInfoParam patientInfoParam) {
        PatientInfo patientInfo = new PatientInfo();
        patientInfo.setPatientSeq(null);
        patientInfo.setCureTimes(0);
        patientInfo.setLastUpdateTime(CommonUtils.getCurrentDate());
        patientInfo.setLastUpdateType(ConstantMsg.OPERATION_ADD);//设置新增
        patientInfo.setPatientName(patientInfoParam.getPatientName());
        patientInfo.setStartDate(patientInfoParam.getStartDate());
        patientInfo.setTreatTimes(1);
        patientInfo.setLastUpdateUser(CommonUtils.getCurrentUserId().toString());
        patientInfoMapper.insertSelective(patientInfo);
        return Integer.valueOf(patientInfo.getPatientSeq().toString());
    }

    @Override
    public List<PatientInfo> getList(Integer pageSize, Integer pageNum) {
        PageHelper.startPage(pageNum,pageSize);
        return patientInfoMapper.selectByExample(new PatientInfoExample());
    }

    @Override
    public List<PatientInfo> getAllList() {
        return patientInfoMapper.selectByExample(new PatientInfoExample());
    }

    @Override
    public int update(Long id, PatientInfoParam patientInfoParam) {
        PatientInfo patientInfo = new PatientInfo();
        BeanUtils.copyProperties(patientInfoParam, patientInfo);
        patientInfo.setLastUpdateUser(CommonUtils.getCurrentUserId().toString());
        patientInfo.setTreatTimes(patientInfoParam.getTreatTimes()+1);
        patientInfo.setLastUpdateType(ConstantMsg.OPERATION_TREAT);
        patientInfo.setLastUpdateTime(CommonUtils.getCurrentDate());
        patientInfo.setPatientSeq(id);
        return patientInfoMapper.updateByPrimaryKey(patientInfo);
    }
}
