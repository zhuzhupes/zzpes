package com.xiaozhu.zzpes.entity;

import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;

public class Jx3ServerInfo implements Serializable {
    @ApiModelProperty(value = "服务器ID")
    private String serverId;

    @ApiModelProperty(value = "服务器名称")
    private String serverName;

    @ApiModelProperty(value = "服务器别称")
    private String serverAlias;

    private static final long serialVersionUID = 1L;

    public String getServerId() {
        return serverId;
    }

    public void setServerId(String serverId) {
        this.serverId = serverId;
    }

    public String getServerName() {
        return serverName;
    }

    public void setServerName(String serverName) {
        this.serverName = serverName;
    }

    public String getServerAlias() {
        return serverAlias;
    }

    public void setServerAlias(String serverAlias) {
        this.serverAlias = serverAlias;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", serverId=").append(serverId);
        sb.append(", serverName=").append(serverName);
        sb.append(", serverAlias=").append(serverAlias);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}