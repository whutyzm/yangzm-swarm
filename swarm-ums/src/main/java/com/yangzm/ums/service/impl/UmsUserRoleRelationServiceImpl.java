package com.yangzm.ums.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.yangzm.ums.domain.UmsRole;
import com.yangzm.ums.domain.UmsUserRoleRelation;
import com.yangzm.ums.service.UmsUserRoleRelationService;
import com.yangzm.ums.mapper.UmsUserRoleRelationMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
* @author yangzm-msi
* @description 针对表【ums_user_role_relation(后台用户和角色关系表)】的数据库操作Service实现
* @createDate 2023-03-12 15:05:23
*/
@Service
public class UmsUserRoleRelationServiceImpl extends ServiceImpl<UmsUserRoleRelationMapper, UmsUserRoleRelation>
    implements UmsUserRoleRelationService{

    @Autowired
    private UmsUserRoleRelationMapper umsUserRoleRelationMapper;

    @Override
    public List<UmsRole> getRoleListByUserId(Long userId) {
        List<UmsRole> list = umsUserRoleRelationMapper.getRoleListByUserId(userId);
        return list;
    }
}




