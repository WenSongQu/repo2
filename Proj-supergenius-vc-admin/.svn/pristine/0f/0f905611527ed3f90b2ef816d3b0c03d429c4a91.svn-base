package com.supergenius.admin.capital.controller;

import com.alibaba.fastjson.JSON;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.api.R;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.supergenius.admin.capital.model.*;
import com.supergenius.admin.capital.model.vo.*;
import com.supergenius.admin.capital.service.*;
import com.supergenius.admin.enums.EIdentityType;
import com.supergenius.admin.utils.ErrorCode;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import io.swagger.models.auth.In;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Slf4j
@Api(description = "投资者会员")
@RequestMapping("/investorsmember")
@RestController
public class InvestorsMemberController {
    @Autowired
    IVCUserService ivcUserService;
    @Autowired
    IVCRecordService ivcRecordService;
    @Autowired
    IVCOrganizationService ivcOrganizationService;
    @Autowired
    IVCInvestmentService ivcInvestmentService;
    @Autowired
    IVCOrdersService ivcOrdersService;
    @Autowired
    IVCUserinfoService ivcUserinfoService;
    @Autowired
    IVCFundService ivcFundService;

    @ApiOperation("获取投资者信息列表")
    @GetMapping("/list/{pageNum}")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "pageNum", value = "页数", required = true, paramType = "path", dataType = "int"),
            @ApiImplicitParam(name = "filtrate", value = "过滤条件", paramType = "query", dataTypeClass = VCFiltrateUserVO.class)
    })
    public R<IPage<VCInvestorsDisplayVO>> getselectVEntrepreneurMemberDisplayDO(@RequestParam(name = "filtrate", required = false) String filtrateStr, @PathVariable int pageNum) {
        log.info(filtrateStr + "--------------");
        VCFiltrateUserVO vcFiltrateUserVO = JSON.parseObject(filtrateStr, VCFiltrateUserVO.class);
        log.info(vcFiltrateUserVO + "--------------");
        IPage<VCInvestorsDisplayVO> vcInvestorsDisplayVOIPage = ivcUserService.selectInvestorsDisplayVO(new Page(pageNum, 10), vcFiltrateUserVO);
        if (vcInvestorsDisplayVOIPage.getRecords().size() > 0) {
            return R.ok(vcInvestorsDisplayVOIPage).setCode(200);
        }
        return R.failed(new ErrorCode(401));
    }

    @ApiOperation("冻结账户和相对应的项目")
    @ApiImplicitParam(name = "useruids", value = "用户uid", dataType = "String", allowMultiple = true, paramType = "query")
    @PostMapping("/freezeUser")
    @Transactional
    public R<Boolean> freezeUser(String... useruids) {
        try {
            ivcUserService.freezeUser(Arrays.asList(useruids));
            return R.ok(true).setCode(200);
        } catch (Exception e) {
            e.printStackTrace();
            return R.failed("failed");
        }


    }

    @ApiOperation("解冻账户")
    @ApiImplicitParam(name = "useruids", value = "用户uid", dataType = "String", allowMultiple = true, paramType = "query")
    @PostMapping("/unFreezeUser")
    @Transactional
    public R<Boolean> unFreezeUser(String... useruids) {
        try {
            ivcUserService.unFreezeUser(Arrays.asList(useruids));
            return R.ok(true).setCode(200);
        } catch (Exception e) {
            e.printStackTrace();
            return R.failed("failed");
        }
    }

    @ApiOperation("个人信息")
    @ApiImplicitParam(name = "useruid", value = "用户uid", dataType = "String", paramType = "path")
    @GetMapping("/getPersonInfo/{useruid}")
    public R<VCInvestorsmemberPersonVO> getInvestorsmemberPerson(@PathVariable("useruid") String useruid) {
        //获取基本信息
        VCInvestorsBasePersonInfoVO baseInfo = ivcUserService.getVCInvestorsBasePersonInfoVCById(useruid);
        if (baseInfo == null) {
            return R.failed("failed");
        }
        //投资意向
        VCInvestmentDO investmentInfo = ivcInvestmentService.getInvestmentInfo(useruid);
        VCInvestorsmemberPersonVO info = new VCInvestorsmemberPersonVO(baseInfo, investmentInfo);
        return R.ok(info).setCode(200);
    }

    @ApiOperation("公司信息")
    @ApiImplicitParam(name = "useruid", value = "用户uid", dataType = "String", paramType = "path")
    @GetMapping("/getCompanyInfo/{useruid}")
    public R<VCInvestorsmemberConpanyVO> getInvestorsmemberConpany(@PathVariable("useruid") String useruid) {
        //获取基本信息
        VCInvestorsBaseConpantyInfoVO2 baseInfo = ivcUserService.getVCInvestorsBaseConpantyInfoVCById(useruid);
        if (baseInfo == null) {
            return R.failed("failed");
        }
        //机构详情
        VCOrganizationDO organizationInfo = ivcOrganizationService.getOrganizationInfo(useruid);
        //投资意向
        VCInvestmentDO investmentInfo = ivcInvestmentService.getInvestmentInfo(useruid);
        //订单记录
        VCInvestorsmemberConpanyVO vcInvestorsmemberConpanyVO = new VCInvestorsmemberConpanyVO(
                baseInfo, organizationInfo, investmentInfo);

        return R.ok(vcInvestorsmemberConpanyVO).setCode(200);
    }

    @ApiOperation("更多订单记录")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "uid", value = "用户uid", dataType = "String", paramType = "path"),
            @ApiImplicitParam(name = "pageNum", value = "页数", dataType = "Int", paramType = "path")
    })
    @GetMapping("/moreorder/{uid}/{pageNum}")
    public R<List<VCEnterpreneurmemberOrderVO>> moreOrder(@PathVariable String uid, @PathVariable int pageNum) {
        List<VCEnterpreneurmemberOrderVO> list = ivcUserService.getVCEnterpreneurmemberOrderVOById(uid, pageNum - 1);
        if (list.size() == 10) {
            return R.ok(list).setCode(200);
        }
        if (list.size() > 0) {
            return R.ok(list).setCode(201);
        }
        return R.failed(new ErrorCode(401));
    }

    @ApiOperation("更多召集记录")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "uid", value = "用户uid", dataType = "String", paramType = "path"),
            @ApiImplicitParam(name = "pageNum", value = "页数", dataType = "Int", paramType = "path")
    })
    @GetMapping("/conveneRecord/{uid}/{pageNum}")
    public R<List<VCRecordDO>> moreConveneRecord(@PathVariable String uid, @PathVariable Integer pageNum) {
        List<VCRecordDO> list = ivcRecordService.getConveneRecord(uid, pageNum - 1);
        if (list.size() == 10) {
            return R.ok(list).setCode(200);
        }
        if (list.size() > 0) {
            return R.ok(list).setCode(201);
        }
        return R.failed(new ErrorCode(401));
    }

    @ApiOperation("更多投资记录")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "uid", value = "用户uid", dataType = "String", paramType = "path"),
            @ApiImplicitParam(name = "pageNum", value = "页数", dataType = "Int", paramType = "path")
    })
    @GetMapping("/moreinvestmen/{uid}/{pageNum}")
    public R<List<VCRecordDO>> moreInvestmen(@PathVariable String uid, @PathVariable Integer pageNum) {
        List<VCRecordDO> list = ivcRecordService.getInvestmentRecord(uid, pageNum - 1);
        if (list.size() == 10) {
            return R.ok(list).setCode(200);
        }
        if (list.size() > 0) {
            return R.ok(list).setCode(201);
        }
        return R.failed(new ErrorCode(401));
    }

    @ApiOperation("更多保推记录")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "uid", value = "用户uid", dataType = "String", paramType = "path"),
            @ApiImplicitParam(name = "pageNum", value = "页数", dataType = "Int", paramType = "path")
    })
    @GetMapping("/moregnvestmentRecord/{uid}/{pageNum}")
    public R<List<VCRecordDO>> moreGnvestmentRecord(@PathVariable String uid, @PathVariable Integer pageNum) {
        List<VCRecordDO> list = ivcRecordService.getGnvestmentRecord(uid, pageNum - 1);
        if (list.size() == 10) {
            return R.ok(list).setCode(200);
        }
        if (list.size() > 0) {
            return R.ok(list).setCode(201);
        }
        return R.failed(new ErrorCode(401));
    }

    @ApiOperation("更多推荐记录")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "uid", value = "用户uid", dataType = "String", paramType = "path"),
            @ApiImplicitParam(name = "pageNum", value = "页数", dataType = "Int", paramType = "path")
    })
    @GetMapping("/moreecomrmendedRecord/{uid}/{pageNum}")
    public R<List<VCRecordDO>> moreEcomrmendedRecord(@PathVariable String uid, @PathVariable Integer pageNum) {
        List<VCRecordDO> list = ivcRecordService.getEcomrmendedRecord(uid, pageNum - 1);
        if (list.size() == 10) {
            return R.ok(list).setCode(200);
        }
        if (list.size() > 0) {
            return R.ok(list).setCode(201);
        }
        return R.failed(new ErrorCode(401));
    }
    @ApiOperation("查看基金")
    @ApiImplicitParam(name = "useruid", value = "用户uid", dataType = "String", paramType = "path")
    @GetMapping("/fund/{useruid}")
    public R<List<VCFundDO>> getFundById(@PathVariable String useruid){
        List<VCFundDO> list = ivcFundService.getFundsById(useruid);
        if(list.size()==0){
            return R.failed(new ErrorCode(401));
        }
        return R.ok(list).setCode(200);
    }

}
