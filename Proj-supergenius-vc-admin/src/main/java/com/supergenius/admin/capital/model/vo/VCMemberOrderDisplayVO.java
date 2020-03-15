package com.supergenius.admin.capital.model.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.supergenius.admin.convert.OrderSerialize;
import com.supergenius.admin.convert.OrderStatusSerialize;
import com.supergenius.admin.convert.SiteSerialize;
import com.supergenius.admin.enums.EOrder;
import com.supergenius.admin.enums.EPayMethod;
import com.supergenius.admin.enums.EStatus;
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
@ApiModel(value = "VCMemberOrderDisplayDO对象", description = "")
public class VCMemberOrderDisplayVO {
    @ApiModelProperty(value = "订单编号")
    private String ordercode;
    @ApiModelProperty(value = "订单uid")
    private String oid;
    @ApiModelProperty(value = "用户名称")
    private String corporation;
    @ApiModelProperty(value = "金额")
    private BigDecimal amount;
    @ApiModelProperty(value = "订单创建时间")
    @JsonFormat(pattern = "yyyy-MM-dd HH：mm ", timezone = "GMT+8")
    private Date createtime;
    @JsonSerialize(using = SiteSerialize.class)
    @ApiModelProperty(value = "支付方式")
    private EPayMethod site;
    @JsonSerialize(using = OrderSerialize.class)
    @ApiModelProperty(value = "订单状态")
    private EOrder orderstatus;
    @ApiModelProperty(value = "是否需要开发票")
    @JsonSerialize(using = OrderStatusSerialize.class)
    private EStatus needinvoice;
    @ApiModelProperty(value = "发票状态")
    @JsonSerialize(using = OrderStatusSerialize.class)
    private EStatus invoicestatus;

}