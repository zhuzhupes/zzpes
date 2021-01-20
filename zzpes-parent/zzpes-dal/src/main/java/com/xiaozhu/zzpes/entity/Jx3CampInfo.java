package com.xiaozhu.zzpes.entity;

import io.swagger.annotations.ApiModelProperty;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Data;

/**
 * @description jx3_camp_info 实体对象
 * @version 1.0.0
 * @tableName jx3_camp_info
 * @author xiaozhu
 * @date 2021-01-17 19:37:57
 * @copyright 2021 xiaozhu
 */
@Data
@Table(name = "jx3_camp_info")
public class Jx3CampInfo {
    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "阵营id")
    @Id
    private Integer campTypeId;

    @ApiModelProperty(value = "阵营名字")
    private String campTypeName;

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", campTypeId=").append(campTypeId);
        sb.append(", campTypeName=").append(campTypeName);
        sb.append("]");
        return sb.toString();
    }
}