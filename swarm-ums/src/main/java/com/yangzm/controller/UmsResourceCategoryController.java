package com.yangzm.controller;

import com.yangzm.api.CommonResult;
import com.yangzm.domain.UmsResourceCategory;
import com.yangzm.service.UmsResourceCategoryService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author yangzhengming
 * @description 〈〉
 * @create 2023/3/15 16:04
 * @since 1.0.0
 */
@Api(tags = "资源分类管理")
@Controller
@RequestMapping("/resourceCategory")
public class UmsResourceCategoryController {

    @Autowired
    private UmsResourceCategoryService umsResourceCategoryService;

    @ApiOperation("新增或编辑资源分类")
    @RequestMapping(value = "/saveOrEdit", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult saveOrEdit(@RequestBody UmsResourceCategory umsResourceCategory) {
        boolean result = umsResourceCategoryService.saveOrEdit(umsResourceCategory);
        if (result) {
            return CommonResult.success(result);
        } else {
            return CommonResult.failed();
        }
    }

    @ApiOperation("删除资源分类")
    @RequestMapping(value = "/delete/{id}",method = RequestMethod.POST)
    @ResponseBody
    public CommonResult delete(@PathVariable("id") Long id) {
        boolean result = umsResourceCategoryService.removeById(id);
        if (result) {
            return CommonResult.success(result);
        } else {
            return CommonResult.failed();
        }
    }

    @ApiOperation("资源分类列表")
    @RequestMapping(value = "/list",method = RequestMethod.GET)
    @ResponseBody
    public CommonResult<List<UmsResourceCategory>> list() {
        List<UmsResourceCategory> list = umsResourceCategoryService.list();
        return CommonResult.success(list);
    }
}
