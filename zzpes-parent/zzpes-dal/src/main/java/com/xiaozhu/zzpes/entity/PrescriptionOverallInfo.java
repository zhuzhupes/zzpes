package com.xiaozhu.zzpes.entity;

import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import java.util.Date;

public class PrescriptionOverallInfo implements Serializable {
    @ApiModelProperty(value = "开方记录id")
    private Long prescriptionId;

    @ApiModelProperty(value = "用户id")
    private String patientId;

    @ApiModelProperty(value = "上次药方记录id")
    private String prescriptionLastId;

    @ApiModelProperty(value = "下次药方记录id")
    private String prescriptionNextId;

    @ApiModelProperty(value = "最终状态")
    private String finalState;

    @ApiModelProperty(value = "开方时间")
    private Date prescriptionDate;

    private static final long serialVersionUID = 1L;

    public Long getPrescriptionId() {
        return prescriptionId;
    }

    public void setPrescriptionId(Long prescriptionId) {
        this.prescriptionId = prescriptionId;
    }

    public String getPatientId() {
        return patientId;
    }

    public void setPatientId(String patientId) {
        this.patientId = patientId;
    }

    public String getPrescriptionLastId() {
        return prescriptionLastId;
    }

    public void setPrescriptionLastId(String prescriptionLastId) {
        this.prescriptionLastId = prescriptionLastId;
    }

    public String getPrescriptionNextId() {
        return prescriptionNextId;
    }

    public void setPrescriptionNextId(String prescriptionNextId) {
        this.prescriptionNextId = prescriptionNextId;
    }

    public String getFinalState() {
        return finalState;
    }

    public void setFinalState(String finalState) {
        this.finalState = finalState;
    }

    public Date getPrescriptionDate() {
        return prescriptionDate;
    }

    public void setPrescriptionDate(Date prescriptionDate) {
        this.prescriptionDate = prescriptionDate;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", prescriptionId=").append(prescriptionId);
        sb.append(", patientId=").append(patientId);
        sb.append(", prescriptionLastId=").append(prescriptionLastId);
        sb.append(", prescriptionNextId=").append(prescriptionNextId);
        sb.append(", finalState=").append(finalState);
        sb.append(", prescriptionDate=").append(prescriptionDate);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}