package com.supergenius.admin.capital.controller;

import com.baomidou.mybatisplus.extension.api.R;
import com.supergenius.admin.capital.model.VCTemplateDO;
import com.supergenius.admin.capital.service.IVCTemplateService;
import com.supergenius.admin.enums.StatusEnum;
import com.supergenius.admin.utils.ErrorCode;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Slf4j
@RequestMapping("/template")
@Api(description="自动回复消息设置")
@RestController
public class TemplateController {
    @Autowired
    IVCTemplateService templateService;
    @ApiOperation("获取全部自动回复消息")
    @GetMapping("/list}")
    public R<List<VCTemplateDO>> getAllTemplate(){
        List<VCTemplateDO> list = templateService.getAllTemplate();
        //templateService.operateTemplate()
        if (list.size()==0)
            return R.failed(new ErrorCode(400));
        return R.ok(list).setCode(200);
    }

    @ApiOperation("操作自动回复信息")
    @PutMapping("/operatetemplate")
    public R<Boolean> operateTemplate(String uid, StatusEnum statusEnum){
        Integer integer = templateService.operateTemplate(uid, statusEnum);
        if(integer==null)
            return R.failed(new ErrorCode(400));
        return R.ok(true).setCode(200);
    }
    @ApiOperation("编辑自动回复信息")
    @PutMapping("/edittemplate")
    public R<Boolean> updateTemplate(String uid,String content){
        Integer integer = templateService.editTemplate(uid, content);
        if(integer==null)
            return R.failed(new ErrorCode(400));
        return R.ok(true).setCode(200);
    }
}
