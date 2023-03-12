package com.yangzm.ums.service.impl;

import cn.hutool.core.collection.CollUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.yangzm.common.domain.UserDTO;
import com.yangzm.ums.domain.UmsRole;
import com.yangzm.ums.domain.UmsUser;
import com.yangzm.ums.mapper.UmsUserRoleRelationMapper;
import com.yangzm.ums.service.UmsUserRoleRelationService;
import com.yangzm.ums.service.UmsUserService;
import com.yangzm.ums.mapper.UmsUserMapper;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
* @author yangzm-msi
* @description 针对表【ums_user(后台用户表)】的数据库操作Service实现
* @createDate 2023-03-12 15:03:51
*/
@Service
public class UmsUserServiceImpl extends ServiceImpl<UmsUserMapper, UmsUser>
    implements UmsUserService{

    @Autowired
    private UmsUserRoleRelationMapper umsUserRoleRelationService;

    @Override
    public UserDTO loadUserByUsername(String username) {
        //获取用户信息
        QueryWrapper<UmsUser> queryWrapper = new QueryWrapper<>();
        queryWrapper.lambda().eq(UmsUser::getUsername, username);
        UmsUser user = this.getOne(queryWrapper);
        //
        if (user != null) {
            List<UmsRole> roleList =getRoleListByUserId(user.getId());
            UserDTO userDTO = new UserDTO();
            BeanUtils.copyProperties(user, userDTO);

            if(CollUtil.isNotEmpty(roleList)){
                List<String> roleStrList = roleList.stream().map(item -> item.getId() + "_" + item.getName()).collect(Collectors.toList());
                userDTO.setRoles(roleStrList);

                return userDTO;
            }
        }
        return null;
    }

    /**
     * 根据userId获取角色列表
     * @param userId
     * @return
     */
    private List<UmsRole> getRoleListByUserId(Long userId) {
        return umsUserRoleRelationService.getRoleListByUserId(userId);
    }
}




