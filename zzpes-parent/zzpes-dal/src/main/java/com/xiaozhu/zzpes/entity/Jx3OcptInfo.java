package com.xiaozhu.zzpes.entity;

import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;

public class Jx3OcptInfo implements Serializable {
    @ApiModelProperty(value = "剑三职业ID")
    private Integer ocptId;

    @ApiModelProperty(value = "剑三职业名字")
    private String ocptName;

    @ApiModelProperty(value = "剑三职业CODE")
    private String ocptCode;

    private static final long serialVersionUID = 1L;

    public Integer getOcptId() {
        return ocptId;
    }

    public void setOcptId(Integer ocptId) {
        this.ocptId = ocptId;
    }

    public String getOcptName() {
        return ocptName;
    }

    public void setOcptName(String ocptName) {
        this.ocptName = ocptName;
    }

    public String getOcptCode() {
        return ocptCode;
    }

    public void setOcptCode(String ocptCode) {
        this.ocptCode = ocptCode;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", ocptId=").append(ocptId);
        sb.append(", ocptName=").append(ocptName);
        sb.append(", ocptCode=").append(ocptCode);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}