package com.xiaozhu.zzpes.controller.dict;

import com.macro.mall.common.api.CommonPage;
import com.macro.mall.common.api.CommonResult;
import com.xiaozhu.zzpes.entity.Jx3OcptInfo;
import com.xiaozhu.zzpes.service.Jx3OcptInfoService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * 职业Controller
 * Created by xiaozhu on 2021/01/14.
 */
@Controller
@Api(tags = "OcptController")
@RequestMapping("/ocpt")
public class OcptController {

    @Autowired
    private Jx3OcptInfoService ocptInfoService;

    @ApiOperation("获取所有职业")
    @RequestMapping(value = "/allList", method = RequestMethod.GET)
    @ResponseBody
    public CommonResult<CommonPage<Jx3OcptInfo>> getList() {
        List<Jx3OcptInfo> ocptInfos = ocptInfoService.selectAll();
        return CommonResult.success(CommonPage.restPage(ocptInfos));
    }
}
