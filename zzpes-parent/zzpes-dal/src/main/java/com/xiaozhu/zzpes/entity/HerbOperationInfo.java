package com.xiaozhu.zzpes.entity;

import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;

public class HerbOperationInfo implements Serializable {
    @ApiModelProperty(value = "药品额外操作记录seq")
    private Long herbOperationSeq;

    @ApiModelProperty(value = "药材seq")
    private Integer herbSeq;

    @ApiModelProperty(value = "操作seq")
    private Integer operationSeq;

    @ApiModelProperty(value = "单位seq")
    private Integer unitSeq;

    private static final long serialVersionUID = 1L;

    public Long getHerbOperationSeq() {
        return herbOperationSeq;
    }

    public void setHerbOperationSeq(Long herbOperationSeq) {
        this.herbOperationSeq = herbOperationSeq;
    }

    public Integer getHerbSeq() {
        return herbSeq;
    }

    public void setHerbSeq(Integer herbSeq) {
        this.herbSeq = herbSeq;
    }

    public Integer getOperationSeq() {
        return operationSeq;
    }

    public void setOperationSeq(Integer operationSeq) {
        this.operationSeq = operationSeq;
    }

    public Integer getUnitSeq() {
        return unitSeq;
    }

    public void setUnitSeq(Integer unitSeq) {
        this.unitSeq = unitSeq;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", herbOperationSeq=").append(herbOperationSeq);
        sb.append(", herbSeq=").append(herbSeq);
        sb.append(", operationSeq=").append(operationSeq);
        sb.append(", unitSeq=").append(unitSeq);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}