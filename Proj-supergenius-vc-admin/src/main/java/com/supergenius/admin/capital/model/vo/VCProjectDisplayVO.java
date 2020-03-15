package com.supergenius.admin.capital.model.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.supergenius.admin.convert.EFinacingStatusSerialize;
import com.supergenius.admin.convert.EOrderTypeSerialize;
import com.supergenius.admin.convert.SatausSerialize;
import com.supergenius.admin.enums.EFinacingStatus;
import com.supergenius.admin.enums.EStatus;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value="项目展示", description="")
public class VCProjectDisplayVO {
    @ApiModelProperty(value = "pid")
    private String pid;
    @ApiModelProperty(value = "项目编号")
    private String projectcode;
    @ApiModelProperty(value = "项目名称")
    private String pname;
    @ApiModelProperty(value = "用户名称")
    private String uname;
    @ApiModelProperty(value = "创建时间")
    @JsonFormat(pattern="yyyy-MM-dd HH：mm ",timezone = "GMT+8")
    private Date createtime;
    @ApiModelProperty(value = "地区")
    private  String area;
    @ApiModelProperty(value = "演出视频")
    @JsonSerialize(using = SatausSerialize.class)
    private EStatus videoupload;
    @ApiModelProperty(value = "关注量")
    private Integer followcount;
    @ApiModelProperty(value = "冻结次数")
    private Integer freezecount;
    @ApiModelProperty(value = "状态")
    @JsonSerialize(using = EFinacingStatusSerialize.class)
    private EFinacingStatus finacingstatus;

}
