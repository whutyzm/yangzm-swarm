package com.yangzm.auth.service;

import com.yangzm.common.domain.UserDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * description ()
 *
 * @author create by yangzm
 * @date 2023/3/11
 */
@FeignClient("swarm-ums")
public interface UmsUserService {
    @GetMapping("/ums/loadByUsername")
    UserDTO loadUserByUsername(@RequestParam String username);
}
