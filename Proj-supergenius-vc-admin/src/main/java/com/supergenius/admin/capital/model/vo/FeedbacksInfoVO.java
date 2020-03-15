package com.supergenius.admin.capital.model.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value="举报投资人的具体信息", description="")
public class FeedbacksInfoVO {
    @ApiModelProperty(value = "举报者")
    private String username;
    @ApiModelProperty(value = "被举报这")
    private String  toname;

}
