package com.supergenius.admin.capital.model.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.supergenius.admin.convert.AgeSerialize;
import com.supergenius.admin.enums.EGender;
import com.supergenius.admin.enums.EIdType;
import com.supergenius.admin.enums.EStatus;
import io.swagger.annotations.ApiModel;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.util.Date;

@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value="投资者会员基本信息（个人）", description="")
public class VCInvestorsBasePersonInfoVO {
    private String showname;
    private String avatar;
    private EGender gender;
    @JsonSerialize(using = AgeSerialize.class)
    private Date birthday;
    private EIdType idtype;
    private String identityid;
    private String phone;
    private String usersn;
    @JsonFormat(pattern="yyyy-MM-dd HH：mm ",timezone = "GMT+8")
    private Date createtime;
    private String idcardimglittle;
    private EStatus reviewstatus;
    private Integer followcount;
}
