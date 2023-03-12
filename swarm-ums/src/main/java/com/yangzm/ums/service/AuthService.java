package com.yangzm.ums.service;

import com.yangzm.common.api.CommonResult;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

/**
 * description ()
 *
 * @author create by yangzm
 * @date 2023/3/12
 */
@FeignClient("swarm-auth")
public interface AuthService {
    @PostMapping(value = "/oauth/token")
    CommonResult getAccessToken(@RequestParam Map<String, String> parameters);
}
