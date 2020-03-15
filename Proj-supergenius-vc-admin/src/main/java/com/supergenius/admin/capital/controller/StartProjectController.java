package com.supergenius.admin.capital.controller;

import com.alibaba.fastjson.JSON;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.api.R;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.sun.org.apache.regexp.internal.RE;
import com.supergenius.admin.capital.model.VCCommentDO;
import com.supergenius.admin.capital.model.VCProjectDO;
import com.supergenius.admin.capital.model.VCProjectinfoDO;
import com.supergenius.admin.capital.model.VCVideoDO;
import com.supergenius.admin.capital.model.vo.*;
import com.supergenius.admin.capital.service.IVCCommentService;
import com.supergenius.admin.capital.service.IVCProjectService;
import com.supergenius.admin.capital.service.IVCProjectinfoService;
import com.supergenius.admin.capital.service.IVCVideoService;
import com.supergenius.admin.enums.EProjecttype;
import com.supergenius.admin.utils.ErrorCode;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.omg.CORBA.PUBLIC_MEMBER;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

@Slf4j
@RequestMapping("/startproject")
@Api(description="创业项目")
@RestController
public class StartProjectController {
    @Autowired
    IVCProjectService projectService;
    @Autowired
    IVCProjectinfoService projectinfoService;
    @Autowired
    IVCVideoService videoService;
    @Autowired
    IVCCommentService commentService;
    @ApiOperation("获取创业项目列表")
    @GetMapping("/list/{pageNum}")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "pageNum", value = "页数", required = true, paramType = "path", dataType = "int"),
            @ApiImplicitParam(name = "filtrate", value = "过滤条件", paramType = "query", dataType = "String")
    })
    public R<IPage<VCProjectDisplayVO>> getselectVCGuaranteeDisplayDO(@RequestParam(name = "filtrate", required = false) String filtrateStr, @PathVariable int pageNum) {
//        log.info(filtrateStr + "--------------");
//        VCFiltrateOrderVO vcFiltrateVO = JSON.parseObject(filtrateStr, VCFiltrateOrderVO.class);
//        log.info(vcFiltrateVO + "--------------");
//        IPage<VCGuaranteeAndRecommendDisplayVO> vcGuaranteeAndRecommendDisplayDOIPage = ivcOrdersService.selectVCGuaranteeDisplayDO(new Page(pageNum, 10), vcFiltrateVO);
//        if (vcGuaranteeAndRecommendDisplayDOIPage.getRecords().size() > 0) {
//            return R.ok(vcGuaranteeAndRecommendDisplayDOIPage).setCode(200);
//        }
        VCFiltrateProjectVO filtrate = JSON.parseObject(filtrateStr, VCFiltrateProjectVO.class);
        IPage<VCProjectDisplayVO> list = projectService.selectProjectDisplayPage(new Page(pageNum, 10), filtrate, EProjecttype.financingproject);
        if(list.getRecords().size()==0){
            return R.failed(new ErrorCode(401));
        }
        return R.ok(list).setCode(200);
    }
    @ApiOperation("冻结项目")
    @PutMapping("/freezed")
    public R<Integer>  freezedProject(String...uids){
        //仅进行项目冻结次数+1 人物冻结次数+1
        Integer result = projectService.freezeProject(Arrays.asList(uids));
        return R.ok(result).setCode(200);
    }
    @ApiOperation("解冻")
    @PutMapping("/unfreezed")
    public R<Integer>  unFreezeedProject(String...uids){
        Integer result = projectService.unFreezeProject(Arrays.asList(uids));
        return R.ok(result).setCode(200);
    }
    @ApiOperation("获取基本信息")
    @GetMapping("/getbaseinfo/{pid}")
    public R<VCProjectDO> getBaseinfo(@PathVariable String pid){
        VCProjectDO result = projectService.getBaseinfo(pid);
        if(result==null)
            return R.failed(new ErrorCode(400));
        return R.ok(result).setCode(200);
    }
    @ApiOperation("获取项目介绍")
    @GetMapping("/projectintroduction/{pid}")
    public R<VCProjectIntroductionVO> getProjectIntroduction(@PathVariable String pid){
        //缺少最后一项
        VCProjectIntroductionVO introduction = projectService.getProjectIntroduction(pid);
        if(introduction==null){
            return R.failed(new ErrorCode(400));
        }
        return R.ok(introduction).setCode(200);
    }
    @ApiOperation("获取融资需求")
    @GetMapping("/projectinfo/{pid}")
    public R<VCProjectinfoDO> getProjectInfo(String pid){
        VCProjectinfoDO info = projectinfoService.getByPid(pid);
        if(info==null){
            return R.failed(new ErrorCode(400));
        }
        return R.ok(info).setCode(200);

    }
    @ApiOperation("获取视频")
    @GetMapping("/projectvideo/{pid}")
    public R<VCVideoDO> getVideo(@PathVariable String pid){
        VCVideoDO video = videoService.getByPid(pid);
        if(video==null){
            return R.failed(new ErrorCode(400));
        }
        return R.ok(video).setCode(200);
    }
    @ApiOperation("获取简介")
    @GetMapping("/projectsummary/{pid}")
    public R<String> getSummary(@PathVariable String pid){
        String projectSummary = projectService.getProjectSummary(pid);
        if(StringUtils.isEmpty(projectSummary)){
            return R.failed(new ErrorCode(400));
        }
        return R.ok(projectSummary).setCode(200);
    }
    @ApiOperation("获取评论")
    @GetMapping("/projectcomment/{pid}")
    public R<List<VCCommentDO>> getComment(String pid){
        List<VCCommentDO> commentList = commentService.getByPid(pid);
        if(commentList.size()==0){
            return R.failed(new ErrorCode(400));
        }
        return R.ok(commentList).setCode(200);
    }



}
