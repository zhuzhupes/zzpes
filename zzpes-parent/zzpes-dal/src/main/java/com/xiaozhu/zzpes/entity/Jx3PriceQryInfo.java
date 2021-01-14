package com.xiaozhu.zzpes.entity;

import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import java.util.Date;

public class Jx3PriceQryInfo implements Serializable {
    @ApiModelProperty(value = "查询id主键")
    private Integer qryId;

    @ApiModelProperty(value = "批次号")
    private String batchId;

    @ApiModelProperty(value = "起始价格")
    private Integer startPrice;

    @ApiModelProperty(value = "结束价格")
    private Integer endPrice;

    @ApiModelProperty(value = "当前page")
    private Integer pageNo;

    @ApiModelProperty(value = "当前状态-0初始化；1-已执行；2-执行错误")
    private Integer state;

    @ApiModelProperty(value = "区间总条数")
    private Integer rangeTotalNums;

    @ApiModelProperty(value = "本业条数")
    private Integer nowPageDataNum;

    @ApiModelProperty(value = "创建时间")
    private Date createTime;

    @ApiModelProperty(value = "更新时间")
    private Date updateTime;

    private static final long serialVersionUID = 1L;

    public Integer getQryId() {
        return qryId;
    }

    public void setQryId(Integer qryId) {
        this.qryId = qryId;
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

    public Integer getPageNo() {
        return pageNo;
    }

    public void setPageNo(Integer pageNo) {
        this.pageNo = pageNo;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public Integer getRangeTotalNums() {
        return rangeTotalNums;
    }

    public void setRangeTotalNums(Integer rangeTotalNums) {
        this.rangeTotalNums = rangeTotalNums;
    }

    public Integer getNowPageDataNum() {
        return nowPageDataNum;
    }

    public void setNowPageDataNum(Integer nowPageDataNum) {
        this.nowPageDataNum = nowPageDataNum;
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
        sb.append(", qryId=").append(qryId);
        sb.append(", batchId=").append(batchId);
        sb.append(", startPrice=").append(startPrice);
        sb.append(", endPrice=").append(endPrice);
        sb.append(", pageNo=").append(pageNo);
        sb.append(", state=").append(state);
        sb.append(", rangeTotalNums=").append(rangeTotalNums);
        sb.append(", nowPageDataNum=").append(nowPageDataNum);
        sb.append(", createTime=").append(createTime);
        sb.append(", updateTime=").append(updateTime);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}