package com.xiaozhu.zzpes.controller;

import com.xiaozhu.core.controller.BaseController;
import com.xiaozhu.zzpes.entity.Jx3ServerInfo;
import io.swagger.annotations.Api;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/jx3ServerInfo")
@Api(tags = "Jx3ServerInfoController", description = "Jx3ServerInfoController")
public class Jx3ServerInfoController extends BaseController<Jx3ServerInfo> {
}