package com.xiaozhu.zzpes.service.impl;

import com.xiaozhu.zzpes.common.CommonUtils;
import com.xiaozhu.zzpes.dto.PatientInfoParam;
import com.xiaozhu.zzpes.dto.PrescriptionParam;
import com.xiaozhu.zzpes.entity.PrescriptionInfo;
import com.xiaozhu.zzpes.entity.PrescriptionOverallInfo;
import com.xiaozhu.zzpes.mapper.PrescriptionInfoMapper;
import com.xiaozhu.zzpes.mapper.PrescriptionOverallInfoMapper;
import com.xiaozhu.zzpes.model.PrescriptionItem;
import com.xiaozhu.zzpes.model.PrescriptionModel;
import com.xiaozhu.zzpes.service.PatientInfoService;
import com.xiaozhu.zzpes.service.PrescriptionMgmtService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 商品品牌Service实现类
 * Created by macro on 2018/4/26.
 */
@Service
public class PrescriptionMgmtServiceImpl implements PrescriptionMgmtService {

    @Autowired
    PatientInfoService patientService;

    @Autowired
    PrescriptionOverallInfoMapper prescriptionOverallInfoMapper;

    @Autowired
    PrescriptionInfoMapper prescriptionInfoMapper;

    public int createPrescription(PrescriptionParam prescriptionParam) {
        if(CommonUtils.isNullOrEmpty(prescriptionParam.getPatientSeq())){
            PatientInfoParam patientInfoParam = new PatientInfoParam();
            patientInfoParam.setStartDate(CommonUtils.getDateFromStr(prescriptionParam.getInputDate()));
            patientInfoParam.setPatientName(prescriptionParam.getPatientName());
            patientInfoParam.setPatientSex(prescriptionParam.getPatientSex());
            prescriptionParam.setPatientSeq(String.valueOf(patientService.createPatient(patientInfoParam)));
        }else{
            patientService.update(Long.valueOf(prescriptionParam.getPatientSeq()), new PatientInfoParam());
        }
        PrescriptionOverallInfo overallInfo = new PrescriptionOverallInfo();
        overallInfo.setPrescriptionId(null);
        overallInfo.setPatientId(prescriptionParam.getPatientSeq());
        overallInfo.setPrescriptionDate(CommonUtils.getDateFromStr(prescriptionParam.getInputDate()));
        prescriptionOverallInfoMapper.insertSelective(overallInfo);
        for(PrescriptionItem herbItem: prescriptionParam.getHerbs()){
            PrescriptionInfo prescriptionInfo = new PrescriptionInfo();
            prescriptionInfo.setHerbSeq(Integer.valueOf(herbItem.getHerb()));
            prescriptionInfo.setUnitSeq(Integer.valueOf(herbItem.getUnitType()));
            prescriptionInfo.setUnitNum(Integer.valueOf(herbItem.getHerb_nums()));
            prescriptionInfo.setPrescriptionId(Integer.valueOf(overallInfo.getPrescriptionId().toString()));
            prescriptionInfo.setOperationSeq(Integer.valueOf(herbItem.getOpeationType()));
            prescriptionInfo.setOperationUnitNum(Integer.valueOf(herbItem.getOperationValue()));
            prescriptionInfo.setOperationUnitSeq(Integer.valueOf(herbItem.getOperationUnit()));
            prescriptionInfo.setPrescriptionSeq(null);
            prescriptionInfoMapper.insertSelective(prescriptionInfo);
        }
        return 1;
    }

    public List<PrescriptionModel> getList(Integer pageSize, Integer pageNum) {
        return null;
    }

    public int update(Long id, PrescriptionParam prescriptionParam) {
        return 0;
    }

    public int deletePrescription(Long id) {
        return 0;
    }
}
