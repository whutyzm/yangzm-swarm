package com.yangzm.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.yangzm.api.CommonResult;
import com.yangzm.domain.UserDTO;
import com.yangzm.domain.UmsUser;
import com.baomidou.mybatisplus.extension.service.IService;
import com.yangzm.domain.dto.UmsUserRegisterDTO;

/**
* @author yangzm-msi
* @description 针对表【ums_user(后台用户表)】的数据库操作Service
* @createDate 2023-03-12 15:03:51
*/
public interface UmsUserService extends IService<UmsUser> {

    UserDTO loadUserByUsername(String username);

    UmsUser register(UmsUserRegisterDTO umsUserRegisterDTO);

    CommonResult login(String username, String password);

    Page<UmsUser> pageByKeyword(String keyword, Integer pageSize, Integer pageNum);
}
