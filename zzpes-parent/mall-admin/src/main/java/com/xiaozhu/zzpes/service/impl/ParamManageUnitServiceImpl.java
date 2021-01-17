package com.xiaozhu.zzpes.service.impl;

import com.xiaozhu.zzpes.common.CommonUtils;
import com.xiaozhu.zzpes.dto.UnitInfoParam;
import com.xiaozhu.zzpes.entity.UnitInfo;
import com.xiaozhu.zzpes.entity.UnitInfoExample;
import com.xiaozhu.zzpes.mapper.UnitInfoMapper;
import com.xiaozhu.zzpes.service.ParamManageUnitService;
import com.github.pagehelper.PageHelper;
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


    @Override
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

    @Override
    public List<UnitInfo> getList(Integer pageSize, Integer pageNum) {
        if(pageSize != 0 && pageNum != 0){
            PageHelper.startPage(pageNum,pageSize);
        }
        return unitMapper.selectByExample(new UnitInfoExample());
    }

    @Override
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

    @Override
    public int deleteUnit(Long id) {
        return unitMapper.deleteByPrimaryKey(id);
    }
}
