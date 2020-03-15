package com.supergenius.admin.capital.model.vo;

import com.supergenius.admin.enums.EActivity;
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
@ApiModel(value="路演活动条件过滤", description="")
public class VCFiltrateTrainactivityVO {
    @ApiModelProperty(value = "名称")
    private String tname;
    @ApiModelProperty(value = "状态")
    private EActivity activitystatus;
    @ApiModelProperty(value = "最少盈利")
    private BigDecimal minsummoney;
    @ApiModelProperty(value = "最多盈利")
    private BigDecimal maxsummoney;
    @ApiModelProperty(value = "举办最早时间")
    private String starttime;
    @ApiModelProperty(value = "举办最晚时间")
    private String overtime;
    @ApiModelProperty(value = "报名开始时间")
    private String signtime;
    @ApiModelProperty(value = "报名结束时间")
    private String endtime;

}
