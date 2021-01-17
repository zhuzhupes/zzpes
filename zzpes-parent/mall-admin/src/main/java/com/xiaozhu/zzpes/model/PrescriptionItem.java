package com.xiaozhu.zzpes.model;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
public class PrescriptionItem {

    @ApiModelProperty(value = "药材seq")
    private String herb;

    @ApiModelProperty(value = "单位seq")
    private String herb_nums;

    @ApiModelProperty(value = "单位数量")
    private String unitType;

    @ApiModelProperty(value = "操作seq")
    private String opeationType;

    @ApiModelProperty(value = "操作单位")
    private String operationValue;

    @ApiModelProperty(value = "单位次数")
    private String operationUnit;
}
