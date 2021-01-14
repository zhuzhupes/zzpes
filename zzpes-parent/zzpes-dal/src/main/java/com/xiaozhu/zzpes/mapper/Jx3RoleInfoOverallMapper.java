package com.xiaozhu.zzpes.mapper;

import com.xiaozhu.zzpes.entity.Jx3RoleInfoOverall;
import com.xiaozhu.zzpes.entity.Jx3RoleInfoOverallExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface Jx3RoleInfoOverallMapper {
    long countByExample(Jx3RoleInfoOverallExample example);

    int deleteByExample(Jx3RoleInfoOverallExample example);

    int deleteByPrimaryKey(String jx3rId);

    int insert(Jx3RoleInfoOverall record);

    int insertSelective(Jx3RoleInfoOverall record);

    List<Jx3RoleInfoOverall> selectByExampleWithBLOBs(Jx3RoleInfoOverallExample example);

    List<Jx3RoleInfoOverall> selectByExample(Jx3RoleInfoOverallExample example);

    Jx3RoleInfoOverall selectByPrimaryKey(String jx3rId);

    int updateByExampleSelective(@Param("record") Jx3RoleInfoOverall record, @Param("example") Jx3RoleInfoOverallExample example);

    int updateByExampleWithBLOBs(@Param("record") Jx3RoleInfoOverall record, @Param("example") Jx3RoleInfoOverallExample example);

    int updateByExample(@Param("record") Jx3RoleInfoOverall record, @Param("example") Jx3RoleInfoOverallExample example);

    int updateByPrimaryKeySelective(Jx3RoleInfoOverall record);

    int updateByPrimaryKeyWithBLOBs(Jx3RoleInfoOverall record);

    int updateByPrimaryKey(Jx3RoleInfoOverall record);
}