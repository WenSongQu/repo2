package com.supergenius.admin.capital.model.vo;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.supergenius.admin.convert.IdentitySerialize;
import com.supergenius.admin.convert.ReviewSerialize;
import com.supergenius.admin.convert.SettledStatusSerialize;
import com.supergenius.admin.convert.UsermodeSerialize;
import com.supergenius.admin.enums.EIdentity;
import com.supergenius.admin.enums.EReview;
import com.supergenius.admin.enums.EStatus;
import com.supergenius.admin.enums.EUsermode;
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
@ApiModel(value="天才保荐人/推荐/召集 展示对象", description="")
public class VCUserinfoVo {
    @ApiModelProperty("useruid")
    private String useruid;
    @ApiModelProperty("会员号")
    private String usersn;
    @ApiModelProperty("认证编码")
    private String authcode;
    @ApiModelProperty("手机号")
    private String mobile;
    @ApiModelProperty("最高投资额")
    private BigDecimal maxinvestment;
    @ApiModelProperty("申请时间")
    private Date applytime;
    @ApiModelProperty("审核时间")
    private Date reviewtime;
    @ApiModelProperty("审核状态")
    @JsonSerialize(using = ReviewSerialize.class)
    private EReview reviewstatus;
    @JsonSerialize(using = UsermodeSerialize.class)
    @ApiModelProperty("使用状态")
    private EUsermode status;
    @JsonSerialize(using = IdentitySerialize.class)
    private EIdentity kind;
    @ApiModelProperty("会员名")
    private String name;

}
