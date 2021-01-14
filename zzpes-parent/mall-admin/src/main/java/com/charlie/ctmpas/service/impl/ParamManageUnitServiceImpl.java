package com.charlie.ctmpas.service.impl;

import com.charlie.ctmpas.common.CommonUtils;
import com.charlie.ctmpas.dto.UnitInfoParam;
import com.charlie.ctmpas.entity.UnitInfo;
import com.charlie.ctmpas.entity.UnitInfoExample;
import com.charlie.ctmpas.mapper.UnitInfoMapper;
import com.charlie.ctmpas.service.ParamManageUnitService;
import com.github.pagehelper.PageHelper;
import com.macro.mall.model.CmsPrefrenceArea;
import com.macro.mall.model.CmsPrefrenceAreaExample;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 商品品牌Service实现类
 * Created by macro on 2018/4/26.
 */
@Service
public class ParamManageUnitServiceImpl implements ParamManageUnitService {
    @Autowired
    private UnitInfoMapper unitMapper;


    public int createUnit(UnitInfoParam unitInfoParam) {
        UnitInfo unitInfo = new UnitInfo();
        if(CommonUtils.isNullOrEmpty(unitInfoParam.getUnitShortName())){
            //如果缩写为空，则将中文名字设置为缩写
            unitInfoParam.setUnitShortName(unitInfoParam.getUnitName());
        }
        unitInfoParam.setCreateDate(CommonUtils.getCurrentDate());
        unitInfoParam.setCreateUserId(CommonUtils.getCurrentUserId());
        BeanUtils.copyProperties(unitInfoParam, unitInfo);
        return unitMapper.insertSelective(unitInfo);
    }

    public List<UnitInfo> getList(Integer pageSize, Integer pageNum) {
        if(pageSize != 0 && pageNum != 0){
            PageHelper.startPage(pageNum,pageSize);
        }
        return unitMapper.selectByExample(new UnitInfoExample());
    }

    public int update(Long id, UnitInfoParam unitInfoParam) {
        UnitInfo unitInfo = new UnitInfo();
        if(CommonUtils.isNullOrEmpty(unitInfoParam.getUnitShortName())){
            //如果缩写为空，则将中文名字设置为缩写
            unitInfoParam.setUnitShortName(unitInfoParam.getUnitName());
        }
        unitInfoParam.setCreateDate(CommonUtils.getCurrentDate());
        unitInfoParam.setCreateUserId(CommonUtils.getCurrentUserId());
        BeanUtils.copyProperties(unitInfoParam, unitInfo);
        unitInfo.setUnitSeq(id);
        return unitMapper.updateByPrimaryKey(unitInfo);
    }

    public int deleteUnit(Long id) {
        return unitMapper.deleteByPrimaryKey(id);
    }
}
