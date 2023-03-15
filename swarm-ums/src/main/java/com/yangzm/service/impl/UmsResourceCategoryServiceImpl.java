package com.yangzm.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.yangzm.domain.UmsResourceCategory;
import com.yangzm.mapper.UmsResourceCategoryMapper;
import com.yangzm.service.UmsResourceCategoryService;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
* @author yangzm-msi
* @description 针对表【ums_resource_category(资源分类表)】的数据库操作Service实现
* @createDate 2023-03-12 15:05:02
*/
@Service
public class UmsResourceCategoryServiceImpl extends ServiceImpl<UmsResourceCategoryMapper, UmsResourceCategory>
    implements UmsResourceCategoryService {
    @Override
    public boolean saveOrEdit(UmsResourceCategory umsResourceCategory) {
        boolean result = false;
        if (umsResourceCategory.getId() == null) {
            //新增
            umsResourceCategory.setCreateTime(new Date());
            result = this.save(umsResourceCategory);
        } else {
            //更新
            result = this.updateById(umsResourceCategory);
        }
        return result;
    }
}




