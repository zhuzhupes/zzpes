package com.xiaozhu.zzpes.mapper;

import com.xiaozhu.zzpes.entity.PrescriptionOverallInfo;
import com.xiaozhu.zzpes.entity.PrescriptionOverallInfoExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface PrescriptionOverallInfoMapper {
    long countByExample(PrescriptionOverallInfoExample example);

    int deleteByExample(PrescriptionOverallInfoExample example);

    int deleteByPrimaryKey(Long prescriptionId);

    int insert(PrescriptionOverallInfo record);

    int insertSelective(PrescriptionOverallInfo record);

    List<PrescriptionOverallInfo> selectByExample(PrescriptionOverallInfoExample example);

    PrescriptionOverallInfo selectByPrimaryKey(Long prescriptionId);

    int updateByExampleSelective(@Param("record") PrescriptionOverallInfo record, @Param("example") PrescriptionOverallInfoExample example);

    int updateByExample(@Param("record") PrescriptionOverallInfo record, @Param("example") PrescriptionOverallInfoExample example);

    int updateByPrimaryKeySelective(PrescriptionOverallInfo record);

    int updateByPrimaryKey(PrescriptionOverallInfo record);
}