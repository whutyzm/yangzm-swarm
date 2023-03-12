package com.yangzm.ums.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.yangzm.ums.domain.UmsUserLoginLog;
import com.yangzm.ums.service.UmsUserLoginLogService;
import com.yangzm.ums.mapper.UmsUserLoginLogMapper;
import org.springframework.stereotype.Service;

/**
* @author yangzm-msi
* @description 针对表【ums_user_login_log(后台用户登录日志表)】的数据库操作Service实现
* @createDate 2023-03-12 15:05:19
*/
@Service
public class UmsUserLoginLogServiceImpl extends ServiceImpl<UmsUserLoginLogMapper, UmsUserLoginLog>
    implements UmsUserLoginLogService{

}




