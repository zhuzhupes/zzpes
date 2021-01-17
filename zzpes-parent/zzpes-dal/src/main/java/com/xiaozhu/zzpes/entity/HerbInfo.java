package com.xiaozhu.zzpes.entity;

import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;

public class HerbInfo implements Serializable {
    @ApiModelProperty(value = "药材seq")
    private Long herbSeq;

    @ApiModelProperty(value = "药材中文名")
    private String herbName;

    @ApiModelProperty(value = "药材英文名字")
    private String herbEngName;

    @ApiModelProperty(value = "药材功效")
    private String herbFunction;

    @ApiModelProperty(value = "对应病症")
    private String herbDisease;

    private static final long serialVersionUID = 1L;

    public Long getHerbSeq() {
        return herbSeq;
    }

    public void setHerbSeq(Long herbSeq) {
        this.herbSeq = herbSeq;
    }

    public String getHerbName() {
        return herbName;
    }

    public void setHerbName(String herbName) {
        this.herbName = herbName;
    }

    public String getHerbEngName() {
        return herbEngName;
    }

    public void setHerbEngName(String herbEngName) {
        this.herbEngName = herbEngName;
    }

    public String getHerbFunction() {
        return herbFunction;
    }

    public void setHerbFunction(String herbFunction) {
        this.herbFunction = herbFunction;
    }

    public String getHerbDisease() {
        return herbDisease;
    }

    public void setHerbDisease(String herbDisease) {
        this.herbDisease = herbDisease;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", herbSeq=").append(herbSeq);
        sb.append(", herbName=").append(herbName);
        sb.append(", herbEngName=").append(herbEngName);
        sb.append(", herbFunction=").append(herbFunction);
        sb.append(", herbDisease=").append(herbDisease);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}