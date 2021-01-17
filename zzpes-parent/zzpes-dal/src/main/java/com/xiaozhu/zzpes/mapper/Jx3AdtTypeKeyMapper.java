package com.xiaozhu.zzpes.mapper;

import com.xiaozhu.zzpes.entity.Jx3AdtTypeKey;
import com.xiaozhu.zzpes.entity.Jx3AdtTypeKeyExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface Jx3AdtTypeKeyMapper {
    long countByExample(Jx3AdtTypeKeyExample example);

    int deleteByExample(Jx3AdtTypeKeyExample example);

    int deleteByPrimaryKey(String dtlType);

    int insert(Jx3AdtTypeKey record);

    int insertSelective(Jx3AdtTypeKey record);

    List<Jx3AdtTypeKey> selectByExample(Jx3AdtTypeKeyExample example);

    Jx3AdtTypeKey selectByPrimaryKey(String dtlType);

    int updateByExampleSelective(@Param("record") Jx3AdtTypeKey record, @Param("example") Jx3AdtTypeKeyExample example);

    int updateByExample(@Param("record") Jx3AdtTypeKey record, @Param("example") Jx3AdtTypeKeyExample example);

    int updateByPrimaryKeySelective(Jx3AdtTypeKey record);

    int updateByPrimaryKey(Jx3AdtTypeKey record);
}