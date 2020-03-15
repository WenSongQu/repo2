package com.supergenius.admin.capital.model.vo;

import com.supergenius.admin.enums.EPlatform;
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
@ApiModel(value="创业者融资记录", description="")
public class VCEnterpreneurmemberFinancingVO {
    @ApiModelProperty("项目编号")
    private String projectcode;
    @ApiModelProperty("项目名称")
    private String name;
    @ApiModelProperty("融资轮次")
    private Integer rounds;
    @ApiModelProperty("融资金额")
    private BigDecimal amount;
    @ApiModelProperty("融资平台")
    private EPlatform platform;
    @ApiModelProperty("结果")
    private EStatus  status; //状态[0:enable,1:disable]
    @ApiModelProperty("投资人")
    private String investor;
    @ApiModelProperty("融资时间")
    private Date createtime;



}
