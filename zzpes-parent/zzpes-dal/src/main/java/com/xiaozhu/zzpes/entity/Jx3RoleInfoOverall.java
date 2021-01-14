package com.xiaozhu.zzpes.entity;

import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import java.util.Date;

public class Jx3RoleInfoOverall implements Serializable {
    @ApiModelProperty(value = "剑三角色ID")
    private String jx3rId;

    @ApiModelProperty(value = "职业类型ID")
    private Integer ocptId;

    @ApiModelProperty(value = "体型类型ID")
    private Integer bodyShapeId;

    @ApiModelProperty(value = "价格")
    private Float price;

    @ApiModelProperty(value = "关注数")
    private Integer followNum;

    @ApiModelProperty(value = "资历")
    private Integer expPoint;

    @ApiModelProperty(value = "装备分数")
    private Integer equipPoint;

    @ApiModelProperty(value = "阵营")
    private Integer campTypeId;

    @ApiModelProperty(value = "服务器ID")
    private String serverId;

    @ApiModelProperty(value = "状态")
    private String state;

    @ApiModelProperty(value = "详情信息更新时间")
    private Date dtlInfoUpdateTime;

    @ApiModelProperty(value = "创建时间")
    private Date createTime;

    @ApiModelProperty(value = "更新时间")
    private Date updateTime;

    @ApiModelProperty(value = "剩余时间")
    private Integer remainingTime;

    @ApiModelProperty(value = "到期时间-将剩余时间转成时间的")
    private Date endTime;

    @ApiModelProperty(value = "详情信息")
    private byte[] dtlInfoContent;

    private static final long serialVersionUID = 1L;

    public String getJx3rId() {
        return jx3rId;
    }

    public void setJx3rId(String jx3rId) {
        this.jx3rId = jx3rId;
    }

    public Integer getOcptId() {
        return ocptId;
    }

    public void setOcptId(Integer ocptId) {
        this.ocptId = ocptId;
    }

    public Integer getBodyShapeId() {
        return bodyShapeId;
    }

    public void setBodyShapeId(Integer bodyShapeId) {
        this.bodyShapeId = bodyShapeId;
    }

    public Float getPrice() {
        return price;
    }

    public void setPrice(Float price) {
        this.price = price;
    }

    public Integer getFollowNum() {
        return followNum;
    }

    public void setFollowNum(Integer followNum) {
        this.followNum = followNum;
    }

    public Integer getExpPoint() {
        return expPoint;
    }

    public void setExpPoint(Integer expPoint) {
        this.expPoint = expPoint;
    }

    public Integer getEquipPoint() {
        return equipPoint;
    }

    public void setEquipPoint(Integer equipPoint) {
        this.equipPoint = equipPoint;
    }

    public Integer getCampTypeId() {
        return campTypeId;
    }

    public void setCampTypeId(Integer campTypeId) {
        this.campTypeId = campTypeId;
    }

    public String getServerId() {
        return serverId;
    }

    public void setServerId(String serverId) {
        this.serverId = serverId;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public Date getDtlInfoUpdateTime() {
        return dtlInfoUpdateTime;
    }

    public void setDtlInfoUpdateTime(Date dtlInfoUpdateTime) {
        this.dtlInfoUpdateTime = dtlInfoUpdateTime;
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

    public Integer getRemainingTime() {
        return remainingTime;
    }

    public void setRemainingTime(Integer remainingTime) {
        this.remainingTime = remainingTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public byte[] getDtlInfoContent() {
        return dtlInfoContent;
    }

    public void setDtlInfoContent(byte[] dtlInfoContent) {
        this.dtlInfoContent = dtlInfoContent;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", jx3rId=").append(jx3rId);
        sb.append(", ocptId=").append(ocptId);
        sb.append(", bodyShapeId=").append(bodyShapeId);
        sb.append(", price=").append(price);
        sb.append(", followNum=").append(followNum);
        sb.append(", expPoint=").append(expPoint);
        sb.append(", equipPoint=").append(equipPoint);
        sb.append(", campTypeId=").append(campTypeId);
        sb.append(", serverId=").append(serverId);
        sb.append(", state=").append(state);
        sb.append(", dtlInfoUpdateTime=").append(dtlInfoUpdateTime);
        sb.append(", createTime=").append(createTime);
        sb.append(", updateTime=").append(updateTime);
        sb.append(", remainingTime=").append(remainingTime);
        sb.append(", endTime=").append(endTime);
        sb.append(", dtlInfoContent=").append(dtlInfoContent);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}