package com.xiaozhu.zzpes.controller;

import com.macro.mall.dto.Jx3DtlVagueQryParam;
import com.xiaozhu.core.controller.BaseController;
import com.xiaozhu.http.api.CommonPage;
import com.xiaozhu.http.api.CommonResult;
import com.xiaozhu.zzpes.entity.Jx3DtlInfo;
import com.xiaozhu.zzpes.entity.Jx3OcptInfo;
import io.swagger.annotations.Api;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import tk.mybatis.mapper.entity.Example;

import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/jx3OcptInfo")
@Api(tags = "Jx3OcptInfoController", description = "Jx3OcptInfoController")
public class Jx3OcptInfoController extends BaseController<Jx3OcptInfo> {



    @PostMapping("/vagueQry")
    @ResponseBody
    public CommonResult update(@RequestBody Jx3DtlVagueQryParam qryParam) {
        List<Jx3OcptInfo> resList = service.selectAll();
        return com.xiaozhu.http.api.CommonResult.success(CommonPage.restPage(resList));
    }
}