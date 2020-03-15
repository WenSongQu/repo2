package com.supergenius.admin.capital.model.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.supergenius.admin.enums.EOrder;
import com.supergenius.admin.enums.EOrderType;
import com.supergenius.admin.enums.EPayMethod;
import com.supergenius.admin.enums.EStatus;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.util.Date;

@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value="VCFiltrateVO对象", description="")
public class VCFiltrateOrderVO {

    @ApiModelProperty(value = "订单编号")
    private String ordercode;
    //   @JsonFormat(pattern="yyyy-MM-dd",timezone = "GMT+8")
    @ApiModelProperty(value = "开始时间")
    private String begintime;
    //  @JsonFormat(pattern="yyyy-MM-dd",timezone = "GMT+8")
    @ApiModelProperty(value = "结束时间")
    private String endtime;
    @ApiModelProperty(value = "支付方式")
    private Integer site;
    @ApiModelProperty(value = "订单状态")
    private Integer orderstatus;
    @ApiModelProperty(value = "是否需要开发票")
    private Integer needinvoice;
    @ApiModelProperty(value = "发票状态")
    private Integer invoicestatus;
    @ApiModelProperty(value = "发票类型")
    private Integer type;
    @ApiModelProperty(value = "拍寻类型")
    private String order;
    @ApiModelProperty(value = "用户名")
    private String corporation;
    @ApiModelProperty(value = "会议室名称")
    private String name;
    @ApiModelProperty(value = "会议室开始时间")
    private String starttime;
    @ApiModelProperty(value = "会议室结束时间")
    private String overtime;
    @ApiModelProperty(value = "审核状态")
    private Integer reviewstatus;
    @ApiModelProperty(value = "路演活动名称")
    private String trainactivityname;
    @ApiModelProperty(value = "报名编号")
    private String signcode;
    private Integer trainactivitytype;
    @ApiModelProperty(value = "是否使用视频")
    private Integer isused;
}
