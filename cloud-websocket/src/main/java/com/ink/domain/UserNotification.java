package com.ink.domain;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@ApiModel(value = "com-ink-domain-UserNotification")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserNotification implements Serializable {
    private static final long serialVersionUID = 1L;
    @ApiModelProperty(value = "")
    private Long id;
    /**
     * 用户名
     */
    @ApiModelProperty(value = "用户名")
    private String username;
    /**
     * 关联通知id
     */
    @ApiModelProperty(value = "关联通知id")
    private Long notificationId;
    /**
     * 是否已读
     */
    @ApiModelProperty(value = "是否已读")
    private Boolean status;
}
