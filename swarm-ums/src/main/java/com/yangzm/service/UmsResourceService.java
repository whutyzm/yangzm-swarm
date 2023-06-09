package com.yangzm.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.yangzm.domain.UmsResource;
import com.baomidou.mybatisplus.extension.service.IService;

/**
* @author yangzm-msi
* @description 针对表【ums_resource(后台资源表)】的数据库操作Service
* @createDate 2023-03-12 15:04:58
*/
public interface UmsResourceService extends IService<UmsResource> {

    boolean saveOrEdit(UmsResource umsResource);

    Page<UmsResource> pageByKeyword(Long categoryId, String nameKeyword, String urlKeyword, Integer pageNum, Integer pageSize);
}
