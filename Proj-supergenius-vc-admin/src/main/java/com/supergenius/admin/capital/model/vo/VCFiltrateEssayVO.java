package com.supergenius.admin.capital.model.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value="路演活动审核筛选条件", description="")
public class VCFiltrateEssayVO {
    @ApiModelProperty(value = "用户名")
    private String uname;
    @ApiModelProperty(value = "内容")
    private String content;
    @ApiModelProperty(value = "开始时间")
    private String starttime;
    @ApiModelProperty(value = "结束时间")
    private String endtime;
}
