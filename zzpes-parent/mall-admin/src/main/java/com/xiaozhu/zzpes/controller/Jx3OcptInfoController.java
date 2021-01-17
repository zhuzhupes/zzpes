package com.xiaozhu.zzpes.controller;

import com.xiaozhu.core.controller.BaseController;
import com.xiaozhu.zzpes.entity.Jx3OcptInfo;
import io.swagger.annotations.Api;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/jx3OcptInfo")
@Api(tags = "Jx3OcptInfoController", description = "Jx3OcptInfoController")
public class Jx3OcptInfoController extends BaseController<Jx3OcptInfo> {
}