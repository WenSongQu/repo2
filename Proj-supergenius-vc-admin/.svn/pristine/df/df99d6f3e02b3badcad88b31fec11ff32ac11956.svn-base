package com.supergenius.admin.capital.model.vo;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.supergenius.admin.convert.SettledStatusSerialize;
import com.supergenius.admin.enums.ESettledStatus;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.models.auth.In;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.math.BigDecimal;
import java.util.Date;

@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value="入驻企业详细信息", description="")
public class VCSettledInfoVO {
    @ApiModelProperty("用户名")
    private String showname;
    @ApiModelProperty("孵化器名称")
    private String name;
    @ApiModelProperty("申请时间")
    private Date createtime;
    @ApiModelProperty("所属行业")
    private String field;
    @ApiModelProperty("人员数量")
    private Integer peoplenumber;
    @ApiModelProperty("估值")
    private BigDecimal amount;
    @ApiModelProperty("入驻时间")
    private Date time;
    @ApiModelProperty("面积")
    private Integer area;
    @ApiModelProperty("工作数量")
    private Integer worknumber;
    @ApiModelProperty("联系电话")
    private String mobile;
    @ApiModelProperty("邮箱")
    private String email;
    @ApiModelProperty("状态")
    @JsonSerialize(using = SettledStatusSerialize.class)
    private ESettledStatus status;
    @ApiModelProperty("企业状态")
    private String situation;
    @ApiModelProperty("企业状态备注")
    private String remark;
    @ApiModelProperty("审核时间")
    private Date reviewtime;


}
