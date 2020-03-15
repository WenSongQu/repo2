package com.supergenius.admin.capital.controller;

import com.alibaba.fastjson.JSON;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.api.R;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.supergenius.admin.capital.model.vo.VCFiltrateMessageVO;
import com.supergenius.admin.capital.model.vo.VCFiltrateOrderVO;
import com.supergenius.admin.capital.model.vo.VCMeetingOrderDisplayVO;
import com.supergenius.admin.capital.model.vo.VCMessageDisplayVO;
import com.supergenius.admin.capital.service.IVCMessagesService;
import com.supergenius.admin.utils.ErrorCode;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RequestMapping("/message")
@Api(description="站内信息 ")
@RestController
public class MessageController {
    @Autowired
    IVCMessagesService messagesService;
    @ApiOperation("获取会议室预约订单列表")
    @GetMapping("/list/{pageNum}")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "pageNum", value = "页数", required = true, paramType = "path", dataType = "int"),
            @ApiImplicitParam(name = "filtrate", value = "过滤条件", paramType = "query", dataType = "String")
    })
    public R<IPage<VCMessageDisplayVO>> getVCMeetingOrderDisplayDO(@RequestParam(name = "filtrate", required = false) String filtrateStr, @PathVariable int pageNum) {
        log.info(filtrateStr + "--------------");
        VCFiltrateMessageVO vcFiltrateVO = JSON.parseObject(filtrateStr, VCFiltrateMessageVO.class);
        log.info(vcFiltrateVO + "--------------");
        IPage<VCMessageDisplayVO> page = messagesService.getPage(new Page(pageNum, 10), vcFiltrateVO);
        if (page.getRecords().size() > 0) {
            return R.ok(page).setCode(200);
        }
        return R.failed(new ErrorCode(401));
    }
    @PostMapping("/delete")
    public R<Boolean> deleteMessage(String uid){
        Integer result = messagesService.deleteByUid(uid);
        if(result==0)
            return R.failed(new ErrorCode(401));
        return  R.ok(true).setCode(200);
    }
}
