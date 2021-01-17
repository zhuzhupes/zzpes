package com.xiaozhu.zzpes.controller.param;

import com.xiaozhu.zzpes.dto.UnitInfoParam;
import com.xiaozhu.zzpes.entity.UnitInfo;
import com.xiaozhu.zzpes.service.ParamManageUnitService;
import com.macro.mall.common.api.CommonPage;
import com.macro.mall.common.api.CommonResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 单位管理Controller
 * Created by macro on 2018/4/26.
 */
@Controller
@Api(tags = "UnitManageController", description = "单位管理")
@RequestMapping("/unit")
public class UnitManageController {
    @Autowired
    private ParamManageUnitService unitService;

    @ApiOperation(value = "添加单位")
    @RequestMapping(value = "/create", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult create(@Validated @RequestBody UnitInfoParam unitInfoParam, BindingResult result) {
        CommonResult commonResult;
        int count = unitService.createUnit(unitInfoParam);
        if (count == 1) {
            commonResult = CommonResult.success(count);
        } else {
            commonResult = CommonResult.failed();
        }
        return commonResult;
    }

    @ApiOperation("分页获取所有单位属性")
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    @ResponseBody
    public CommonResult<CommonPage<UnitInfo>> getList(@RequestParam(defaultValue = "5") Integer pageSize, @RequestParam(defaultValue = "1") Integer pageNum) {
        List<UnitInfo> unitInfoList = unitService.getList(pageSize, pageNum);
        return CommonResult.success(CommonPage.restPage(unitInfoList));
    }

    @ApiOperation("修改计量单位属性")
    @RequestMapping(value = "/update/{id}", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult update(@PathVariable Long id,  @RequestBody UnitInfoParam unitInfoParam) {
        int count = unitService.update(id, unitInfoParam);
        if (count > 0) {
            return CommonResult.success(count);
        } else {
            return CommonResult.failed();
        }
    }

    @ApiOperation(value = "删除单位属性")
    @RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
    @ResponseBody
    public CommonResult delete(@PathVariable("id") Long id) {
        int count = unitService.deleteUnit(id);
        if (count == 1) {
            return CommonResult.success(null);
        } else {
            return CommonResult.failed();
        }
    }

}
