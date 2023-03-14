package com.yangzm.mapper;

import com.yangzm.domain.UmsRole;
import com.yangzm.domain.UmsUserRoleRelation;
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
    /**
     * 根据查询角色列表
     * @param userId
     * @return
     */
    List<UmsRole> getRoleListByUserId(@Param("userId") Long userId);
}




