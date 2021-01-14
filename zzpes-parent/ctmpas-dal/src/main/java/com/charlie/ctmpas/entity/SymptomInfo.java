package com.charlie.ctmpas.entity;

import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;

public class SymptomInfo implements Serializable {
    @ApiModelProperty(value = "病症seq")
    private Long symptomSeq;

    @ApiModelProperty(value = "病症中文名")
    private String symptomName;

    private static final long serialVersionUID = 1L;

    public Long getSymptomSeq() {
        return symptomSeq;
    }

    public void setSymptomSeq(Long symptomSeq) {
        this.symptomSeq = symptomSeq;
    }

    public String getSymptomName() {
        return symptomName;
    }

    public void setSymptomName(String symptomName) {
        this.symptomName = symptomName;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", symptomSeq=").append(symptomSeq);
        sb.append(", symptomName=").append(symptomName);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}