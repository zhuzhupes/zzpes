package com.xiaozhu.zzpes.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.validation.constraints.NotEmpty;
import java.util.Date;

/**
 * 品牌传递参数
 * Created by macro on 2018/4/26.
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class PatientInfoParam {


    @ApiModelProperty(value = "病人seq号")
    private Long patientSeq;

    @ApiModelProperty(value = "病人名")
    @NotEmpty(message = "病人名字不能为空")
    private String patientName;


    @ApiModelProperty(value = "性别")
    private String patientSex;

    @ApiModelProperty(value = "首次时间")
    private Date startDate;

    @ApiModelProperty(value = "治疗次数")
    private Integer treatTimes;

    @ApiModelProperty(value = "治愈次数")
    private Integer cureTimes;

    @ApiModelProperty(value = "上次更新时间")
    private Date lastUpdateTime;

    @ApiModelProperty(value = "上次更新操作")
    private String lastUpdateType;

    @ApiModelProperty(value = "上次更新操作员")
    private String lastUpdateUser;

}
