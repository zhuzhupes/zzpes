package com.xiaozhu.zzpes.service;



import com.xiaozhu.zzpes.entity.OperationInfo;

import java.util.List;

/**
 * 病人信息Service
 * Created by macro on 2018/4/26.
 */
public interface OperationInfoService {

    /**
     * 获取所有病人列表
     */
    List<OperationInfo> getAllList();
}
