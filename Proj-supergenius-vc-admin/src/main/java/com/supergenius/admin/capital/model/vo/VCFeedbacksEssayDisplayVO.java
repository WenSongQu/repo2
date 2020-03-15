package com.supergenius.admin.capital.model.vo;

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
@ApiModel(value="举报动态展示", description="")
public class VCFeedbacksEssayDisplayVO {
    @ApiModelProperty(value = "uid")
    private String uid;
    @ApiModelProperty(value = "举报者")
    private String  username;
    @ApiModelProperty(value = "被举报者")
    private String toname;
    @ApiModelProperty(value = "举报标签")
    private String lname;
    @ApiModelProperty(value = "举报时间")
    private Date createtime;
    @ApiModelProperty(value = "电话")
    private String mobile;
    @ApiModelProperty(value = "结果")
    private EStatus handle;
    @ApiModelProperty(value = "帖子状态")
    private EStatus tostatus;
}
