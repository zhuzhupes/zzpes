package com.macro.mall.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
public class Jx3DtlVagueQryParam {
    @ApiModelProperty("详情分类")
    private String dtlType;
    @ApiModelProperty("详情大类")
    private String dtlTypeDtl;
    @ApiModelProperty("模糊查询值")
    private String value;
}
