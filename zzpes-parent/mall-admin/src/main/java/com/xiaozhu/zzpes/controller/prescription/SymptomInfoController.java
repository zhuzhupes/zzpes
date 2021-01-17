package com.xiaozhu.zzpes.controller.prescription;

import com.xiaozhu.zzpes.entity.PatientInfo;
import com.xiaozhu.zzpes.entity.SymptomInfo;
import com.xiaozhu.zzpes.service.PatientInfoService;
import com.xiaozhu.zzpes.service.SymptomInfoService;
import com.macro.mall.common.api.CommonPage;
import com.macro.mall.common.api.CommonResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 单位管理Controller
 * Created by macro on 2018/4/26.
 */
@Controller
@Api(tags = "SymptomInfoController", description = "症状管理")
@RequestMapping("/symptom")
public class SymptomInfoController {
    @Autowired
    private PatientInfoService patientInfoService;

    @Autowired
    private SymptomInfoService symptomInfoService;

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
    public CommonResult<CommonPage<SymptomInfo>> getList() {
        List<SymptomInfo> patientInfos = symptomInfoService.getAllList();
        return CommonResult.success(CommonPage.restPage(patientInfos));
    }
}
