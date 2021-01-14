package com.charlie.ctmpas.service;



import com.charlie.ctmpas.dto.UnitInfoParam;
import com.charlie.ctmpas.entity.UnitInfo;
import com.macro.mall.dto.PmsProductAttributeCategoryItem;

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
