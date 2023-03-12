package com.yangzm.ums.service;

import com.yangzm.ums.domain.UmsRole;
import com.yangzm.ums.domain.UmsUserRoleRelation;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
* @author yangzm-msi
* @description 针对表【ums_user_role_relation(后台用户和角色关系表)】的数据库操作Service
* @createDate 2023-03-12 15:05:23
*/
public interface UmsUserRoleRelationService extends IService<UmsUserRoleRelation> {

    List<UmsRole> getRoleListByUserId(Long userId);
}
