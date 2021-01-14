package com.xiaozhu.zzpes.entity;

import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;

public class Jx3DtlInfo implements Serializable {
    @ApiModelProperty(value = "详情日志ID")
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

    private static final long serialVersionUID = 1L;

    public Integer getDtlId() {
        return dtlId;
    }

    public void setDtlId(Integer dtlId) {
        this.dtlId = dtlId;
    }

    public String getDtlType() {
        return dtlType;
    }

    public void setDtlType(String dtlType) {
        this.dtlType = dtlType;
    }

    public String getDtlTypeDtl() {
        return dtlTypeDtl;
    }

    public void setDtlTypeDtl(String dtlTypeDtl) {
        this.dtlTypeDtl = dtlTypeDtl;
    }

    public Integer getDtlTypeId() {
        return dtlTypeId;
    }

    public void setDtlTypeId(Integer dtlTypeId) {
        this.dtlTypeId = dtlTypeId;
    }

    public String getDtlUrl() {
        return dtlUrl;
    }

    public void setDtlUrl(String dtlUrl) {
        this.dtlUrl = dtlUrl;
    }

    public String getDtlAliace() {
        return dtlAliace;
    }

    public void setDtlAliace(String dtlAliace) {
        this.dtlAliace = dtlAliace;
    }

    public String getDtlZhcnName() {
        return dtlZhcnName;
    }

    public void setDtlZhcnName(String dtlZhcnName) {
        this.dtlZhcnName = dtlZhcnName;
    }

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
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}