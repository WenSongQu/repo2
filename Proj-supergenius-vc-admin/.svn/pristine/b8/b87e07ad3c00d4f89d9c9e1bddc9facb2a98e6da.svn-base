package com.supergenius.admin.capital.controller;

import com.alibaba.fastjson.JSON;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.api.R;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.supergenius.admin.capital.model.vo.VCFiltrateOrderVO;
import com.supergenius.admin.capital.model.vo.VCInvoicePrintVO;
import com.supergenius.admin.capital.model.vo.VCMemberOrderDisplayVO;
import com.supergenius.admin.capital.model.vo.VCOrderinfoVO;
import com.supergenius.admin.capital.service.IVCOrdersService;
import com.supergenius.admin.utils.ErrorCode;
import com.supergenius.admin.utils.ExcelUtil;
import com.supergenius.admin.utils.JsonUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.Arrays;
import java.util.List;

@Slf4j
@Api(description="会员订单")
@RestController
@RequestMapping("/memberOrder")
public class MemberOrderController {
    @Autowired
    IVCOrdersService ivcOrdersService;


    @ApiOperation(value = "获取会员订单列表", response = VCMemberOrderDisplayVO.class)
    @GetMapping("/list/{pageNum}")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "pageNum", value = "第几页", defaultValue = "1", dataType = "Integer"),
            @ApiImplicitParam(name = "filtrate", value = "过滤条件", paramType = "query", dataType = "String")
    })
    public R<IPage<VCMemberOrderDisplayVO>> getMemberOrderDisplay(@RequestParam(name = "filtrate") String filtrateStr, @PathVariable int pageNum) {
        VCFiltrateOrderVO vcFiltrateVO = JSON.parseObject(filtrateStr, VCFiltrateOrderVO.class);
        log.info(vcFiltrateVO + "--------------");
        IPage<VCMemberOrderDisplayVO> vcMemberOrderDisplayDOIPage = ivcOrdersService.selectMemberOrderDisplayDO(new Page(pageNum, 10), vcFiltrateVO);
        if (vcMemberOrderDisplayDOIPage.getRecords().size() > 0) {
            return R.ok(vcMemberOrderDisplayDOIPage).setCode(200);
        }
        return R.failed(new ErrorCode(401));
    }

    @ApiOperation(value = "获取会员订单通过oid", response = VCOrderinfoVO.class)
    @GetMapping("/{oid}")
    @ApiImplicitParam(name = "oid", value = "订单uid", paramType = "path", dataType = "String")
    public R<VCOrderinfoVO> getMemberOrderByOid(@PathVariable("oid") String oid) {
        VCOrderinfoVO vcOrderinfo = ivcOrdersService.selectOrderInfo(oid);
        if (vcOrderinfo != null) {
            return R.ok(vcOrderinfo).setCode(200);
        }
        return R.failed(new ErrorCode(401));
    }

    @ApiOperation("开票操作")
    @ApiImplicitParam(name = "oids", value = "订单uid", allowMultiple = true, dataType = "String", paramType = "query")
    @PostMapping("/invoice")
    public R<String> invoiceOids(String[] oids) {
        System.out.println(oids);
        List<String> list = Arrays.asList(oids);
        list.forEach(System.out::println);
        ivcOrdersService.invoiceed(Arrays.asList(oids));
        return R.ok("success").setCode(200);
    }

    @ApiOperation("导出excel")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "oids", value = "订单编号", allowMultiple = true, dataType = "String", paramType = "query"),
    })
    @GetMapping("/Excel")
    public void printExcel(HttpServletResponse response, String oids) throws Exception {
        List<String> ids = JsonUtil.jsonStringToList(oids, String.class);


        List<VCInvoicePrintVO> vcInvoicePrintDO = ivcOrdersService.getVCInvoicePrintDO(ids);
        vcInvoicePrintDO.forEach(System.out::println);

        ExcelUtil.simpleWrite(System.currentTimeMillis() + "", VCInvoicePrintVO.class, vcInvoicePrintDO, response);

    }

}
