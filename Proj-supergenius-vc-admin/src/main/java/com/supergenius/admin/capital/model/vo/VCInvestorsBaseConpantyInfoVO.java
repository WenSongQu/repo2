package com.supergenius.admin.capital.model.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.supergenius.admin.convert.AgeSerialize;
import com.supergenius.admin.enums.EGender;
import com.supergenius.admin.enums.EIdType;
import com.supergenius.admin.enums.EIdentityType;
import com.supergenius.admin.enums.EStatus;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.math.BigDecimal;
import java.util.Date;
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value="投资者会员基本信息（公司）", description="")
public class VCInvestorsBaseConpantyInfoVO {
    @ApiModelProperty("用户名")
    private String showname;
    @ApiModelProperty("头像")
    private String avatar;
    @ApiModelProperty("用户名")
    private String businesscode;
    @ApiModelProperty("法人")
    private String corporation;
    @ApiModelProperty("身份证号")
    private String identityid;
    @ApiModelProperty("电话")
    private String phone;
    @ApiModelProperty("用户编号")
    private String usersn;
    @ApiModelProperty("开通时间")
    @JsonFormat(pattern="yyyy-MM-dd HH：mm ",timezone = "GMT+8")
    private Date createtime;
    @ApiModelProperty("关注")
    private Integer followcount;
    @ApiModelProperty("身份类型")
    private EIdentityType identity;
    @ApiModelProperty("审判状态")
    private EStatus reviewstatus;
    @ApiModelProperty("最大投资金额")
    private BigDecimal maxinvestment;
}
