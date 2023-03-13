package com.yangzm.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import lombok.Data;

/**
 * 后台用户和角色关系表
 * @TableName ums_user_role_relation
 */
@TableName(value ="ums_user_role_relation")
@Data
public class UmsUserRoleRelation implements Serializable {
    /**
     * 
     */
    @TableId(type = IdType.AUTO)
    private Long id;

    /**
     * 
     */
    private Long userId;

    /**
     * 
     */
    private Long roleId;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}