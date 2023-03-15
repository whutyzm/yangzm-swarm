package com.yangzm.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.yangzm.api.CommonResult;
import com.yangzm.domain.UmsResource;
import com.yangzm.service.UmsResourceService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author yangzhengming
 * @description 〈〉
 * @create 2023/3/15 16:01
 * @since 1.0.0
 */
@Api(tags = "后台资源管理")
@Controller
@RequestMapping("/resource")
public class UmsResourceController {

    @Autowired
    private UmsResourceService umsResourceService;

    @ApiOperation("新增或编辑资源")
    @RequestMapping(value = "/saveOrEdit", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult saveOrEdit(@RequestBody UmsResource umsResource) {
        boolean result = umsResourceService.saveOrEdit(umsResource);
        if (result) {
            return CommonResult.success(result);
        } else {
            return CommonResult.failed();
        }
    }

    @ApiOperation("删除资源")
    @RequestMapping(value = "/delete/{id}",method = RequestMethod.POST)
    @ResponseBody
    public CommonResult delete(@PathVariable("id") Long id) {
        boolean result = umsResourceService.removeById(id);
        if (result) {
            return CommonResult.success(result);
        } else {
            return CommonResult.failed();
        }
    }

    @ApiOperation("资源列表")
    @RequestMapping(value = "/list",method = RequestMethod.GET)
    @ResponseBody
    public CommonResult<List<UmsResource>> list() {
        List<UmsResource> list = umsResourceService.list();
        return CommonResult.success(list);
    }

    @ApiOperation("分页条件获取资源")
    @RequestMapping(value = "/page",method = RequestMethod.POST)
    @ResponseBody
    public CommonResult<Page<UmsResource>> page(@RequestParam(required = false) Long categoryId,
                                                @RequestParam(required = false) String nameKeyword,
                                                @RequestParam(required = false) String urlKeyword,
                                                @RequestParam(value = "pageSize", defaultValue = "5") Integer pageSize,
                                                @RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum) {
        Page<UmsResource> list = umsResourceService.pageByKeyword(categoryId,nameKeyword,urlKeyword,pageNum,pageSize);
        return CommonResult.success(list);
    }
}
