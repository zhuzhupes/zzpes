package com.xiaozhu.zzpes.entity;

import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;

public class PrescriptionInfo implements Serializable {
    @ApiModelProperty(value = "处方主键")
    private Long prescriptionSeq;

    @ApiModelProperty(value = "开方记录id")
    private Integer prescriptionId;

    @ApiModelProperty(value = "药材seq")
    private Integer herbSeq;

    @ApiModelProperty(value = "单位seq")
    private Integer unitSeq;

    @ApiModelProperty(value = "单位数量")
    private Integer unitNum;

    @ApiModelProperty(value = "操作seq")
    private Integer operationSeq;

    @ApiModelProperty(value = "操作单位")
    private Integer operationUnitSeq;

    @ApiModelProperty(value = "单位次数")
    private Integer operationUnitNum;

    private static final long serialVersionUID = 1L;

    public Long getPrescriptionSeq() {
        return prescriptionSeq;
    }

    public void setPrescriptionSeq(Long prescriptionSeq) {
        this.prescriptionSeq = prescriptionSeq;
    }

    public Integer getPrescriptionId() {
        return prescriptionId;
    }

    public void setPrescriptionId(Integer prescriptionId) {
        this.prescriptionId = prescriptionId;
    }

    public Integer getHerbSeq() {
        return herbSeq;
    }

    public void setHerbSeq(Integer herbSeq) {
        this.herbSeq = herbSeq;
    }

    public Integer getUnitSeq() {
        return unitSeq;
    }

    public void setUnitSeq(Integer unitSeq) {
        this.unitSeq = unitSeq;
    }

    public Integer getUnitNum() {
        return unitNum;
    }

    public void setUnitNum(Integer unitNum) {
        this.unitNum = unitNum;
    }

    public Integer getOperationSeq() {
        return operationSeq;
    }

    public void setOperationSeq(Integer operationSeq) {
        this.operationSeq = operationSeq;
    }

    public Integer getOperationUnitSeq() {
        return operationUnitSeq;
    }

    public void setOperationUnitSeq(Integer operationUnitSeq) {
        this.operationUnitSeq = operationUnitSeq;
    }

    public Integer getOperationUnitNum() {
        return operationUnitNum;
    }

    public void setOperationUnitNum(Integer operationUnitNum) {
        this.operationUnitNum = operationUnitNum;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", prescriptionSeq=").append(prescriptionSeq);
        sb.append(", prescriptionId=").append(prescriptionId);
        sb.append(", herbSeq=").append(herbSeq);
        sb.append(", unitSeq=").append(unitSeq);
        sb.append(", unitNum=").append(unitNum);
        sb.append(", operationSeq=").append(operationSeq);
        sb.append(", operationUnitSeq=").append(operationUnitSeq);
        sb.append(", operationUnitNum=").append(operationUnitNum);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}