package com.supergenius.admin.capital.model.vo;

import com.baomidou.mybatisplus.annotation.TableName;
import com.supergenius.admin.enums.EProjectStatus;
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
@ApiModel(value="举报项目列表", description="")
public class VCFeedbackProjectDisplayVO {
    @ApiModelProperty(value = "uid")
    private String uid;
    @ApiModelProperty(value = "举报人名称")
    private String username;
    @ApiModelProperty(value = "被举报人名称")
    private String toname;
    @ApiModelProperty(value = "被举报人项目名称")
    private  String pname;
    @ApiModelProperty(value = "举报标签")
    private String iname;
    @ApiModelProperty(value = "举报时间")
    private Date createtime;
    @ApiModelProperty(value = "电话")
    private String mobile;
    @ApiModelProperty(value = "结果")
    private EStatus handle;
    @ApiModelProperty(value = "项目状态")
    private EProjectStatus projectstatus;
    @ApiModelProperty(value = "复审时间")
    private EReview secondreview;

}
