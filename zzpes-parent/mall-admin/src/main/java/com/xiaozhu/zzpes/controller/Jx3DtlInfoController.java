package com.xiaozhu.zzpes.controller;

import com.macro.mall.dto.Jx3DtlVagueQryParam;
import com.xiaozhu.core.controller.BaseController;
import com.xiaozhu.http.api.CommonPage;
import com.xiaozhu.http.api.CommonResult;
import com.xiaozhu.zzpes.entity.Jx3DtlInfo;
import com.xiaozhu.zzpes.entity.OmsOrderSetting;
import io.swagger.annotations.Api;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

@Controller
@RequestMapping("/jx3DtlInfo")
@Api(tags = "Jx3DtlInfoController", description = "Jx3DtlInfoController")
public class Jx3DtlInfoController extends BaseController<Jx3DtlInfo> {


    @PostMapping("/vagueQry")
    @ResponseBody
    public CommonResult update(@RequestBody Jx3DtlVagueQryParam qryParam) {

        List<Jx3DtlInfo> resList = null;
        Example example = new Example(cls);
        String value = qryParam.getValue();
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("dtlType", qryParam.getDtlType())
                .andEqualTo("dtlTypeDtl", qryParam.getDtlTypeDtl());
//        criteria.andcon
        criteria.andLike("dtlZhcnName", "%"+String.format(qryParam.getValue())+"%");
        resList = service.page(0, 30).selectByExample(example);
        if(resList.size()>100){
            resList = resList.subList(0, 100);
        }
        return com.xiaozhu.http.api.CommonResult.success(CommonPage.restPage(resList));
    }
}