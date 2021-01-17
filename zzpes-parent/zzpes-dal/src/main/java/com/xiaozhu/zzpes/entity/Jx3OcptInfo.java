package com.xiaozhu.zzpes.entity;

import io.swagger.annotations.ApiModelProperty;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Data;

/**
 * @description jx3_ocpt_info 实体对象
 * @version 1.0.0
 * @tableName jx3_ocpt_info
 * @author xiaozhu
 * @date 2021-01-17 12:00:06
 * @copyright 2021 xiaozhu
 */
@Data
@Table(name = "jx3_ocpt_info")
public class Jx3OcptInfo {
    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "剑三职业ID")
    @Id
    private Integer ocptId;

    @ApiModelProperty(value = "剑三职业名字")
    private String ocptName;

    @ApiModelProperty(value = "剑三职业CODE")
    private String ocptCode;
}