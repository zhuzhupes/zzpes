package com.xiaozhu.zzpes.controller;

import com.xiaozhu.core.controller.BaseController;
import com.xiaozhu.zzpes.entity.Jx3CampInfo;
import io.swagger.annotations.Api;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/jx3CampInfo")
@Api(tags = "Jx3CampInfoController", description = "Jx3CampInfoController")
public class Jx3CampInfoController extends BaseController<Jx3CampInfo> {
}