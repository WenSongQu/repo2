package com.supergenius.admin.capital.model;

import java.math.BigDecimal;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import java.util.Date;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import java.io.Serializable;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.supergenius.admin.convert.CapitalTypeSerialize;
import com.supergenius.admin.convert.FormSerialize;
import com.supergenius.admin.convert.IdentitySerialize;
import com.supergenius.admin.enums.ECapitalType;
import com.supergenius.admin.enums.EForm;
import com.supergenius.admin.enums.StatusEnum;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 
 * </p>
 *
 * @author zuoyu
 * @since 2019-12-04
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("organization")
@ApiModel(value="VCOrganizationDO对象", description="")
public class VCOrganizationDO implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "主键")
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @ApiModelProperty(value = "用户唯一uid")
    @TableField("useruid")
    private String useruid;

    @ApiModelProperty(value = "机构成立时间")
    @TableField("buildtime")
    private Date buildtime;

    @ApiModelProperty(value = "币种类型")
    @TableField("currencytype")
    private Boolean currencytype;

    @ApiModelProperty(value = "机构规模")
    @TableField("amount")
    private BigDecimal amount;

    @JsonSerialize(using = CapitalTypeSerialize.class)
    @ApiModelProperty(value = "资本类型")
    @TableField("capitaltype")
    private ECapitalType capitaltype;

    @JsonSerialize(using = FormSerialize.class)
    @ApiModelProperty(value = "组织形式")
    @TableField("form")
    private EForm form;

    @ApiModelProperty(value = "状态")
    @TableField("status")
    private StatusEnum status;

    @ApiModelProperty(value = "备用字段")
    @TableField("data")
    private String data;

    @ApiModelProperty(value = "创建时间")
    @TableField(value = "createtime", fill = FieldFill.INSERT)
    private Date createtime;

    @ApiModelProperty(value = "最后更新时间")
    @TableField("updatetime")
    private Date updatetime;


}
