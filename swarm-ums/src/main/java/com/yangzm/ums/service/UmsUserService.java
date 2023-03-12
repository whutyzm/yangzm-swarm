package com.yangzm.ums.service;

import com.yangzm.common.domain.UserDTO;
import com.yangzm.ums.domain.UmsUser;
import com.baomidou.mybatisplus.extension.service.IService;

/**
* @author yangzm-msi
* @description 针对表【ums_user(后台用户表)】的数据库操作Service
* @createDate 2023-03-12 15:03:51
*/
public interface UmsUserService extends IService<UmsUser> {

    UserDTO loadUserByUsername(String username);
}
