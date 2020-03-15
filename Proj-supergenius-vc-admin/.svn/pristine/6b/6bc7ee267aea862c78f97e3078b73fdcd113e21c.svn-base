package com.supergenius.admin.capital.model.vo;

import com.alibaba.excel.annotation.ExcelProperty;
import com.alibaba.excel.annotation.format.DateTimeFormat;
import com.alibaba.excel.annotation.format.NumberFormat;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.supergenius.admin.convert.InvoiceHeadEnumConverter;
import com.supergenius.admin.convert.InvoiceTypeEnumConverter;
import com.supergenius.admin.enums.EInvoiceHead;
import com.supergenius.admin.enums.EInvoiceType;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.math.BigDecimal;
import java.util.Date;

@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value="VCInvoicePrintDO对象", description="")
public class VCInvoicePrintVO {
    @ExcelProperty(value = "序号")
    @ApiModelProperty(value = "序号")
    private Integer number;
    @ExcelProperty(value = "订单编号")
    @ApiModelProperty(value = "订单编号")
    private String ordercode;
    @ExcelProperty(value = "用户电话")
    @ApiModelProperty(value = "用户电话")
    private String userMobile;
    @ExcelProperty(value = "支付时间")
    @ApiModelProperty(value = "支付时间")
    @DateTimeFormat(value = "yyyy年MM月dd日HH时mm分ss秒")
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private Date createtime;
    @ApiModelProperty(value = "支付金额")
    @NumberFormat(value = "\u00A4#,###,###.00")
    @ExcelProperty(value = "支付金额")
    private BigDecimal amount;
    @ExcelProperty(value = "最晚开票时间")
    @DateTimeFormat(value = "yyyy年MM月dd日HH时mm分ss秒")
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
    @ApiModelProperty(value = "最晚开票时间")
    private Date invoicetime;
    @ApiModelProperty(value = "发票抬头")
    @ExcelProperty(value = "发票抬头", converter = InvoiceHeadEnumConverter.class)
    private EInvoiceHead head;
    @ApiModelProperty(value = "发票类型")
    @ExcelProperty(value = "发票类型", converter = InvoiceTypeEnumConverter.class)
    private EInvoiceType type;
    @ExcelProperty(value = "发票内容")
    @ApiModelProperty(value = "发票内容")
    private String content;
    @ExcelProperty(value = "发票公司")
    @ApiModelProperty(value = "发票公司")
    private String company;
    @ExcelProperty(value = "单位税号")
    @ApiModelProperty(value = "单位税号")
    private String taxnumber;
    @ExcelProperty(value = "收货人电话")
    @ApiModelProperty(value = "收货人电话")
    private String mobile;
    @ExcelProperty(value = "收货人邮件")
    @ApiModelProperty(value = "收货人邮件")
    private String email;
    @ExcelProperty(value = "收货人")
    @ApiModelProperty(value = "收货人")
    private String addressee;
    @ExcelProperty(value = "收货人地址")
    @ApiModelProperty(value = "收货人地址")
    private String address;
   // private String mobile;

}
