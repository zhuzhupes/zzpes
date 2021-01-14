package com.charlie.ctmpas.entity;

import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import java.util.Date;

public class PatientInfo implements Serializable {
    @ApiModelProperty(value = "病人seq号")
    private Long patientSeq;

    @ApiModelProperty(value = "病人名")
    private String patientName;

    @ApiModelProperty(value = "首次时间")
    private Date startDate;

    @ApiModelProperty(value = "治疗次数")
    private Integer treatTimes;

    @ApiModelProperty(value = "治愈次数")
    private Integer cureTimes;

    @ApiModelProperty(value = "上次更新时间")
    private Date lastUpdateTime;

    @ApiModelProperty(value = "上次更新操作")
    private String lastUpdateType;

    @ApiModelProperty(value = "上次更新操作员")
    private String lastUpdateUser;

    private static final long serialVersionUID = 1L;

    public Long getPatientSeq() {
        return patientSeq;
    }

    public void setPatientSeq(Long patientSeq) {
        this.patientSeq = patientSeq;
    }

    public String getPatientName() {
        return patientName;
    }

    public void setPatientName(String patientName) {
        this.patientName = patientName;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Integer getTreatTimes() {
        return treatTimes;
    }

    public void setTreatTimes(Integer treatTimes) {
        this.treatTimes = treatTimes;
    }

    public Integer getCureTimes() {
        return cureTimes;
    }

    public void setCureTimes(Integer cureTimes) {
        this.cureTimes = cureTimes;
    }

    public Date getLastUpdateTime() {
        return lastUpdateTime;
    }

    public void setLastUpdateTime(Date lastUpdateTime) {
        this.lastUpdateTime = lastUpdateTime;
    }

    public String getLastUpdateType() {
        return lastUpdateType;
    }

    public void setLastUpdateType(String lastUpdateType) {
        this.lastUpdateType = lastUpdateType;
    }

    public String getLastUpdateUser() {
        return lastUpdateUser;
    }

    public void setLastUpdateUser(String lastUpdateUser) {
        this.lastUpdateUser = lastUpdateUser;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", patientSeq=").append(patientSeq);
        sb.append(", patientName=").append(patientName);
        sb.append(", startDate=").append(startDate);
        sb.append(", treatTimes=").append(treatTimes);
        sb.append(", cureTimes=").append(cureTimes);
        sb.append(", lastUpdateTime=").append(lastUpdateTime);
        sb.append(", lastUpdateType=").append(lastUpdateType);
        sb.append(", lastUpdateUser=").append(lastUpdateUser);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}