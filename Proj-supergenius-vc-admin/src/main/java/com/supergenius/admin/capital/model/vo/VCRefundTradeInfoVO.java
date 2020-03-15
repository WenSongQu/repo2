package com.supergenius.admin.capital.model.vo;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.supergenius.admin.convert.EOrderSerialize;
import com.supergenius.admin.convert.EOrderTypeSerialize;
import com.supergenius.admin.convert.SettledStatusSerialize;
import com.supergenius.admin.enums.EOrder;
import com.supergenius.admin.enums.EOrderType;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value="退款订单详情", description="")
public class VCRefundTradeInfoVO {
    @ApiModelProperty("oid")
    private String oid;
    @ApiModelProperty("订单编号")
    private String ordercode;
    @ApiModelProperty("订单类型")
    @JsonSerialize(using = EOrderTypeSerialize.class)
    private EOrderType orderType;
    @ApiModelProperty("用户名")
    private String userName;
    @ApiModelProperty("订单状态")
    @JsonSerialize(using = EOrderSerialize.class)
    private EOrder orderstatus;
}
