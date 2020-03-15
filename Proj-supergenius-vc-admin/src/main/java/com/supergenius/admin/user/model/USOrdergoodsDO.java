package com.supergenius.admin.user.model;

import java.math.BigDecimal;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import java.util.Date;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import java.io.Serializable;
import com.supergenius.admin.enums.StatusEnum;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 订单商品
 * </p>
 *
 * @author zuoyu
 * @since 2019-12-04
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("ordergoods")
@ApiModel(value="USOrdergoodsDO对象", description="订单商品")
public class USOrdergoodsDO implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "唯一ID")
    @TableId(value = "uid", type = IdType.AUTO)
    private String uid;

    @ApiModelProperty(value = "订单ID")
    @TableField("orderuid")
    private String orderuid;

    @ApiModelProperty(value = "用户唯一ID")
    @TableField("useruid")
    private String useruid;

    @ApiModelProperty(value = "商品的uid")
    @TableField("refuid")
    private String refuid;

    @ApiModelProperty(value = "商品编号(挑战编号|视频编号)")
    @TableField("sn")
    private String sn;

    @ApiModelProperty(value = "商品名称")
    @TableField("name")
    private String name;

    @ApiModelProperty(value = "商品类型(视频|门票|挑战)")
    @TableField("type")
    private Boolean type;

    @ApiModelProperty(value = "商品个数")
    @TableField("count")
    private Integer count;

    @ApiModelProperty(value = "单价")
    @TableField("unitprice")
    private BigDecimal unitprice;

    @ApiModelProperty(value = "总价")
    @TableField("totalprice")
    private BigDecimal totalprice;

    @ApiModelProperty(value = "状态(0禁用1启用)")
    @TableField("status")
    private StatusEnum status;

    @ApiModelProperty(value = "购买时间")
    @TableField(value = "createtime", fill = FieldFill.INSERT)
    private Date createtime;

    @ApiModelProperty(value = "最后更新时间")
    @TableField("updatetime")
    private Date updatetime;


}
