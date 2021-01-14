package com.charlie.ctmpas.controller.prescription;

import com.charlie.ctmpas.dto.PrescriptionParam;
import com.charlie.ctmpas.dto.UnitInfoParam;
import com.charlie.ctmpas.entity.UnitInfo;
import com.charlie.ctmpas.service.ParamManageUnitService;
import com.charlie.ctmpas.service.PrescriptionMgmtService;
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
@Api(tags = "PrescriptionMgmtController", description = "药方管理")
@RequestMapping("/prescription")
public class PrescriptionMgmtController {
    @Autowired
    private PrescriptionMgmtService prescriptionMgmtService;

    @ApiOperation(value = "添加单位")
    @RequestMapping(value = "/create", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult create(@Validated @RequestBody PrescriptionParam prescriptionParam, BindingResult result) {
        CommonResult commonResult;
        int count = prescriptionMgmtService.createPrescription(prescriptionParam);
        if (count == 1) {
            commonResult = CommonResult.success(count);
        } else {
            commonResult = CommonResult.failed();
        }
        return commonResult;
    }
}
