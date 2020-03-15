package com.supergenius.admin.capital.model.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.supergenius.admin.convert.AgeSerialize;
import com.supergenius.admin.convert.SiteSerialize;
import com.supergenius.admin.enums.EGender;
import com.supergenius.admin.enums.EIdType;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.util.Date;
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value="创业者会员基本信息（个人）", description="")
public class VCEnterpreneurmemberBasePersonVO {
    @ApiModelProperty("用户名")
    private String showname;
    @ApiModelProperty("头像")
    private String avatar;
    @ApiModelProperty("性别")
    private EGender  gender;
   // @ApiModelProperty("证件编码")
    @JsonSerialize(using = AgeSerialize.class)
    private Date birthday;
    private EIdType  idtype;
    @ApiModelProperty("身份证号码")
    private String identityid;
    @ApiModelProperty("电话")
    private String phone;
    @ApiModelProperty("会员号")
    private String usersn;
    @ApiModelProperty("开通时间")
    @JsonFormat(pattern="yyyy-MM-dd HH：mm ",timezone = "GMT+8")
    private Date createtime;
    private String idcardimglittle;
}
