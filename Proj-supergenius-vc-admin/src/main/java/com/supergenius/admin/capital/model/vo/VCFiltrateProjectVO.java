package com.supergenius.admin.capital.model.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value="VCFiltrateVO对象", description="")
public class VCFiltrateProjectVO {
    @ApiModelProperty(value = "项目名称")
    private String pname;
    @ApiModelProperty(value = "用户名称")
    private String uname;
    @ApiModelProperty(value = "创建时间最早")
    private String createtimebegin;
    @ApiModelProperty(value = "创建时间最短")
    private String createtimeend;
    @ApiModelProperty(value = "省份")
    private String  province;
    @ApiModelProperty(value = "城市")
    private String city;
    @ApiModelProperty(value = "状态")
    private Integer status;
    @ApiModelProperty(value = "最少冻结")
    private Integer  freezecountmin;
    @ApiModelProperty(value = "最多冻结")
    private Integer  freezecountmax;
    @ApiModelProperty(value = "演出视频")
    private Integer videoupload;
    @ApiModelProperty(value = "融资轮次")
    private Integer rounds;
    @ApiModelProperty(value = "最小关注量")
    private Integer followcountmin;
    @ApiModelProperty(value = "最多关注量")
    private Integer followcountmax;
    @ApiModelProperty(value = "拍寻类型")
    private String order;
    @ApiModelProperty(value = "转售股份占比最大")
    private float sharestockMax;
    @ApiModelProperty(value = "转售股份占比最小")
    private float sharestockMin;
}
