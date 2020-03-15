package com.supergenius.admin.capital.controller;

import com.alibaba.fastjson.JSON;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.api.R;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.supergenius.admin.capital.model.VCTrainactivityDO;
import com.supergenius.admin.capital.model.vo.*;
import com.supergenius.admin.capital.service.IVCSignupService;
import com.supergenius.admin.capital.service.IVCTrainactivityService;
import com.supergenius.admin.enums.EProjecttype;
import com.supergenius.admin.enums.EReview;
import com.supergenius.admin.utils.ErrorCode;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

@Slf4j
@RequestMapping("/trainactivity")
@Api(description="路演活动")
@RestController
public class TrainactivityController {
    @Autowired
    IVCTrainactivityService trainactivityService;
    @Autowired
    IVCSignupService signupService;
    @GetMapping("/list")
    public List<VCTrainactivityDO> getList(){
        return trainactivityService.getList();
    }
    @ApiOperation("获取路演活动")
    @GetMapping("/list/{pageNum}")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "pageNum", value = "页数", required = true, paramType = "path", dataType = "int"),
            @ApiImplicitParam(name = "filtrate", value = "过滤条件", paramType = "query", dataType = "String")
    })
    public R<IPage<VCTrainactivityDO>> getselectVCGuaranteeDisplayDO(@RequestParam(name = "filtrate", required = false) String filtrateStr, @PathVariable int pageNum) {
        VCFiltrateTrainactivityVO filtrate = JSON.parseObject(filtrateStr, VCFiltrateTrainactivityVO.class);
        IPage<VCTrainactivityDO> list = trainactivityService.getDisplayList(new Page(pageNum, 10), filtrate);//= trainactivityService.getDisplayList(new Page(pageNum, 10), filtrate);
        if(list.getRecords().size()==0){
            return R.failed(new ErrorCode(401));
        }
        return R.ok(list).setCode(200);
    }

    @ApiOperation("删除路演活动")
    @PostMapping("/delete")
    public R<Boolean> deleteTrainactivity(String...uid){
        Integer result = trainactivityService.deleteByUid(Arrays.asList(uid));
        return R.ok(true).setCode(200);
    }
    @ApiOperation("获取审核列表")
    @GetMapping("/getsignup/{pid}")
    public R<VCSignupInfoVO> getSignup(@PathVariable String pid){
        VCSignupInfoVO singuupByUid = signupService.getSinguupByUid(pid, new Page(1, 10));
        if(singuupByUid==null){
            return R.failed(new ErrorCode(400));
        }
        return R.ok(singuupByUid).setCode(200);
    }
    @ApiOperation("翻页")
    @GetMapping("/getsignup/{pid}/{pageNum}")
    public R<IPage<VCSignupDisplayVO>> getPage(@PathVariable String pid,@PathVariable Integer pageNum,VCFiltrateSignupVO filtrate){
        IPage<VCSignupDisplayVO> byPage = signupService.getByPage(pid, new Page(pageNum, 10), filtrate);
        if(byPage.getRecords().size()==0)
            return R.failed(new ErrorCode(400));
        return R.ok(byPage).setCode(200);
    }
    @ApiOperation("操作")
    @PutMapping("/operating")
    public R<Boolean> operatingUser(EReview eReview, String...uids){
        Integer aNull = signupService.operatingUids(Arrays.asList(uids), "null", eReview);
        return R.ok(true).setCode(200);
    }
    @ApiOperation("获取路演活动具体信息")
    @PostMapping("/get/{uid}")
    public R<VCTrainactivityDO> getById(@PathVariable String uid){
        VCTrainactivityDO result = trainactivityService.getByUid(uid);
        if(result==null)
            return R.failed(new ErrorCode(400));
        return R.ok(result).setCode(200);
    }

}
