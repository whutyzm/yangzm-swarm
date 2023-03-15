package com.yangzm.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.yangzm.api.CommonResult;
import com.yangzm.domain.UmsResource;
import com.yangzm.domain.UmsRole;
import com.yangzm.service.UmsRoleService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author yangzhengming
 * @description 〈〉
 * @create 2023/3/15 15:15
 * @since 1.0.0
 */
@Api(tags = "角色管理接口")
@Controller
@RequestMapping("/role")
public class UmsRoleController {

    @Autowired
    private UmsRoleService umsRoleService;

    @ApiOperation("添加或修改角色")
    @RequestMapping(value = "/saveOrEdit",method = RequestMethod.POST)
    @ResponseBody
    public CommonResult saveOrEdit(@RequestBody UmsRole umsRole) {
        boolean result = umsRoleService.saveOrEdit(umsRole);
        if (result) {
            return CommonResult.success(result);
        } else {
            return CommonResult.failed();
        }
    }

    @ApiOperation("删除角色")
    @RequestMapping(value = "/delete/{id}",method = RequestMethod.POST)
    @ResponseBody
    public CommonResult delete(@PathVariable("id") Long id) {
        boolean result = umsRoleService.removeById(id);
        if (result) {
            return CommonResult.success(result);
        } else {
            return CommonResult.failed();
        }
    }

    @ApiOperation("分页条件查询角色")
    @RequestMapping(value = "/page",method = RequestMethod.POST)
    @ResponseBody
    public CommonResult<Page<UmsRole>> page(@RequestParam(value = "keyword", required = false) String keyword,
                                            @RequestParam(value = "pageSize", defaultValue = "5") Integer pageSize,
                                            @RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum) {
        Page<UmsRole> list = umsRoleService.pageByKeyword(keyword, pageSize, pageNum);
        return CommonResult.success(list);
    }

    @ApiOperation("角色列表")
    @RequestMapping(value = "/list",method = RequestMethod.GET)
    @ResponseBody
    public CommonResult<List<UmsRole>> list() {
        List<UmsRole> list = umsRoleService.list();
        return CommonResult.success(list);
    }
}
