package com.supergenius.admin.capital.controller;

import com.alibaba.fastjson.JSON;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.api.R;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.supergenius.admin.capital.model.VCTrainactivityDO;
import com.supergenius.admin.capital.model.vo.VCEntrepreneurmemberDisplayVO;
import com.supergenius.admin.capital.model.vo.VCFiltrateCorporatetrainingVO;
import com.supergenius.admin.capital.model.vo.VCFiltrateUserVO;
import com.supergenius.admin.capital.service.IVCTrainactivityService;
import com.supergenius.admin.utils.ErrorCode;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;

@Api(description = "培训课程")
@Slf4j
@RequestMapping("/corporatetraining")
@RestController
public class CorporateTrainingController {
    @Autowired
    IVCTrainactivityService trainactivityService;

    @ApiOperation("获取课程培训列表")
    @GetMapping("/list/{pageNum}")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "pageNum", value = "页数", required = true, paramType = "path", dataType = "int"),
            @ApiImplicitParam(name = "filtrate", value = "过滤条件", paramType = "query", dataType = "String")
    })
    public R<IPage<VCTrainactivityDO>> getselectVEntrepreneurMemberDisplayDO(@RequestParam(name = "filtrate", required = false) String filtrateStr, @PathVariable int pageNum) {
        log.info(filtrateStr + "--------------");
        VCFiltrateCorporatetrainingVO filtrate = JSON.parseObject(filtrateStr, VCFiltrateCorporatetrainingVO.class);
        //  log.info(vcFiltrateUserVO + "--------------");
        IPage<VCTrainactivityDO> page = trainactivityService.getCorporatetraining(new Page(pageNum, 10), filtrate);
        if (page.getRecords().size() == 0) {
            return R.failed(new ErrorCode(401));
        }
        return R.ok(page).setCode(200);
    }

    @ApiOperation("删除培训课程活动")
    @PostMapping("/delete")
    public R<Boolean> deleteTrainactivity(String... uid) {
        Integer result = trainactivityService.deleteByUid(Arrays.asList(uid));
        return R.ok(true).setCode(200);
    }
    @ApiOperation("获取课程具体信息")
    @PostMapping("/get/{uid}")
    public R<VCTrainactivityDO> getById(@PathVariable String uid){
        VCTrainactivityDO result = trainactivityService.getByUid(uid);
        if(result==null)
            return R.failed(new ErrorCode(400));
        return R.ok(result).setCode(200);
    }

}
