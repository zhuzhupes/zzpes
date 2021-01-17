package com.xiaozhu.zzpes.service;



import com.xiaozhu.zzpes.entity.PatientInfo;
import com.xiaozhu.zzpes.entity.SymptomInfo;

import java.util.List;

/**
 * 病人信息Service
 * Created by macro on 2018/4/26.
 */
public interface SymptomInfoService {

    /**
     * 创建病人
     */
    int createSymptom(SymptomInfo symptomInfo);

    /**
     * 获取所有病人列表
     */
    List<PatientInfo> getList(Integer pageSize, Integer pageNum);


    /**
     * 获取所有病人列表
     */
    List<SymptomInfo> getAllList();

    /**
     * 修改单位
     */
    int update(Long id, SymptomInfo symptomInfo);

}
