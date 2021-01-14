package com.charlie.ctmpas.entity;

import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import java.util.Date;

public class UnitInfo implements Serializable {
    @ApiModelProperty(value = "单位seq")
    private Long unitSeq;

    @ApiModelProperty(value = "单位中文名")
    private String unitName;

    @ApiModelProperty(value = "单位缩写")
    private String unitShortName;

    @ApiModelProperty(value = "创建日期")
    private Date createDate;

    @ApiModelProperty(value = "创建用户")
    private Long createUserId;

    private static final long serialVersionUID = 1L;

    public Long getUnitSeq() {
        return unitSeq;
    }

    public void setUnitSeq(Long unitSeq) {
        this.unitSeq = unitSeq;
    }

    public String getUnitName() {
        return unitName;
    }

    public void setUnitName(String unitName) {
        this.unitName = unitName;
    }

    public String getUnitShortName() {
        return unitShortName;
    }

    public void setUnitShortName(String unitShortName) {
        this.unitShortName = unitShortName;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Long getCreateUserId() {
        return createUserId;
    }

    public void setCreateUserId(Long createUserId) {
        this.createUserId = createUserId;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", unitSeq=").append(unitSeq);
        sb.append(", unitName=").append(unitName);
        sb.append(", unitShortName=").append(unitShortName);
        sb.append(", createDate=").append(createDate);
        sb.append(", createUserId=").append(createUserId);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}