package com.xiaozhu.zzpes.mapper;

import com.xiaozhu.zzpes.entity.HerbUnitInfo;
import com.xiaozhu.zzpes.entity.HerbUnitInfoExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface HerbUnitInfoMapper {
    long countByExample(HerbUnitInfoExample example);

    int deleteByExample(HerbUnitInfoExample example);

    int deleteByPrimaryKey(Long herbUnitSeq);

    int insert(HerbUnitInfo record);

    int insertSelective(HerbUnitInfo record);

    List<HerbUnitInfo> selectByExample(HerbUnitInfoExample example);

    HerbUnitInfo selectByPrimaryKey(Long herbUnitSeq);

    int updateByExampleSelective(@Param("record") HerbUnitInfo record, @Param("example") HerbUnitInfoExample example);

    int updateByExample(@Param("record") HerbUnitInfo record, @Param("example") HerbUnitInfoExample example);

    int updateByPrimaryKeySelective(HerbUnitInfo record);

    int updateByPrimaryKey(HerbUnitInfo record);
}