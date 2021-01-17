package com.xiaozhu.zzpes.mapper;

import com.xiaozhu.zzpes.entity.PrescriptionInfo;
import com.xiaozhu.zzpes.entity.PrescriptionInfoExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface PrescriptionInfoMapper {
    long countByExample(PrescriptionInfoExample example);

    int deleteByExample(PrescriptionInfoExample example);

    int deleteByPrimaryKey(Long prescriptionSeq);

    int insert(PrescriptionInfo record);

    int insertSelective(PrescriptionInfo record);

    List<PrescriptionInfo> selectByExample(PrescriptionInfoExample example);

    PrescriptionInfo selectByPrimaryKey(Long prescriptionSeq);

    int updateByExampleSelective(@Param("record") PrescriptionInfo record, @Param("example") PrescriptionInfoExample example);

    int updateByExample(@Param("record") PrescriptionInfo record, @Param("example") PrescriptionInfoExample example);

    int updateByPrimaryKeySelective(PrescriptionInfo record);

    int updateByPrimaryKey(PrescriptionInfo record);
}