package com.supergenius.admin.capital.model.vo;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
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
@ApiModel(value="路演活动审核筛选条件", description="")
public class VCFiltrateSignupVO {
    @ApiModelProperty(value = "会员身份姓名")
    private String name;
    @ApiModelProperty(value = "会员身份类别")
    private EIdentity kind;
    @ApiModelProperty(value = "审核状态")
    private EReview reviewstatus;
}
