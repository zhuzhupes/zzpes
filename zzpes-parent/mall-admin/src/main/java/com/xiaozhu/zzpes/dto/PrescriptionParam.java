package com.xiaozhu.zzpes.dto;

import com.xiaozhu.zzpes.model.LabelValueModel;
import com.xiaozhu.zzpes.model.PrescriptionItem;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;

@Data
@EqualsAndHashCode(callSuper = false)
public class PrescriptionParam {

    @ApiModelProperty(value = "用户顺序号")
    private String patientSeq;

    @ApiModelProperty(value = "患者名字")
    private String patientName;

    @ApiModelProperty(value = "性别")
    private String patientSex;

    @ApiModelProperty(value = "日期")
    private String inputDate;

    @ApiModelProperty(value = "症状")
    private List<LabelValueModel> symptoms;

    @ApiModelProperty(value = "药物")
    private List<PrescriptionItem> herbs;
}
