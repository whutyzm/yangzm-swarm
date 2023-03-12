package com.yangzm.common.domain;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * description (登录用户信息)
 *
 * @author create by yangzm
 * @date 2023/3/11
 */
@Data
@EqualsAndHashCode(callSuper = false)
@NoArgsConstructor
public class UserDTO {
   private Long id;
   private String username;
   private String password;
   private Integer status;
   private String clientId;
   private List<String> roles;

}
