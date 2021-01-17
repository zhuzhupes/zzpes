package com.xiaozhu.zzpes.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
public class SymptomInfoParam {

    @ApiModelProperty(value = "病症seq")
    private Long symptomSeq;

    @ApiModelProperty(value = "病症中文名")
    private String symptomName;

}
