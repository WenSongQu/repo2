package com.supergenius.admin.capital.controller;

import com.alibaba.fastjson.JSON;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.api.R;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.supergenius.admin.capital.model.VCCommentDO;
import com.supergenius.admin.capital.model.VCContentDO;
import com.supergenius.admin.capital.model.vo.VCEssayVO;
import com.supergenius.admin.capital.model.vo.VCFiltrateEssayVO;
import com.supergenius.admin.capital.model.vo.VCFiltrateOrderVO;
import com.supergenius.admin.capital.model.vo.VCGuaranteeAndRecommendDisplayVO;
import com.supergenius.admin.capital.service.IVCCommentService;
import com.supergenius.admin.capital.service.IVCContentService;
import com.supergenius.admin.capital.service.IVCEssayService;
import com.supergenius.admin.utils.ErrorCode;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Api(description = "动态管理")
@Slf4j
@RequestMapping("/essaycontroller")
@RestController
public class EssayController {
    @Autowired
    IVCEssayService essayService;
    @Autowired
    IVCCommentService contentService;
    @ApiOperation("获取动态")
    @GetMapping("/list/{pageNum}")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "pageNum", value = "页数", required = true, paramType = "path", dataType = "int"),
            @ApiImplicitParam(name = "filtrate", value = "过滤条件", paramType = "query", dataType = "String")
    })
    public R<IPage<VCEssayVO>> getAll(@RequestParam(name = "filtrate", required = false) String filtrateStr, @PathVariable int pageNum) {
        log.info(filtrateStr + "--------------");
        VCFiltrateEssayVO filtrate = JSON.parseObject(filtrateStr, VCFiltrateEssayVO.class);
        log.info(filtrate + "--------------");
        IPage<VCEssayVO> page = essayService.getAll(new Page(pageNum, 10), filtrate);
        if (page.getRecords().size() > 0) {
            return R.ok(page).setCode(200);
        }
        return R.failed(new ErrorCode(401));
    }
    @ApiOperation("获取动态基本信息")
    @GetMapping("/{uid}")
    public R<VCEssayVO> getByID(@PathVariable String uid){
        VCEssayVO essayVO = essayService.getByUid(uid);
        System.out.println(essayVO);
        if(essayVO==null)
            return R.failed(new ErrorCode(400));
        return R.ok(essayVO).setCode(200);
    }
    @ApiOperation("获取评论基本信息")
    @GetMapping("/content/{uid}")
    public R<List<VCCommentDO>> getContents(String uid){
        List<VCCommentDO> byPid = contentService.getByPid(uid);
        if(byPid.size()==0)
            return R.failed(new ErrorCode(400));
        return R.ok(byPid).setCode(200);
    }
    @ApiOperation("删除评论")
    @DeleteMapping("/content/{uid}")
    public R<Integer> deleteEssay(@PathVariable String uid){
        Integer integer = essayService.deleteEssay(uid);
        if (integer==0)
            return R.failed(new ErrorCode(400));
        return R.ok(integer).setCode(200);
    }

}
