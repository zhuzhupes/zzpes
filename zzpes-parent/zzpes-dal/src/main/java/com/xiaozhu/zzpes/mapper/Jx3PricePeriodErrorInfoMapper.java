package com.xiaozhu.zzpes.mapper;

import com.xiaozhu.zzpes.entity.Jx3PricePeriodErrorInfo;
import com.xiaozhu.zzpes.entity.Jx3PricePeriodErrorInfoExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface Jx3PricePeriodErrorInfoMapper {
    long countByExample(Jx3PricePeriodErrorInfoExample example);

    int deleteByExample(Jx3PricePeriodErrorInfoExample example);

    int deleteByPrimaryKey(Integer errorId);

    int insert(Jx3PricePeriodErrorInfo record);

    int insertSelective(Jx3PricePeriodErrorInfo record);

    List<Jx3PricePeriodErrorInfo> selectByExample(Jx3PricePeriodErrorInfoExample example);

    Jx3PricePeriodErrorInfo selectByPrimaryKey(Integer errorId);

    int updateByExampleSelective(@Param("record") Jx3PricePeriodErrorInfo record, @Param("example") Jx3PricePeriodErrorInfoExample example);

    int updateByExample(@Param("record") Jx3PricePeriodErrorInfo record, @Param("example") Jx3PricePeriodErrorInfoExample example);

    int updateByPrimaryKeySelective(Jx3PricePeriodErrorInfo record);

    int updateByPrimaryKey(Jx3PricePeriodErrorInfo record);
}