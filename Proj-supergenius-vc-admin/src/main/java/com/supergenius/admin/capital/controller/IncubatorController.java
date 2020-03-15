package com.supergenius.admin.capital.controller;


import com.alibaba.fastjson.JSON;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.api.R;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.supergenius.admin.capital.model.VCIncubatorDO;
import com.supergenius.admin.capital.model.vo.VCEntrepreneurmemberDisplayVO;
import com.supergenius.admin.capital.model.vo.VCFiltrateIncubatorVO;
import com.supergenius.admin.capital.model.vo.VCFiltrateUserVO;
import com.supergenius.admin.capital.service.IVCIncubatorService;
import com.supergenius.admin.utils.ErrorCode;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import jdk.nashorn.internal.runtime.options.Option;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;

@Api(description = "孵化器")
@Slf4j
@RequestMapping("/incubator")
@RestController
public class IncubatorController {
    @Autowired
    IVCIncubatorService ivcIncubatorService;
    @ApiOperation("获取孵化器 信息列表")
    @GetMapping("/list/{pageNum}")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "pageNum", value = "页数", required = true, paramType = "path", dataType = "int"),
            @ApiImplicitParam(name = "filtrate", value = "过滤条件", paramType = "query", dataType = "String")
    })
    public R<IPage<VCIncubatorDO>> getAllDisplayList(@RequestParam(name = "filtrate", required = false) String filtrateStr, @PathVariable int pageNum) {
        log.info(filtrateStr + "--------------");
        VCFiltrateIncubatorVO filtrate = JSON.parseObject(filtrateStr, VCFiltrateIncubatorVO.class);
        IPage<VCIncubatorDO> displayList = ivcIncubatorService.getDisplayList(new Page(pageNum, 10), filtrate);
        if(displayList.getRecords().size()!=0){
            return R.ok(displayList).setCode(200);
        }

        return R.failed(new ErrorCode(401));
    }
    @ApiOperation("禁用孵化器")
    @ApiImplicitParam(name = "uids", value = "孵化器uid", dataType = "String", allowMultiple = true, paramType = "query")
    @PostMapping("/closeincubator")
    @Transactional
    public R<Boolean> closeIncubator(@RequestParam("uids") String[]  uids) {
        ivcIncubatorService.closeIncubator(Arrays.asList(uids));
        return R.ok(true).setCode(200);
    }
    @ApiOperation("启动孵化器")
    @ApiImplicitParam(name = "uids", value = "孵化器uid", dataType = "String", allowMultiple = true, paramType = "query")
    @PostMapping("/startincubator")
    @Transactional
    public R<Boolean> startIncubator(@RequestParam("uids") String[]  uids) {
        ivcIncubatorService.startIncubator(Arrays.asList(uids));
        return R.ok(true).setCode(200);
    }
    @ApiOperation("删除孵化器")
    @ApiImplicitParam(name = "uids", value = "孵化器uid", dataType = "String", allowMultiple = true, paramType = "query")
    @PostMapping("/deleteincubator")
    @Transactional
    public R<Boolean> deleteIncubator(@RequestParam("uids") String[]  uids) {
        ivcIncubatorService.deleteIncubator(Arrays.asList(uids));
        return R.ok(true).setCode(200);
    }
    @ApiOperation("查看孵化器")
    @ApiImplicitParam(name = "uid", value = "孵化器uid", dataType = "String", allowMultiple = false, paramType = "path")
    @GetMapping("/getone/{uid}")
    public R<VCIncubatorDO> getIncubatorByUid(@PathVariable String uid){
        VCIncubatorDO byUid = ivcIncubatorService.getByUid(uid);
        if(byUid==null){
            return R.failed(new ErrorCode(401));
        }
        return R.ok(byUid).setCode(200);
    }
}
