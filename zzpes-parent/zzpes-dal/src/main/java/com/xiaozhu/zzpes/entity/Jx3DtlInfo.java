package com.xiaozhu.zzpes.entity;

import io.swagger.annotations.ApiModelProperty;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Data;

/**
 * @description jx3_dtl_info 实体对象
 * @version 1.0.0
 * @tableName jx3_dtl_info
 * @author xiaozhu
 * @date 2021-01-18 14:00:03
 * @copyright 2021 xiaozhu
 */
@Data
@Table(name = "jx3_dtl_info")
public class Jx3DtlInfo {
    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "详情日志ID")
    @Id
    private Integer dtlId;

    @ApiModelProperty(value = "详情类别")
    private String dtlType;

    @ApiModelProperty(value = "详情小类")
    private String dtlTypeDtl;

    @ApiModelProperty(value = "详情具体id")
    private Integer dtlTypeId;

    @ApiModelProperty(value = "详情图标URL")
    private String dtlUrl;

    @ApiModelProperty(value = "详情别称")
    private String dtlAliace;

    @ApiModelProperty(value = "详情中文名称")
    private String dtlZhcnName;

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", dtlId=").append(dtlId);
        sb.append(", dtlType=").append(dtlType);
        sb.append(", dtlTypeDtl=").append(dtlTypeDtl);
        sb.append(", dtlTypeId=").append(dtlTypeId);
        sb.append(", dtlUrl=").append(dtlUrl);
        sb.append(", dtlAliace=").append(dtlAliace);
        sb.append(", dtlZhcnName=").append(dtlZhcnName);
        sb.append("]");
        return sb.toString();
    }
}