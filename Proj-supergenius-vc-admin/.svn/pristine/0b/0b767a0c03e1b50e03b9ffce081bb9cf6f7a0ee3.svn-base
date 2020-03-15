package com.supergenius.admin.capital.model.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.supergenius.admin.enums.EOrder;
import com.supergenius.admin.enums.EPayMethod;
import com.supergenius.admin.enums.EReview;
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
@ApiModel(value="VCGuaranteeAndRecommendDisplayDO对象", description="")
public class VCGuaranteeAndRecommendDisplayVO {
    @ApiModelProperty(value = "订单编号")
    private String ordercode;
    @ApiModelProperty(value = "订单号")
    private String oid;
    @ApiModelProperty(value = "用户名")
    private String corporation;
    @ApiModelProperty(value = "交易金额")
    private BigDecimal amount;
    @ApiModelProperty(value = "创建时间")
    @JsonFormat(pattern="yyyy-MM-dd HH：mm ",timezone = "GMT+8")
    private Date createtime;
    @ApiModelProperty(value = "支付方式")
    private EPayMethod site;
    @ApiModelProperty(value = "是否需要开发票")
    private EStatus needinvoice;
    @ApiModelProperty(value = "发票状态")
    private EStatus invoicestatus;
    @ApiModelProperty(value = "审核状态")
    private EReview reviewstatus;
    @ApiModelProperty(value = "订单状态")
    private EOrder orderstatus;
}
