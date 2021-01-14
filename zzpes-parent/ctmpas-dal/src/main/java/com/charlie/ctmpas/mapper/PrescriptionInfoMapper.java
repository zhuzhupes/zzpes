package com.charlie.ctmpas.mapper;

import com.charlie.ctmpas.entity.PrescriptionInfo;
import com.charlie.ctmpas.entity.PrescriptionInfoExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface PrescriptionInfoMapper {
    long countByExample(PrescriptionInfoExample example);

    int deleteByExample(PrescriptionInfoExample example);

    int deleteByPrimaryKey(Integer prescriptionSeq);

    int insert(PrescriptionInfo record);

    int insertSelective(PrescriptionInfo record);

    List<PrescriptionInfo> selectByExample(PrescriptionInfoExample example);

    PrescriptionInfo selectByPrimaryKey(Integer prescriptionSeq);

    int updateByExampleSelective(@Param("record") PrescriptionInfo record, @Param("example") PrescriptionInfoExample example);

    int updateByExample(@Param("record") PrescriptionInfo record, @Param("example") PrescriptionInfoExample example);

    int updateByPrimaryKeySelective(PrescriptionInfo record);

    int updateByPrimaryKey(PrescriptionInfo record);
}