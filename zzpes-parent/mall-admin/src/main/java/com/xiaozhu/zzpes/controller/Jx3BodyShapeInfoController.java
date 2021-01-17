package com.xiaozhu.zzpes.controller;

import com.xiaozhu.core.controller.BaseController;
import com.xiaozhu.zzpes.entity.Jx3BodyShapeInfo;
import io.swagger.annotations.Api;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/jx3BodyShapeInfo")
@Api(tags = "Jx3BodyShapeInfoController", description = "Jx3BodyShapeInfoController")
public class Jx3BodyShapeInfoController extends BaseController<Jx3BodyShapeInfo> {
}