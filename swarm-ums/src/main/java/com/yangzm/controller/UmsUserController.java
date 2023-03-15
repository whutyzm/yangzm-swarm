package com.yangzm.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.yangzm.api.CommonResult;
import com.yangzm.domain.UserDTO;
import com.yangzm.domain.UmsUser;
import com.yangzm.domain.dto.UmsUserLoginDTO;
import com.yangzm.domain.dto.UmsUserRegisterDTO;
import com.yangzm.service.UmsUserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

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

    @ApiOperation(value = "用户注册")
    @RequestMapping(value = "/register", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult<UmsUser> register(@Validated @RequestBody UmsUserRegisterDTO umsUserRegisterDTO) {
        UmsUser umsUser = umsUserService.register(umsUserRegisterDTO);
        return CommonResult.success(umsUser);
    }

    @ApiOperation(value = "用户登录")
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult login(@Validated @RequestBody UmsUserLoginDTO umsUserLoginDTO) {
        return umsUserService.login(umsUserLoginDTO.getUsername(),umsUserLoginDTO.getPassword());
    }

    @ApiOperation(value = "分页条件查询用户列表")
    @RequestMapping(value = "/page", method=RequestMethod.POST)
    @ResponseBody
    public CommonResult<Page<UmsUser>> page(@RequestParam(value = "keyword", required = false) String keyword,
                                            @RequestParam(value = "pageSize", defaultValue = "5") Integer pageSize,
                                            @RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum) {
        Page<UmsUser> list = umsUserService.pageByKeyword(keyword, pageSize, pageNum);
        return CommonResult.success(list);
    }

    @ApiOperation(value = "用户登出")
    @RequestMapping(value = "/logout", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult logout() {
        return CommonResult.success(null);
    }

    @ApiOperation("根据用户名获取通用用户信息")
    @RequestMapping(value = "/loadByUsername", method = RequestMethod.GET)
    @ResponseBody
    public UserDTO loadUserByUsername(@RequestParam String username) {
        UserDTO userDTO = umsUserService.loadUserByUsername(username);
        return userDTO;
    }
}
