package com.yangzm.ums.mapper;

import com.yangzm.ums.domain.UmsRole;
import com.yangzm.ums.domain.UmsUserRoleRelation;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
* @author yangzm-msi
* @description 针对表【ums_user_role_relation(后台用户和角色关系表)】的数据库操作Mapper
* @createDate 2023-03-12 15:05:23
* @Entity com.yangzm.ums.domain.UmsUserRoleRelation
*/
public interface UmsUserRoleRelationMapper extends BaseMapper<UmsUserRoleRelation> {
    List<UmsRole> getRoleListByUserId(@Param("userId") Long userId);
}




