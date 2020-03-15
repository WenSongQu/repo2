package com.supergenius.admin.capital.model.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.math.BigDecimal;

@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value="会议室", description="")
public class VCFiltrateMeetingVO {
    @ApiModelProperty("会议室名称")
    private String mname;
    @ApiModelProperty("会议室地区")
    private String area;
    @ApiModelProperty("最大面积")
    private Integer maxArea;
    @ApiModelProperty("最小面积")
    private Integer minArea;
    @ApiModelProperty("最小座位数量")
    private Integer minNumber;
    @ApiModelProperty("最大座位数量")
    private Integer maxNumber;
    @ApiModelProperty("最贵价格")
    private BigDecimal maxPrice;
    @ApiModelProperty("最小价格")
    private BigDecimal minPrice;
    @ApiModelProperty("最小盈利")
    private BigDecimal minSummoney;
    @ApiModelProperty("最大盈利")
    private BigDecimal maxSummoney;
    @ApiModelProperty("状态")
    private Integer status;
    @ApiModelProperty("开始上线时间")
    private String showtimeBegin;
    @ApiModelProperty("结束上线时间")
    private String showtimeEnd;

}
