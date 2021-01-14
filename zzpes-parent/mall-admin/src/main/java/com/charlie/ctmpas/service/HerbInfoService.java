package com.charlie.ctmpas.service;



import com.charlie.ctmpas.entity.HerbInfo;
import com.charlie.ctmpas.entity.PatientInfo;
import com.charlie.ctmpas.entity.SymptomInfo;

import java.util.List;

/**
 * 病人信息Service
 * Created by macro on 2018/4/26.
 */
public interface HerbInfoService {

    /**
     * 获取所有病人列表
     */
    List<HerbInfo> getAllList();


}
