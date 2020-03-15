package com.supergenius.admin.capital.controller;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.api.R;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.supergenius.admin.capital.model.vo.VCRefundTradeInfoVO;
import com.supergenius.admin.capital.service.IVCOrdersService;
import com.supergenius.admin.enums.EOrder;
import com.supergenius.admin.utils.ErrorCode;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Slf4j
@RequestMapping("/refundtrade")
@Api(description="退款订单详情")
@RestController
public class RefundTradeController {
    @Autowired
    IVCOrdersService ivcOrdersService;
    @ApiOperation("获取退款订单详情")
    @ApiImplicitParam(name = "pageNum", value = "页数", required = true, paramType = "path", dataType = "int")
    @GetMapping("/getall/{pageNum}")
    public R<List<VCRefundTradeInfoVO>> getRefundTradeInfoList(@PathVariable Integer pageNum){
        IPage<VCRefundTradeInfoVO> list = ivcOrdersService.getAllRefundTradeInfo(new Page(pageNum, 10), EOrder.pendingrefund);
        if (list.getRecords().size()==0){
            return R.failed(new ErrorCode(400));
        }
        return R.ok(list.getRecords()).setCode(200);
    }
}
