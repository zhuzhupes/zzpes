package com.xiaozhu.zzpes.mapper;

import com.xiaozhu.zzpes.entity.HerbInfo;
import com.xiaozhu.zzpes.entity.HerbInfoExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface HerbInfoMapper {
    long countByExample(HerbInfoExample example);

    int deleteByExample(HerbInfoExample example);

    int deleteByPrimaryKey(Long herbSeq);

    int insert(HerbInfo record);

    int insertSelective(HerbInfo record);

    List<HerbInfo> selectByExample(HerbInfoExample example);

    HerbInfo selectByPrimaryKey(Long herbSeq);

    int updateByExampleSelective(@Param("record") HerbInfo record, @Param("example") HerbInfoExample example);

    int updateByExample(@Param("record") HerbInfo record, @Param("example") HerbInfoExample example);

    int updateByPrimaryKeySelective(HerbInfo record);

    int updateByPrimaryKey(HerbInfo record);
}