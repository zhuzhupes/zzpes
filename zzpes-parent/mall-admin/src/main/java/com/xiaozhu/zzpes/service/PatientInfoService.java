package com.xiaozhu.zzpes.service;



import com.xiaozhu.zzpes.dto.PatientInfoParam;
import com.xiaozhu.zzpes.entity.PatientInfo;

import java.util.List;

/**
 * 病人信息Service
 * Created by macro on 2018/4/26.
 */
public interface PatientInfoService {

    /**
     * 创建病人
     */
    int createPatient(PatientInfoParam patientInfoParam);

    /**
     * 获取所有病人列表
     */
    List<PatientInfo> getList(Integer pageSize, Integer pageNum);


    /**
     * 获取所有病人列表
     */
    List<PatientInfo> getAllList();

    /**
     * 修改单位
     */
    int update(Long id, PatientInfoParam patientInfoParam);

}
