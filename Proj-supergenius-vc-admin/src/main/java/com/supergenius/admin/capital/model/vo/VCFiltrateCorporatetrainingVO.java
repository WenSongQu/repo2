package com.supergenius.admin.capital.model.vo;

import com.supergenius.admin.enums.EActivity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.annotations.ApiOperation;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value="路演活动审核筛选条件", description="")
public class VCFiltrateCorporatetrainingVO {
    @ApiModelProperty(value = "课程名称")
    private String name;
    @ApiModelProperty(value = "课程地址")
    private String address;
    @ApiModelProperty(value = "课程最少数量")
    private Integer coursecountMin;
    @ApiModelProperty(value = "课程最多数量")
    private Integer coursecountMax;
    @ApiModelProperty(value = "最少名额")
    private Integer pernumberMin;
    @ApiModelProperty(value = "最多名额")
    private Integer pernumberMax;
    @ApiModelProperty(value = "开始时间")
    private String startTime;
    @ApiModelProperty(value = "结束时间")
    private String endTime;
    @ApiModelProperty(value = "状态")
    private EActivity state;


}
