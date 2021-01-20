package com.xiaozhu.zzpes.entity;

import io.swagger.annotations.ApiModelProperty;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Data;

/**
 * @description jx3_body_shape_info 实体对象
 * @version 1.0.0
 * @tableName jx3_body_shape_info
 * @author xiaozhu
 * @date 2021-01-17 19:37:57
 * @copyright 2021 xiaozhu
 */
@Data
@Table(name = "jx3_body_shape_info")
public class Jx3BodyShapeInfo {
    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "体型ID")
    @Id
    private Integer bodyShapeId;

    @ApiModelProperty(value = "体型名称")
    private String bodyShapeName;

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", bodyShapeId=").append(bodyShapeId);
        sb.append(", bodyShapeName=").append(bodyShapeName);
        sb.append("]");
        return sb.toString();
    }
}