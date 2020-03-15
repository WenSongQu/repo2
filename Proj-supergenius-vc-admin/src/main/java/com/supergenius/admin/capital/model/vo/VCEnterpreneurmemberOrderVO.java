package com.supergenius.admin.capital.model.vo;

import com.baomidou.mybatisplus.annotation.TableField;
import com.supergenius.admin.enums.EOrderType;
import com.supergenius.admin.enums.EPayMethod;
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
@ApiModel(value="创业者订单记录", description="")
public class VCEnterpreneurmemberOrderVO {
    @ApiModelProperty("订单编号")
    private String ordercode;
    @ApiModelProperty("订单名称")
    private String name;
    @ApiModelProperty("支付金额")
    private BigDecimal amount;
    @ApiModelProperty("支付方式")
    private EPayMethod site;
    @ApiModelProperty("订单时间")
    private Date createtime;
    @ApiModelProperty(value = "订单类型")
    private EOrderType type;

}
