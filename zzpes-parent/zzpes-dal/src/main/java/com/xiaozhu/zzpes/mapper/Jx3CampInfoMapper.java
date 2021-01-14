package com.xiaozhu.zzpes.mapper;

import com.xiaozhu.zzpes.entity.Jx3CampInfo;
import com.xiaozhu.zzpes.entity.Jx3CampInfoExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface Jx3CampInfoMapper {
    long countByExample(Jx3CampInfoExample example);

    int deleteByExample(Jx3CampInfoExample example);

    int deleteByPrimaryKey(Integer campTypeId);

    int insert(Jx3CampInfo record);

    int insertSelective(Jx3CampInfo record);

    List<Jx3CampInfo> selectByExample(Jx3CampInfoExample example);

    Jx3CampInfo selectByPrimaryKey(Integer campTypeId);

    int updateByExampleSelective(@Param("record") Jx3CampInfo record, @Param("example") Jx3CampInfoExample example);

    int updateByExample(@Param("record") Jx3CampInfo record, @Param("example") Jx3CampInfoExample example);

    int updateByPrimaryKeySelective(Jx3CampInfo record);

    int updateByPrimaryKey(Jx3CampInfo record);
}