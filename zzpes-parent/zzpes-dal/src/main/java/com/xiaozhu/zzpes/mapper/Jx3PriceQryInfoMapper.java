package com.xiaozhu.zzpes.mapper;

import com.xiaozhu.zzpes.entity.Jx3PriceQryInfo;
import com.xiaozhu.zzpes.entity.Jx3PriceQryInfoExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface Jx3PriceQryInfoMapper {
    long countByExample(Jx3PriceQryInfoExample example);

    int deleteByExample(Jx3PriceQryInfoExample example);

    int deleteByPrimaryKey(Integer qryId);

    int insert(Jx3PriceQryInfo record);

    int insertSelective(Jx3PriceQryInfo record);

    List<Jx3PriceQryInfo> selectByExample(Jx3PriceQryInfoExample example);

    Jx3PriceQryInfo selectByPrimaryKey(Integer qryId);

    int updateByExampleSelective(@Param("record") Jx3PriceQryInfo record, @Param("example") Jx3PriceQryInfoExample example);

    int updateByExample(@Param("record") Jx3PriceQryInfo record, @Param("example") Jx3PriceQryInfoExample example);

    int updateByPrimaryKeySelective(Jx3PriceQryInfo record);

    int updateByPrimaryKey(Jx3PriceQryInfo record);
}