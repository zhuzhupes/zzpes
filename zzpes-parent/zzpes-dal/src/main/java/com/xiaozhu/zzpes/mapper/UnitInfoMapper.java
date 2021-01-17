package com.xiaozhu.zzpes.mapper;

import com.xiaozhu.zzpes.entity.UnitInfo;
import com.xiaozhu.zzpes.entity.UnitInfoExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface UnitInfoMapper {
    long countByExample(UnitInfoExample example);

    int deleteByExample(UnitInfoExample example);

    int deleteByPrimaryKey(Long unitSeq);

    int insert(UnitInfo record);

    int insertSelective(UnitInfo record);

    List<UnitInfo> selectByExample(UnitInfoExample example);

    UnitInfo selectByPrimaryKey(Long unitSeq);

    int updateByExampleSelective(@Param("record") UnitInfo record, @Param("example") UnitInfoExample example);

    int updateByExample(@Param("record") UnitInfo record, @Param("example") UnitInfoExample example);

    int updateByPrimaryKeySelective(UnitInfo record);

    int updateByPrimaryKey(UnitInfo record);
}