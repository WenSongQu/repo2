package com.supergenius.admin.capital.controller;


import com.baomidou.mybatisplus.extension.api.R;
import com.sun.org.apache.xpath.internal.operations.Bool;
import com.supergenius.admin.capital.model.VCContentDO;
import com.supergenius.admin.capital.model.vo.VCImageUploadVO;
import com.supergenius.admin.capital.model.vo.VCPictureReturnVO;
import com.supergenius.admin.capital.service.IVCContentService;
import com.supergenius.admin.constants.SysConst;
import com.supergenius.admin.enums.EContentType;
import com.supergenius.admin.enums.ESide;
import com.supergenius.admin.enums.EUpload;
import com.supergenius.admin.utils.ErrorCode;
import com.supergenius.admin.utils.FileUtil;
import com.supergenius.admin.utils.ImgUtil;
import com.supergenius.admin.utils.MD5Util;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.apache.poi.ss.util.ImageUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import sun.security.krb5.internal.crypto.EType;

import javax.servlet.http.HttpServletRequest;
import javax.swing.text.StyledEditorKit;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import java.util.List;

@Api(description = "轮播图")
@Slf4j
@RequestMapping("/content")
@RestController
public class ContentController {
    @Autowired
    IVCContentService contentService;

    @ApiOperation("获取轮播图列表")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "side", value = "区分创业端和投资端  ", paramType = "path", dataType = "String"),
            @ApiImplicitParam(name = "type", value = "轮播类型", paramType = "path", dataType = "String")
    })
    @GetMapping("/content/{side}/{type}")
    public R<List<VCContentDO>> getVContentDOList(@PathVariable String side, @PathVariable String type) {
        if ("venture".equals(side)) {
            if ("index".equals(type)) {
                List<VCContentDO> list = contentService.getContent(ESide.venture, EContentType.index);
                if (list == null)
                    return R.failed(new ErrorCode(401));
                return R.ok(list).setCode(200);
            }
            if ("incubator".equals(type)) {
                List<VCContentDO> list = contentService.getContent(ESide.venture, EContentType.incubator);
                if (list == null)
                    return R.failed(new ErrorCode(401));
                return R.ok(list).setCode(200);
            }
        }
        if ("capital".equals(side)) {
            if ("index".equals(type)) {
                List<VCContentDO> list = contentService.getContent(ESide.capital, EContentType.index);
                if (list == null)
                    return R.failed(new ErrorCode(401));
                return R.ok(list).setCode(200);
            }
            if ("incubator".equals(type)) {
                List<VCContentDO> list = contentService.getContent(ESide.capital, EContentType.incubator);
                if (list == null)
                    return R.failed(new ErrorCode(401));
                return R.ok(list).setCode(200);
            }
        }
        return R.failed(new ErrorCode(400));
    }

    @ApiOperation("冻结或启动")
    @ApiImplicitParam(name = "uid", value = "uid  ", paramType = "query", dataType = "String")
    @PutMapping("/statusChange")
    public R<Boolean> statusChange(String uid) {
        Boolean result = contentService.statusChange(uid);
        if (result) {
            return R.ok(result).setCode(200);
        }
        return R.failed(new ErrorCode(401));
    }

    @ApiOperation("删除")
    @ApiImplicitParam(name = "uids", value = "uids  ", paramType = "query", dataType = "String", allowMultiple = true)
    @DeleteMapping("/delete")
    public R<Boolean> delete(String uid  ,ESide eSide, EContentType type) {
        contentService.deleteContent(uid,eSide,type);
        return R.ok(true).setCode(200);
    }

    @ApiOperation("上传图片")
    @PutMapping(value = "/imgUpload")
    public VCPictureReturnVO imgUpload(MultipartFile multiReq)
            throws IOException {
        // String fileUploadPath="G:\\images\\";
        System.out.println(multiReq.getOriginalFilename());
        String originalFilename = multiReq.getOriginalFilename();
        String suffix = originalFilename.substring(originalFilename.indexOf("."));
        String localFileName = MD5Util.md5(multiReq.getInputStream()) + suffix;
        File localFile = new File(SysConst.IMAGEPATH+ localFileName);
        try {
            multiReq.transferTo(localFile);
        } catch (IOException e) {
            e.printStackTrace();
        }
        String ImaBig = ImgUtil.resizeImage(SysConst.IMGBIGWIGTH, SysConst.IMGBIGHEIGHT,localFile.getPath());
        String ImgMedium = ImgUtil.resizeImage(SysConst.IMGMEDIUMWIGTH, SysConst.IMGMEDIUMHEIGHT,localFile.getPath());
        String ImgLittle = ImgUtil.resizeImage(SysConst.IMGLITTLEWIGTH, SysConst.IMGLITTLEWIGTH,localFile.getPath());
        VCPictureReturnVO result = new VCPictureReturnVO(ImaBig, ImgMedium, ImgLittle, localFile.getPath());
        return result;
    }

    @ApiOperation("添加轮播图")
    @PostMapping(value = "/addContent")
    public R<Boolean> addContent(VCContentDO contentDO, ESide eSide, EContentType type) {
        Integer integer = contentService.addContent(contentDO, eSide, type);
        if (integer == 1) {
            return R.ok(true).setCode(200);
        }
        return R.failed(new ErrorCode(400));
    }
    @ApiOperation("更新轮播图")
    @PutMapping(value = "/update")
    public R<Boolean> update(VCContentDO vcContentDO){
        Integer update = contentService.update(vcContentDO);
        return R.ok(true).setCode(200);
    }
    @ApiOperation("上移轮播图")
    @PutMapping(value = "/up")
    public R<Boolean> upOrder(ESide eSide, EContentType type){
        contentService.upOrder(eSide,type);
        return  R.ok(true).setCode(200);
    }
    @ApiOperation("下移轮播图")
    @PutMapping(value = "/down")
    public R<Boolean> downOrder(ESide eSide, EContentType type){
        contentService.downOrder(eSide,type);
        return  R.ok(true).setCode(200);
    }


}
