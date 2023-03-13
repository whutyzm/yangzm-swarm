package com.yangzm.auth.service;

import com.yangzm.domain.UserDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * description ()
 *
 * @author create by yangzm
 * @date 2023/3/11
 */
@FeignClient("swarm-portal")
public interface UmsMemberService {
    @GetMapping("/sso/loadByUsername")
    UserDTO loadUserByUsername(@RequestParam String username);
}
