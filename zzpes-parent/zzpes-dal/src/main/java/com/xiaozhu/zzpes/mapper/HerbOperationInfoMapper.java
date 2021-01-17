package com.xiaozhu.zzpes.mapper;

import com.xiaozhu.zzpes.entity.HerbOperationInfo;
import com.xiaozhu.zzpes.entity.HerbOperationInfoExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface HerbOperationInfoMapper {
    long countByExample(HerbOperationInfoExample example);

    int deleteByExample(HerbOperationInfoExample example);

    int deleteByPrimaryKey(Long herbOperationSeq);

    int insert(HerbOperationInfo record);

    int insertSelective(HerbOperationInfo record);

    List<HerbOperationInfo> selectByExample(HerbOperationInfoExample example);

    HerbOperationInfo selectByPrimaryKey(Long herbOperationSeq);

    int updateByExampleSelective(@Param("record") HerbOperationInfo record, @Param("example") HerbOperationInfoExample example);

    int updateByExample(@Param("record") HerbOperationInfo record, @Param("example") HerbOperationInfoExample example);

    int updateByPrimaryKeySelective(HerbOperationInfo record);

    int updateByPrimaryKey(HerbOperationInfo record);
}