package com.supergenius.admin.capital.controller;

import com.alibaba.fastjson.JSON;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.api.R;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.sun.org.apache.xpath.internal.operations.Bool;
import com.supergenius.admin.capital.model.VCSettledDO;
import com.supergenius.admin.capital.model.vo.*;
import com.supergenius.admin.capital.service.IVCSettledService;
import com.supergenius.admin.utils.ErrorCode;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;

@Slf4j
@RequestMapping("/settled")
@Api(description = "入驻企业 ")
@RestController
public class SettledController {
    @Autowired
    IVCSettledService settledService;

    @ApiOperation("获取入驻企业展示列表")
    @GetMapping("/list/{pageNum}")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "pageNum", value = "页数", required = true, paramType = "path", dataType = "int"),
            @ApiImplicitParam(name = "filtrate", value = "过滤条件", paramType = "query", dataType = "String")
    })
    public R<IPage<VCSettledDisplayVO>> getSettledDisplay(@RequestParam(name = "filtrate", required = false) String filtrateStr, @PathVariable int pageNum) {
        log.info(filtrateStr + "--------------");
        VCFiltrateSettledVO vcFiltrateUserVO = JSON.parseObject(filtrateStr, VCFiltrateSettledVO.class);
        log.info(vcFiltrateUserVO + "--------------");
        IPage<VCSettledDisplayVO> displayVOIPage = settledService.getSettledDisplay(new Page(pageNum, 10), vcFiltrateUserVO);
        if (displayVOIPage.getRecords().size() > 0) {
            return R.ok(displayVOIPage).setCode(200);
        }
        return R.failed(new ErrorCode(401));
    }

    @ApiOperation("查看入驻企业信息")
    @ApiImplicitParam(name = "uid", value = "用户uid", dataType = "String", paramType = "path")
    @GetMapping("/{uid}")
    public R<VCSettledInfoVO> getInfoById(@PathVariable String uid) {
        VCSettledInfoVO info = settledService.getSettledById(uid);
        if (info == null) {
            return R.failed(new ErrorCode(401));
        }
        return R.ok(info).setCode(200);
    }

    @Transactional
    @ApiOperation("修改入驻企业信息")
    @PostMapping("/update")
    @ApiImplicitParam(name = "settledDO", value = "信息", dataType = "VCSettledDO", paramType = "form")
    public R<Boolean> update(VCSettledDO settledDO) {
        try {
            settledService.updateSettled(settledDO);
            return R.ok(true).setCode(200);

        } catch (Exception e) {
            return R.failed(new ErrorCode(401));

        }

    }

    @Transactional
    @ApiOperation("修改入驻企业信息")
    @PostMapping("/exit")
    @ApiImplicitParam(name = "uids", value = "uids", dataType = "String", paramType = "query",allowMultiple = true)
    public R<Boolean> exit(String... uids) {
        try {
            settledService.exit(Arrays.asList(uids));
            return R.ok(true).setCode(200);

        } catch (Exception e) {
            return R.failed(new ErrorCode(401));

        }

    }


}
