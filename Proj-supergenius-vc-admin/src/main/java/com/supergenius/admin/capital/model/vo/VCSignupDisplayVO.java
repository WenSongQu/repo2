package com.supergenius.admin.capital.model.vo;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.supergenius.admin.convert.EOrderSerialize;
import com.supergenius.admin.convert.IdentitySerialize;
import com.supergenius.admin.enums.EIdentity;
import com.supergenius.admin.enums.EReview;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.util.Date;

@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("label")
@ApiModel(value="入演活动审核", description="")
public class VCSignupDisplayVO {
    @ApiModelProperty(value = "会员pid")
    private String pid;
    @ApiModelProperty(value = "会员姓名")
    private String name;
    @ApiModelProperty(value = "会员身份类别")
    @JsonSerialize(using = IdentitySerialize.class)
    private EIdentity kind;
    @ApiModelProperty(value = "申请时间")
    private Date applytime;
    @ApiModelProperty(value = "审核时间")
    private Date reviewtime;
    @ApiModelProperty(value = "审核状态")
    private EReview reviewstatus;
}
