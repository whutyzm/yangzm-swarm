package com.yangzm.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.yangzm.domain.UmsRole;
import com.baomidou.mybatisplus.extension.service.IService;

/**
* @author yangzm-msi
* @description 针对表【ums_role(后台用户角色表)】的数据库操作Service
* @createDate 2023-03-12 15:05:06
*/
public interface UmsRoleService extends IService<UmsRole> {

    /**
     * 新增或修改角色
     * @param umsRole
     * @return
     */
    boolean saveOrEdit(UmsRole umsRole);

    /**
     * 分页获取角色，keyword为name字段筛选条件，非必填
     * @param keyword
     * @param pageSize
     * @param pageNum
     * @return
     */
    Page<UmsRole> pageByKeyword(String keyword, Integer pageSize, Integer pageNum);
}
