package com.xiaozhu.zzpes.entity;

import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;

public class Jx3BodyShapeInfo implements Serializable {
    @ApiModelProperty(value = "体型ID")
    private Integer bodyShapeId;

    @ApiModelProperty(value = "体型名称")
    private String bodyShapeName;

    private static final long serialVersionUID = 1L;

    public Integer getBodyShapeId() {
        return bodyShapeId;
    }

    public void setBodyShapeId(Integer bodyShapeId) {
        this.bodyShapeId = bodyShapeId;
    }

    public String getBodyShapeName() {
        return bodyShapeName;
    }

    public void setBodyShapeName(String bodyShapeName) {
        this.bodyShapeName = bodyShapeName;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", bodyShapeId=").append(bodyShapeId);
        sb.append(", bodyShapeName=").append(bodyShapeName);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}