package com.yangzm.domain.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotEmpty;

/**
 * @author yangzhengming
 * @description 〈〉
 * @create 2023/3/13 14:50
 * @since 1.0.0
 */
@Data
public class UmsUserLoginDTO {
    @NotEmpty
    @ApiModelProperty(value = "用户名", required = true)
    private String username;
    @NotEmpty
    @ApiModelProperty(value = "密码", required = true)
    private String password;
}
