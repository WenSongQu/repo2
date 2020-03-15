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
@ApiModel(value = "VCMeetingOrderInfoDO对象", description = "")
public class VCMeetingOrderInfoVO {
    @ApiModelProperty(value = "订单编号")
    private String ordercode;
    @ApiModelProperty(value = "订单id")
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
    @ApiModelProperty(value = "会议室名称")
    private String name;
    @ApiModelProperty(value = "会议室编号")
    private String sn;
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
    @ApiModelProperty(value = "发票内容")
    private EInvoiceType type;
    @ApiModelProperty(value = "发票抬手")
    private EInvoiceHead head;
    @ApiModelProperty(value = "发票内容")
    private String content;
    @ApiModelProperty(value = "单位名称")
    private String company;
    @ApiModelProperty(value = "单位税号")
    private String taxnumber;
    @ApiModelProperty(value = "电话")
    private String mobile;
    @ApiModelProperty(value = "邮箱")
    private String email;
    @ApiModelProperty(value = "收货人")
    private String addressee;
    @ApiModelProperty(value = "收货地址")
    private String address;
}
