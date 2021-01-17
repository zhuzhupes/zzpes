package com.xiaozhu.zzpes.entity;

import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;

public class Jx3AdtTypeKey implements Serializable {
    @ApiModelProperty(value = "详情类型")
    private String dtlType;

    @ApiModelProperty(value = "结果key")
    private String dtlResKey;

    @ApiModelProperty(value = "详情类型名称")
    private String dtlName;

    private static final long serialVersionUID = 1L;

    public String getDtlType() {
        return dtlType;
    }

    public void setDtlType(String dtlType) {
        this.dtlType = dtlType;
    }

    public String getDtlResKey() {
        return dtlResKey;
    }

    public void setDtlResKey(String dtlResKey) {
        this.dtlResKey = dtlResKey;
    }

    public String getDtlName() {
        return dtlName;
    }

    public void setDtlName(String dtlName) {
        this.dtlName = dtlName;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", dtlType=").append(dtlType);
        sb.append(", dtlResKey=").append(dtlResKey);
        sb.append(", dtlName=").append(dtlName);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}