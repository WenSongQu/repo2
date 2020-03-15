package com.supergenius.admin.capital.model.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.supergenius.admin.enums.*;
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
@ApiModel(value = "VCVideoOrderInfoVO对象", description = "")

public class VCVideoOrderInfoVO {
    @ApiModelProperty(value = "订单编号")
    private String ordercode;
    @ApiModelProperty(value = "项目uid")
    private String oid;
    @ApiModelProperty(value = "用户名")
    private String corporation;
    @ApiModelProperty(value = "金额")
    private BigDecimal amount;
    @ApiModelProperty(value = "订单创建时间")
    @JsonFormat(pattern="yyyy-MM-dd HH：mm ",timezone = "GMT+8")
    private Date createtime;
    @ApiModelProperty(value = "支付方式")
    private EPayMethod site;
    @ApiModelProperty(value = "项目名称")
    private String name;
    //private String sn;
    @ApiModelProperty(value = "是否需要开发票")
    private EStatus needinvoice;
    @ApiModelProperty(value = "发票状态")
    private EStatus invoicestatus;
    @ApiModelProperty(value = "申请时间")
    @JsonFormat(pattern="yyyy-MM-dd HH：mm ",timezone = "GMT+8")
    private Date applytime;
    @ApiModelProperty(value = "开票时间")
    @JsonFormat(pattern="yyyy-MM-dd HH：mm ",timezone = "GMT+8")
    private Date invoicetime;
    @ApiModelProperty(value = "发票类型")
    private EInvoiceType type;
    @ApiModelProperty(value = "发票抬头")
    private EInvoiceHead head;
    @ApiModelProperty(value = "发票内容")
    private String content;
    @ApiModelProperty(value = "单位名称")
    private String company;
    @ApiModelProperty(value = "税务编号")
    private String taxnumber;
    @ApiModelProperty(value = "电话")
    private String mobile;
    @ApiModelProperty(value = "邮箱")
    private String email;
    @ApiModelProperty(value = "收货人名称")
    private String addressee;
    @ApiModelProperty(value = "地址")
    private String address;
    @ApiModelProperty(value = "订单状态")
    private EOrder orderstatus;
    @ApiModelProperty(value = "是否使用")
    private EStatus isused;



}