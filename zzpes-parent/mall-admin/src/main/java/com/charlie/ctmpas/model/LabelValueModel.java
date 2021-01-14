package com.charlie.ctmpas.model;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author 2020/8/13 zhucl Create 1.0 <br>
 * @version 1.0.0
 * @description 描述。
 * @copyright ©2019-2019 cbcc.cn. All Copyright Reserved.
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class LabelValueModel {
    @ApiModelProperty(value = "值")
    private String value;

    @ApiModelProperty(value = "名字")
    private String label;
}
