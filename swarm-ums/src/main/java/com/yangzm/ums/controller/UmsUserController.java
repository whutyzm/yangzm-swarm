package com.yangzm.ums.controller;

import com.yangzm.common.domain.UserDTO;
import com.yangzm.ums.service.UmsUserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * description (用户管理)
 *
 * @author create by yangzm
 * @date 2023/3/12
 */
@Controller
@Api(tags = "用户管理接口")
@RequestMapping("/user")
public class UmsUserController {

    @Autowired
    private UmsUserService umsUserService;

    @ApiOperation("根据用户名获取通用用户信息")
    @RequestMapping(value = "/loadByUsername", method = RequestMethod.GET)
    @ResponseBody
    public UserDTO loadUserByUsername(@RequestParam String username) {
        UserDTO userDTO = umsUserService.loadUserByUsername(username);
        return userDTO;
    }
}
