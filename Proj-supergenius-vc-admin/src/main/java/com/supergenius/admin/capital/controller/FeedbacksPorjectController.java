package com.supergenius.admin.capital.controller;

import com.alibaba.fastjson.JSON;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.api.R;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.supergenius.admin.capital.model.vo.*;
import com.supergenius.admin.capital.service.IVCFeedbacksService;
import com.supergenius.admin.enums.ELabelType;
import com.supergenius.admin.utils.ErrorCode;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@Api(description = "举报项目")
@Slf4j
@RequestMapping("/feedbackprojectcontroller")
@RestController
public class FeedbacksPorjectController {
    @Autowired
    IVCFeedbacksService feedbacksService;
    @ApiOperation("获取举报项目列表")
    @GetMapping("/list/{pageNum}")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "pageNum", value = "页数", required = true, paramType = "path", dataType = "int"),
            @ApiImplicitParam(name = "filtrate", value = "过滤条件", paramType = "query", dataType = "String")
    })
    public R<IPage<VCFeedbackProjectDisplayVO>> getselectVCGuaranteeDisplayDO(@RequestParam(name = "filtrate", required = false) String filtrateStr, @PathVariable int pageNum) {
        log.info(filtrateStr + "--------------");
        VCFiltrateFeedbackProjectVO vcFiltrateVO = JSON.parseObject(filtrateStr, VCFiltrateFeedbackProjectVO.class);
        log.info(vcFiltrateVO + "--------------");
        IPage<VCFeedbackProjectDisplayVO> pagePerson = feedbacksService.getPageProject(new Page(pageNum, 10), vcFiltrateVO, ELabelType.reportproject);
        if (pagePerson.getRecords().size() > 0) {
            return R.ok(pagePerson).setCode(200);
        }
        return R.failed(new ErrorCode(401));
    }
    @ApiOperation("获取举报项目详请")
    @GetMapping("/{uid}")
    @ApiImplicitParam(name = "uid", value = "uid", paramType = "path", dataType = "String")
    public R<VCFeedbackProjectInfoVO> getMemberOrderByOid(@PathVariable("uid") String uid) {
        VCFeedbackProjectInfoVO one = feedbacksService.getOneProject(uid);
        if (one!=null)
            return R.failed(new ErrorCode(400));
        return R.ok(one).setCode(200);
    }
}
