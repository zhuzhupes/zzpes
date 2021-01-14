package com.charlie.ctmpas.mapper;

import com.charlie.ctmpas.entity.SymptomInfo;
import com.charlie.ctmpas.entity.SymptomInfoExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SymptomInfoMapper {
    long countByExample(SymptomInfoExample example);

    int deleteByExample(SymptomInfoExample example);

    int deleteByPrimaryKey(Long symptomSeq);

    int insert(SymptomInfo record);

    int insertSelective(SymptomInfo record);

    List<SymptomInfo> selectByExample(SymptomInfoExample example);

    SymptomInfo selectByPrimaryKey(Long symptomSeq);

    int updateByExampleSelective(@Param("record") SymptomInfo record, @Param("example") SymptomInfoExample example);

    int updateByExample(@Param("record") SymptomInfo record, @Param("example") SymptomInfoExample example);

    int updateByPrimaryKeySelective(SymptomInfo record);

    int updateByPrimaryKey(SymptomInfo record);
}