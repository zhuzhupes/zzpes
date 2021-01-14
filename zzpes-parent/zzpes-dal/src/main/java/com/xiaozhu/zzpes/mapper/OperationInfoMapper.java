package com.xiaozhu.zzpes.mapper;

import com.xiaozhu.zzpes.entity.OperationInfo;
import com.xiaozhu.zzpes.entity.OperationInfoExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface OperationInfoMapper {
    long countByExample(OperationInfoExample example);

    int deleteByExample(OperationInfoExample example);

    int deleteByPrimaryKey(Long operationSeq);

    int insert(OperationInfo record);

    int insertSelective(OperationInfo record);

    List<OperationInfo> selectByExample(OperationInfoExample example);

    OperationInfo selectByPrimaryKey(Long operationSeq);

    int updateByExampleSelective(@Param("record") OperationInfo record, @Param("example") OperationInfoExample example);

    int updateByExample(@Param("record") OperationInfo record, @Param("example") OperationInfoExample example);

    int updateByPrimaryKeySelective(OperationInfo record);

    int updateByPrimaryKey(OperationInfo record);
}