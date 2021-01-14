package com.xiaozhu.zzpes.mapper;

import com.xiaozhu.zzpes.entity.Jx3DtlInfo;
import com.xiaozhu.zzpes.entity.Jx3DtlInfoExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface Jx3DtlInfoMapper {
    long countByExample(Jx3DtlInfoExample example);

    int deleteByExample(Jx3DtlInfoExample example);

    int deleteByPrimaryKey(Integer dtlId);

    int insert(Jx3DtlInfo record);

    int insertSelective(Jx3DtlInfo record);

    List<Jx3DtlInfo> selectByExample(Jx3DtlInfoExample example);

    Jx3DtlInfo selectByPrimaryKey(Integer dtlId);

    int updateByExampleSelective(@Param("record") Jx3DtlInfo record, @Param("example") Jx3DtlInfoExample example);

    int updateByExample(@Param("record") Jx3DtlInfo record, @Param("example") Jx3DtlInfoExample example);

    int updateByPrimaryKeySelective(Jx3DtlInfo record);

    int updateByPrimaryKey(Jx3DtlInfo record);
}