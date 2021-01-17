package com.xiaozhu.zzpes.entity;

import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;

public class HerbUnitInfo implements Serializable {
    @ApiModelProperty(value = "药品计量单位seq")
    private Long herbUnitSeq;

    @ApiModelProperty(value = "药材seq")
    private Integer herbSeq;

    @ApiModelProperty(value = "单位seq")
    private Integer unitSeq;

    private static final long serialVersionUID = 1L;

    public Long getHerbUnitSeq() {
        return herbUnitSeq;
    }

    public void setHerbUnitSeq(Long herbUnitSeq) {
        this.herbUnitSeq = herbUnitSeq;
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

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", herbUnitSeq=").append(herbUnitSeq);
        sb.append(", herbSeq=").append(herbSeq);
        sb.append(", unitSeq=").append(unitSeq);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}