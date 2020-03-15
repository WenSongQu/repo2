package com.supergenius.admin.capital.model.vo;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.supergenius.admin.convert.OrderStatusSerialize;
import com.supergenius.admin.convert.SettledStatusSerialize;
import com.supergenius.admin.enums.ESettledStatus;
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
@ApiModel(value="入驻企业展示", description="")
public class VCSettledDisplayVO {
    @ApiModelProperty("uid")
    private String uid;
    @ApiModelProperty("用户名")
    private String showname;
    @ApiModelProperty("孵化器名称")
    private String name;
    @ApiModelProperty("申请时间")
    private Date createtime;
    @ApiModelProperty("审核时间")
    private Date reviewtime;
    @JsonSerialize(using = SettledStatusSerialize.class)
    @ApiModelProperty("状态")
    private ESettledStatus status;
}
