package com.supergenius.admin.capital.controller;

import com.alibaba.fastjson.JSON;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.api.R;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.supergenius.admin.capital.model.VCMeetingDO;
import com.supergenius.admin.capital.model.vo.VCFiltrateMeetingVO;
import com.supergenius.admin.capital.model.vo.VCFiltrateOrderVO;
import com.supergenius.admin.capital.model.vo.VCGuaranteeAndRecommendDisplayVO;
import com.supergenius.admin.capital.service.IVCMeetingService;
import com.supergenius.admin.enums.StatusEnum;
import com.supergenius.admin.utils.ErrorCode;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;

@Slf4j
@Api(description="会议室")
@RequestMapping("/meeting")
@RestController
public class MeetingController {
    @Autowired
    IVCMeetingService ivcMeetingService;

    @ApiOperation("获取会议室列表")
    @GetMapping("/list/{pageNum}")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "pageNum", value = "页数", required = true, paramType = "path", dataType = "int"),
            @ApiImplicitParam(name = "filtrate", value = "过滤条件", paramType = "query", dataType = "String")
    })
    public R<IPage<VCMeetingDO>> getselectVCGuaranteeDisplayDO(@RequestParam(name = "filtrate", required = false) String filtrateStr, @PathVariable int pageNum) {
        log.info(filtrateStr + "--------------");
        VCFiltrateMeetingVO filtrateMeetingVO = JSON.parseObject(filtrateStr, VCFiltrateMeetingVO.class);
        //log.info(vcFiltrateVO + "--------------");
        System.out.println(filtrateMeetingVO);
        IPage<VCMeetingDO> iPage = ivcMeetingService.getMeetingDisplayList(new Page(pageNum, 10), filtrateMeetingVO);
        if (iPage.getRecords().size() > 0) {
            return R.ok(iPage).setCode(200);
        }
        return R.failed(new ErrorCode(401));
    }
    @PutMapping("/operateMetting")
    public R<Boolean> operateMetting( StatusEnum statusEnum,String...uids){
        Integer integer = ivcMeetingService.operateMetting(Arrays.asList(uids), statusEnum);
        return R.ok(true).setCode(200);
    }
    @GetMapping("/get/{uid}")
    public R<VCMeetingDO> getMeeting(@PathVariable String uid){
        VCMeetingDO result = ivcMeetingService.getByID(uid);
        if(result==null){
            return R.failed(new ErrorCode(400));
        }
        return R.ok(result).setCode(200);
    }

}
