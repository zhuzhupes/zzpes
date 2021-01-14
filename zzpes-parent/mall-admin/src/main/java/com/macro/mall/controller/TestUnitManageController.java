package com.macro.mall.controller;

import com.charlie.ctmpas.dto.UnitInfoParam;
import com.charlie.ctmpas.service.ParamManageUnitService;
import com.macro.mall.common.api.CommonResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 单位管理Controller
 * Created by macro on 2018/4/26.
 */
@Controller
@Api(tags = "UnitManageController", description = "单位管理")
@RequestMapping("/unit33")
public class TestUnitManageController {
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
}
