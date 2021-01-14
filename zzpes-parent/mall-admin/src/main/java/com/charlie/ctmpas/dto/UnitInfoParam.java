package com.charlie.ctmpas.dto;

import com.macro.mall.validator.FlagValidator;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import java.util.Date;

/**
 * 品牌传递参数
 * Created by macro on 2018/4/26.
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class UnitInfoParam {

    @ApiModelProperty(value = "单位中文名")
    @NotEmpty(message = "名称不能为空")
    private String unitName;

    @ApiModelProperty(value = "单位缩写")
    private String unitShortName;

    @ApiModelProperty(value = "创建日期")
    private Date createDate;

    @ApiModelProperty(value = "创建用户")
    private Long createUserId;
}
