package com.xiaozhu.zzpes.service;



import com.xiaozhu.zzpes.dto.UnitInfoParam;
import com.xiaozhu.zzpes.entity.UnitInfo;

import java.util.List;

/**
 * 商品品牌Service
 * Created by macro on 2018/4/26.
 */

public interface ParamManageUnitService {

    /**
     * 创建单位
     */
    int createUnit(UnitInfoParam unitInfoParam);

    /**
     * 获取所有单位列表
     */
    List<UnitInfo> getList(Integer pageSize, Integer pageNum);

    /**
     * 修改单位
     */
    int update(Long id, UnitInfoParam unitInfoParam);

    /**
     * 创建单位
     */
    int deleteUnit(Long id);
}
