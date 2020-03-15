package com.supergenius.admin.capital.controller;


import com.baomidou.mybatisplus.extension.api.R;
import com.supergenius.admin.capital.model.VCLabelDO;
import com.supergenius.admin.capital.service.IVCLabelService;
import com.supergenius.admin.enums.ELabelType;
import com.supergenius.admin.utils.ErrorCode;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@Api(description = "标签管理")
@RequestMapping("/lablecontroller")
@RestController
public class LabelController {
    @Autowired
    IVCLabelService labelService;
    @ApiOperation("添加标签")
    @PostMapping("/add")
    public R<Boolean> addLable(ELabelType type, String name){
        Integer result = labelService.addLable(type, name);
        if(result==1)
            return R.ok(true).setCode(200);
        return R.failed(new ErrorCode(400));
    }
    @ApiOperation("获取标签")
    @GetMapping("/get/{eLabelType}")
    public R<List<VCLabelDO>> getLableByType(@PathVariable ELabelType eLabelType){
        List<VCLabelDO> result = labelService.getLableByType(eLabelType);
        if(result.size()==0){
            return R.failed(new ErrorCode(400));
        }
        return R.ok(result).setCode(200);
    }
    @ApiOperation("删除标签")
    @DeleteMapping("/delete/{uid}")
    public R<Boolean> deleteLable(@PathVariable String uid){
        Integer result = labelService.deletet(uid);
        if(result==0){
            return R.failed(new ErrorCode(400));
        }
        return R.ok(true).setCode(200);
    }
}
