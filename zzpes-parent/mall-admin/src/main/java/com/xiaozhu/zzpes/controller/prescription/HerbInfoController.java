package com.xiaozhu.zzpes.controller.prescription;

import com.xiaozhu.zzpes.entity.HerbInfo;
import com.xiaozhu.zzpes.service.HerbInfoService;
import com.xiaozhu.zzpes.service.PatientInfoService;
import com.macro.mall.common.api.CommonPage;
import com.macro.mall.common.api.CommonResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * 单位管理Controller
 * Created by macro on 2018/4/26.
 */
@Controller
@Api(tags = "HerbInfoController", description = "症状管理")
@RequestMapping("/herb")
public class HerbInfoController {
    @Autowired
    private PatientInfoService patientInfoService;

    @Autowired
    private HerbInfoService herbInfoService;

    @ApiOperation("获取所有单位属性")
    @RequestMapping(value = "/allList", method = RequestMethod.GET)
    @ResponseBody
    public CommonResult<CommonPage<HerbInfo>> getList() {
        List<HerbInfo> patientInfos = herbInfoService.getAllList();
        return CommonResult.success(CommonPage.restPage(patientInfos));
    }
}
