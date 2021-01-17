package com.xiaozhu.zzpes.entity;

import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import java.util.Date;

public class Jx3PricePeriodErrorInfo implements Serializable {
    @ApiModelProperty(value = "错误ID")
    private Integer errorId;

    @ApiModelProperty(value = "批次号")
    private String batchId;

    @ApiModelProperty(value = "起始价格")
    private Integer startPrice;

    @ApiModelProperty(value = "结束价格")
    private Integer endPrice;

    @ApiModelProperty(value = "错误状态")
    private Integer errorState;

    @ApiModelProperty(value = "错误page号")
    private Integer errorPageNo;

    @ApiModelProperty(value = "更新时间")
    private Date createTime;

    @ApiModelProperty(value = "错误状态")
    private Date updateTime;

    private static final long serialVersionUID = 1L;

    public Integer getErrorId() {
        return errorId;
    }

    public void setErrorId(Integer errorId) {
        this.errorId = errorId;
    }

    public String getBatchId() {
        return batchId;
    }

    public void setBatchId(String batchId) {
        this.batchId = batchId;
    }

    public Integer getStartPrice() {
        return startPrice;
    }

    public void setStartPrice(Integer startPrice) {
        this.startPrice = startPrice;
    }

    public Integer getEndPrice() {
        return endPrice;
    }

    public void setEndPrice(Integer endPrice) {
        this.endPrice = endPrice;
    }

    public Integer getErrorState() {
        return errorState;
    }

    public void setErrorState(Integer errorState) {
        this.errorState = errorState;
    }

    public Integer getErrorPageNo() {
        return errorPageNo;
    }

    public void setErrorPageNo(Integer errorPageNo) {
        this.errorPageNo = errorPageNo;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", errorId=").append(errorId);
        sb.append(", batchId=").append(batchId);
        sb.append(", startPrice=").append(startPrice);
        sb.append(", endPrice=").append(endPrice);
        sb.append(", errorState=").append(errorState);
        sb.append(", errorPageNo=").append(errorPageNo);
        sb.append(", createTime=").append(createTime);
        sb.append(", updateTime=").append(updateTime);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}