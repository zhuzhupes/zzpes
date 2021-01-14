package com.xiaozhu.zzpes.mapper;

import com.xiaozhu.zzpes.entity.Jx3BodyShapeInfo;
import com.xiaozhu.zzpes.entity.Jx3BodyShapeInfoExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface Jx3BodyShapeInfoMapper {
    long countByExample(Jx3BodyShapeInfoExample example);

    int deleteByExample(Jx3BodyShapeInfoExample example);

    int deleteByPrimaryKey(Integer bodyShapeId);

    int insert(Jx3BodyShapeInfo record);

    int insertSelective(Jx3BodyShapeInfo record);

    List<Jx3BodyShapeInfo> selectByExample(Jx3BodyShapeInfoExample example);

    Jx3BodyShapeInfo selectByPrimaryKey(Integer bodyShapeId);

    int updateByExampleSelective(@Param("record") Jx3BodyShapeInfo record, @Param("example") Jx3BodyShapeInfoExample example);

    int updateByExample(@Param("record") Jx3BodyShapeInfo record, @Param("example") Jx3BodyShapeInfoExample example);

    int updateByPrimaryKeySelective(Jx3BodyShapeInfo record);

    int updateByPrimaryKey(Jx3BodyShapeInfo record);
}