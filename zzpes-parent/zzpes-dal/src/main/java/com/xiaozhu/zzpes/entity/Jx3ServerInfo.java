package com.xiaozhu.zzpes.entity;

import io.swagger.annotations.ApiModelProperty;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Data;

/**
 * @description jx3_server_info 实体对象
 * @version 1.0.0
 * @tableName jx3_server_info
 * @author xiaozhu
 * @date 2021-01-17 19:37:57
 * @copyright 2021 xiaozhu
 */
@Data
@Table(name = "jx3_server_info")
public class Jx3ServerInfo {
    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "服务器ID")
    @Id
    private String serverId;

    @ApiModelProperty(value = "服务器名称")
    private String serverName;

    @ApiModelProperty(value = "服务器别称")
    private String serverAlias;

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", serverId=").append(serverId);
        sb.append(", serverName=").append(serverName);
        sb.append(", serverAlias=").append(serverAlias);
        sb.append("]");
        return sb.toString();
    }
}