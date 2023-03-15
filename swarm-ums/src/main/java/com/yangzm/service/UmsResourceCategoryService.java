package com.yangzm.service;

import com.yangzm.domain.UmsResourceCategory;
import com.baomidou.mybatisplus.extension.service.IService;

/**
* @author yangzm-msi
* @description 针对表【ums_resource_category(资源分类表)】的数据库操作Service
* @createDate 2023-03-12 15:05:02
*/
public interface UmsResourceCategoryService extends IService<UmsResourceCategory> {

    /**
     * 新增或编辑资源分类
     * @param umsResourceCategory
     * @return
     */
    boolean saveOrEdit(UmsResourceCategory umsResourceCategory);
}
