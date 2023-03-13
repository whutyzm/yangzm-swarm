package com.yangzm.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import lombok.Data;

/**
 * 后台角色资源关系表
 * @TableName ums_role_resource_relation
 */
@TableName(value ="ums_role_resource_relation")
@Data
public class UmsRoleResourceRelation implements Serializable {
    /**
     * 
     */
    @TableId(type = IdType.AUTO)
    private Long id;

    /**
     * 角色ID
     */
    private Long roleId;

    /**
     * 资源ID
     */
    private Long resourceId;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}