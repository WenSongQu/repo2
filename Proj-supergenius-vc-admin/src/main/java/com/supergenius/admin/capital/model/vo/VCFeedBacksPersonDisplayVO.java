package com.supergenius.admin.capital.model.vo;

import com.supergenius.admin.enums.EReview;
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
@ApiModel(value="举报投资人", description="")
public class VCFeedBacksPersonDisplayVO {
    @ApiModelProperty(value = "uid")
    private String uid;
    @ApiModelProperty(value = "舉報者")
    private String username;
    @ApiModelProperty(value = "被举报投资人")
    private String toname;
    @ApiModelProperty(value = "举报标签")
    private String name;
    @ApiModelProperty(value = "举报时间")
    private Date  createtime;
    @ApiModelProperty(value = "电话")
    private String mobile;
    @ApiModelProperty(value = "结果")
    private EStatus handle;
    @ApiModelProperty(value = "被举报的账户状态")
    private EStatus tostatus;
    @ApiModelProperty(value = "会复审状态")
    private EReview secondreview;
}
