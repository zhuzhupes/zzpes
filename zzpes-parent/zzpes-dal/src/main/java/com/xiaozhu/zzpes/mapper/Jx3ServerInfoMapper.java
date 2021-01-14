package com.xiaozhu.zzpes.mapper;

import com.xiaozhu.zzpes.entity.Jx3ServerInfo;
import com.xiaozhu.zzpes.entity.Jx3ServerInfoExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface Jx3ServerInfoMapper {
    long countByExample(Jx3ServerInfoExample example);

    int deleteByExample(Jx3ServerInfoExample example);

    int deleteByPrimaryKey(String serverId);

    int insert(Jx3ServerInfo record);

    int insertSelective(Jx3ServerInfo record);

    List<Jx3ServerInfo> selectByExample(Jx3ServerInfoExample example);

    Jx3ServerInfo selectByPrimaryKey(String serverId);

    int updateByExampleSelective(@Param("record") Jx3ServerInfo record, @Param("example") Jx3ServerInfoExample example);

    int updateByExample(@Param("record") Jx3ServerInfo record, @Param("example") Jx3ServerInfoExample example);

    int updateByPrimaryKeySelective(Jx3ServerInfo record);

    int updateByPrimaryKey(Jx3ServerInfo record);
}