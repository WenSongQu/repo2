package com.supergenius.admin.capital.model.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.util.Date;

@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value="入驻企业条件过滤", description="")
public class VCFiltrateSettledVO {
    @ApiModelProperty("公司名称")
    private String cname;
    @ApiModelProperty("孵化器uid")
    private String iuid;
    @ApiModelProperty("所属行业")
    private String field;
    @ApiModelProperty("状态")
    private Integer statue;
    @ApiModelProperty("开始申请时见")
    private Date applystarttime;
    @ApiModelProperty("最晚申请时间")
    private Date applyendtime;
    @ApiModelProperty("最早审核时间")
    private Date reviewstarttime;
    @ApiModelProperty("最晚审核时间")
    private Date reviewendtime;
    @ApiModelProperty("企业状态")
    private String situation;
    @ApiModelProperty("企业状态备注")
    private String remark;

}
