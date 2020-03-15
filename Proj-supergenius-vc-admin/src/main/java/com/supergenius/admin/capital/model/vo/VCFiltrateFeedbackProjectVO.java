package com.supergenius.admin.capital.model.vo;

import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value="举报项目过滤条件", description="")
public class VCFiltrateFeedbackProjectVO {
    @ApiModelProperty(value = "举报者")
    private String username;
    @ApiModelProperty(value = "被举报者")
    private String toname;
    @ApiModelProperty(value = "被举报项目")
    private String pname;
    @ApiModelProperty(value = "举报标签")
    private String reason;
    @ApiModelProperty(value = "举报开始时间")
    private String startTime;
    @ApiModelProperty(value = "举报结束时间")
    private String endTime;
    @ApiModelProperty(value = "项目状态")
    private Integer projectstatus;
    @ApiModelProperty(value = "复审状态")
    private Integer secondreview;
    @ApiModelProperty(value = "结果")
    private Integer handle;
}
