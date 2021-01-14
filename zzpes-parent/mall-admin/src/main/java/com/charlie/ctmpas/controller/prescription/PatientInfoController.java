package com.charlie.ctmpas.controller.prescription;

import com.charlie.ctmpas.dto.PatientInfoParam;
import com.charlie.ctmpas.dto.UnitInfoParam;
import com.charlie.ctmpas.entity.PatientInfo;
import com.charlie.ctmpas.entity.UnitInfo;
import com.charlie.ctmpas.service.ParamManageUnitService;
import com.charlie.ctmpas.service.PatientInfoService;
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
@Api(tags = "PatientInfoController", description = "病人信息管理")
@RequestMapping("/patient")
public class PatientInfoController {
    @Autowired
    private PatientInfoService patientInfoService;


    @ApiOperation("分页获取所有单位属性")
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    @ResponseBody
    public CommonResult<CommonPage<PatientInfo>> getList(@RequestParam(defaultValue = "5") Integer pageSize, @RequestParam(defaultValue = "1") Integer pageNum) {
        List<PatientInfo> patientInfos = patientInfoService.getList(pageSize, pageNum);
        return CommonResult.success(CommonPage.restPage(patientInfos));
    }

    @ApiOperation("获取所有单位属性")
    @RequestMapping(value = "/allList", method = RequestMethod.GET)
    @ResponseBody
    public CommonResult<CommonPage<PatientInfo>> getList() {
        List<PatientInfo> patientInfos = patientInfoService.getAllList();
        return CommonResult.success(CommonPage.restPage(patientInfos));
    }


    @ApiOperation("修改计量单位属性")
    @RequestMapping(value = "/update/{id}", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult update(@PathVariable Long id,  @RequestBody PatientInfoParam patientInfoParam) {
        int count = patientInfoService.update(id, patientInfoParam);
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
        int count = patientInfoService.update(id, new PatientInfoParam());
        if (count == 1) {
            return CommonResult.success(null);
        } else {
            return CommonResult.failed();
        }
    }

}
