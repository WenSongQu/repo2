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
@ApiModel(value="举报消息详情", description="")
public class VCFeedbacksMessageInfoVO {
    @ApiModelProperty(value = "uid")
    private String uid;
    @ApiModelProperty(value = "举报者")
    private String username;
    @ApiModelProperty(value = "被举报者")
    private String toname;
    @ApiModelProperty(value = "举报标签")
    private String name;
    @ApiModelProperty(value = "被举报者冻结次数")
    private Integer freezecount;
    @ApiModelProperty(value = "举报时间")
    private Date createtime;
    @ApiModelProperty(value = "结果")
    private EStatus handle;
    @ApiModelProperty(value = "被举报者状态")
    private EStatus tostatus;
    @ApiModelProperty(value = "举报说明")
    private String content;
    @ApiModelProperty(value = "举报图片")
    private String images;

}
