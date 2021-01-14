package com.xiaozhu.zzpes.mapper;

import com.xiaozhu.zzpes.entity.Jx3OcptInfo;
import com.xiaozhu.zzpes.entity.Jx3OcptInfoExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface Jx3OcptInfoMapper {
    long countByExample(Jx3OcptInfoExample example);

    int deleteByExample(Jx3OcptInfoExample example);

    int deleteByPrimaryKey(Integer ocptId);

    int insert(Jx3OcptInfo record);

    int insertSelective(Jx3OcptInfo record);

    List<Jx3OcptInfo> selectByExample(Jx3OcptInfoExample example);

    Jx3OcptInfo selectByPrimaryKey(Integer ocptId);

    int updateByExampleSelective(@Param("record") Jx3OcptInfo record, @Param("example") Jx3OcptInfoExample example);

    int updateByExample(@Param("record") Jx3OcptInfo record, @Param("example") Jx3OcptInfoExample example);

    int updateByPrimaryKeySelective(Jx3OcptInfo record);

    int updateByPrimaryKey(Jx3OcptInfo record);
}