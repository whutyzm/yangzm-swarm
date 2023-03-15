package com.yangzm.service.impl;

import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.yangzm.domain.UmsResource;
import com.yangzm.mapper.UmsResourceMapper;
import com.yangzm.service.UmsResourceService;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
* @author yangzm-msi
* @description 针对表【ums_resource(后台资源表)】的数据库操作Service实现
* @createDate 2023-03-12 15:04:58
*/
@Service
public class UmsResourceServiceImpl extends ServiceImpl<UmsResourceMapper, UmsResource>
    implements UmsResourceService {

    @Override
    public boolean saveOrEdit(UmsResource umsResource) {
        boolean result = false;
        if (umsResource.getId() == null) {
            //新增
            umsResource.setCreateTime(new Date());
            result = this.save(umsResource);
        } else {
            //更新
            result = this.updateById(umsResource);
        }
        return result;
    }

    @Override
    public Page<UmsResource> pageByKeyword(Long categoryId, String nameKeyword, String urlKeyword, Integer pageNum, Integer pageSize) {
        Page<UmsResource> page = new Page<>(pageNum, pageSize);

        if (categoryId == null && StrUtil.isEmpty(urlKeyword) && StrUtil.isEmpty(nameKeyword)) {
            return this.page(page);
        } else {
            QueryWrapper<UmsResource> queryWrapper = new QueryWrapper<>();
            LambdaQueryWrapper<UmsResource> lambda = queryWrapper.lambda();
            if (categoryId != null) {
                lambda.eq(UmsResource::getCategoryId, categoryId);
            }
            if (StrUtil.isNotEmpty(urlKeyword)) {
                lambda.like(UmsResource::getUrl, urlKeyword);
            }
            if (StrUtil.isNotEmpty(nameKeyword)) {
                lambda.like(UmsResource::getName, nameKeyword);
            }
            return this.page(page, queryWrapper);
        }
    }
}




