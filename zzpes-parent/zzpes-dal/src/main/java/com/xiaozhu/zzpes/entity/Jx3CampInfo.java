package com.xiaozhu.zzpes.entity;

import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;

public class Jx3CampInfo implements Serializable {
    @ApiModelProperty(value = "阵营id")
    private Integer campTypeId;

    @ApiModelProperty(value = "阵营名字")
    private String campTypeName;

    private static final long serialVersionUID = 1L;

    public Integer getCampTypeId() {
        return campTypeId;
    }

    public void setCampTypeId(Integer campTypeId) {
        this.campTypeId = campTypeId;
    }

    public String getCampTypeName() {
        return campTypeName;
    }

    public void setCampTypeName(String campTypeName) {
        this.campTypeName = campTypeName;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", campTypeId=").append(campTypeId);
        sb.append(", campTypeName=").append(campTypeName);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}