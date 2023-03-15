package com.yangzm.service.impl;

import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.yangzm.domain.UmsRole;
import com.yangzm.mapper.UmsRoleMapper;
import com.yangzm.service.UmsRoleService;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
* @author yangzm-msi
* @description 针对表【ums_role(后台用户角色表)】的数据库操作Service实现
* @createDate 2023-03-12 15:05:06
*/
@Service
public class UmsRoleServiceImpl extends ServiceImpl<UmsRoleMapper, UmsRole>
    implements UmsRoleService{

    @Override
    public boolean saveOrEdit(UmsRole umsRole) {
        boolean result = false;
        if (umsRole.getId() == null) {
            //新增
            umsRole.setCreateTime(new Date());
            umsRole.setUserCount(0);
            umsRole.setSort(0);
            result = this.save(umsRole);
        } else {
            //更新
            result = this.updateById(umsRole);
        }
        return result;
    }

    @Override
    public Page<UmsRole> pageByKeyword(String keyword, Integer pageSize, Integer pageNum) {
        Page<UmsRole> page = new Page<>(pageNum, pageSize);

        if (StrUtil.isNotBlank(keyword)) {
            QueryWrapper<UmsRole> queryWrapper = new QueryWrapper<>();
            queryWrapper.lambda().like(UmsRole::getName, keyword);

            return this.page(page, queryWrapper);
        }
        return this.page(page);
    }
}




