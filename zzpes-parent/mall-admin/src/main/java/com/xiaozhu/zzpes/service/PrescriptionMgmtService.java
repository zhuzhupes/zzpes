package com.xiaozhu.zzpes.service;

import com.xiaozhu.zzpes.dto.PrescriptionParam;
import com.xiaozhu.zzpes.model.PrescriptionModel;

import java.util.List;

public interface PrescriptionMgmtService {

    /**
     * 创建药方
     */
    int createPrescription(PrescriptionParam prescriptionParam);

    /**
     * 获取所有药方
     */
    List<PrescriptionModel> getList(Integer pageSize, Integer pageNum);

    /**
     * 修改单位
     */
    int update(Long id, PrescriptionParam prescriptionParam);

    /**
     * 创建单位
     */
    int deletePrescription(Long id);
}
