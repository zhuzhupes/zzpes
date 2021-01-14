package com.charlie.ctmpas.dto;

import com.charlie.ctmpas.model.PrescriptionItem;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.Date;
import java.util.List;

@Data
@EqualsAndHashCode(callSuper = false)
public class SymptomInfoParam {

    @ApiModelProperty(value = "病症seq")
    private Long symptomSeq;

    @ApiModelProperty(value = "病症中文名")
    private String symptomName;

}
