package com.charlie.ctmpas.entity;

import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;

public class OperationInfo implements Serializable {
    @ApiModelProperty(value = "操作seq")
    private Integer operationSeq;

    @ApiModelProperty(value = "操作名")
    private String operationName;

    private static final long serialVersionUID = 1L;

    public Integer getOperationSeq() {
        return operationSeq;
    }

    public void setOperationSeq(Integer operationSeq) {
        this.operationSeq = operationSeq;
    }

    public String getOperationName() {
        return operationName;
    }

    public void setOperationName(String operationName) {
        this.operationName = operationName;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", operationSeq=").append(operationSeq);
        sb.append(", operationName=").append(operationName);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}