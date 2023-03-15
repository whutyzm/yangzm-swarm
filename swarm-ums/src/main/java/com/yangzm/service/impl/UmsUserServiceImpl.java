package com.yangzm.service.impl;

import cn.hutool.core.collection.CollUtil;
import cn.hutool.core.collection.CollectionUtil;
import cn.hutool.core.util.StrUtil;
import cn.hutool.crypto.digest.BCrypt;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.yangzm.api.CommonResult;
import com.yangzm.api.ResultCode;
import com.yangzm.constants.AuthConstant;
import com.yangzm.domain.UserDTO;
import com.yangzm.exception.CommonException;
import com.yangzm.domain.UmsRole;
import com.yangzm.domain.UmsUser;
import com.yangzm.domain.UmsUserLoginLog;
import com.yangzm.mapper.UmsUserMapper;
import com.yangzm.mapper.UmsUserRoleRelationMapper;
import com.yangzm.service.UmsUserLoginLogService;
import com.yangzm.service.UmsUserService;
import com.yangzm.domain.constants.UmsUserConstant;
import com.yangzm.domain.dto.UmsUserRegisterDTO;
import com.yangzm.service.AuthService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

/**
* @author yangzm-msi
* @description 针对表【ums_user(后台用户表)】的数据库操作Service实现
* @createDate 2023-03-12 15:03:51
*/
@Service
public class UmsUserServiceImpl extends ServiceImpl<UmsUserMapper, UmsUser>
    implements UmsUserService {

    @Autowired
    private UmsUserRoleRelationMapper umsUserRoleRelationService;

    @Autowired
    private UmsUserLoginLogService umsUserLoginLogService;

    @Autowired
    private AuthService authService;

    @Override
    public UmsUser register(UmsUserRegisterDTO umsUserRegisterDTO) {

        //查询是否重名
        QueryWrapper<UmsUser> queryWrapper = new QueryWrapper<>();
        queryWrapper.lambda().eq(UmsUser::getUsername, umsUserRegisterDTO.getUsername());
        List<UmsUser> list = this.list(queryWrapper);
        if (!CollectionUtil.isEmpty(list)) {
            throw new CommonException("用户名已存在！");
        }

        UmsUser user = new UmsUser();
        BeanUtils.copyProperties(umsUserRegisterDTO, user);
        user.setCreateTime(new Date());
        user.setStatus(UmsUserConstant.STATUS_ENABLE);

        String hashpw = BCrypt.hashpw(user.getPassword());
        user.setPassword(hashpw);
        baseMapper.insert(user);
        return user;
    }

    @Override
    public CommonResult login(String username, String password) {
        if (StrUtil.isEmpty(username) || StrUtil.isEmpty(password)) {
            throw new CommonException("账号密码不能为空！");
        }

        HashMap<String, String> params = new HashMap<>();
        params.put("client_id", AuthConstant.UMS_CLIENT_ID);
        params.put("client_secret","123456");
        params.put("grant_type","password");
        params.put("username",username);
        params.put("password",password);

        CommonResult restResult = authService.getAccessToken(params);
        if(ResultCode.SUCCESS.getCode()==restResult.getCode()&&restResult.getData()!=null){
            insertLoginLog(username);
        }
        return restResult;
    }

    @Override
    public Page<UmsUser> pageByKeyword(String keyword, Integer pageSize, Integer pageNum) {
        Page<UmsUser> page = new Page<>(pageNum, pageSize);

        if (StrUtil.isNotEmpty(keyword)) {
            QueryWrapper<UmsUser> queryWrapper = new QueryWrapper<>();
            queryWrapper.lambda()
                    .like(UmsUser::getUsername, keyword)
                    .or()
                    .like(UmsUser::getNickName, keyword);
            return this.page(page, queryWrapper);
        }
        return this.page(page);
    }

    private void insertLoginLog(String username) {
        //
        QueryWrapper<UmsUser> queryWrapper = new QueryWrapper<>();
        queryWrapper.lambda().eq(UmsUser::getUsername, username);
        UmsUser user = this.getOne(queryWrapper);
        if (user != null) {
            UmsUserLoginLog userLoginLog = new UmsUserLoginLog();
            userLoginLog.setUserId(user.getId());
            userLoginLog.setCreateTime(new Date());
            ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
            HttpServletRequest request = attributes.getRequest();
            userLoginLog.setIp(request.getRemoteAddr());
            umsUserLoginLogService.save(userLoginLog);
        }
    }

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




