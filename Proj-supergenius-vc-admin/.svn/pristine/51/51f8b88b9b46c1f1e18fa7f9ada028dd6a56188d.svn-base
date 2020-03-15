package com.supergenius.admin.user.model;

import java.math.BigDecimal;

import com.baomidou.mybatisplus.annotation.*;

import java.util.Date;
import java.io.Serializable;
import com.supergenius.admin.enums.StatusEnum;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 订单
 * </p>
 *
 * @author zuoyu
 * @since 2019-12-04
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("order")
@ApiModel(value="USOrderDO对象", description="订单")
public class USOrderDO implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "唯一ID")
    @TableId(value = "uid", type = IdType.AUTO)
    private String uid;

    @ApiModelProperty(value = "用户唯一ID")
    @TableField("useruid")
    private String useruid;

    @ApiModelProperty(value = "订单编号")
    @TableField("sn")
    private String sn;

    @ApiModelProperty(value = "订单名称")
    @TableField("name")
    private String name;

    @ApiModelProperty(value = "备忘录")
    @TableField("memo")
    private String memo;

    @ApiModelProperty(value = "订单总金额")
    @TableField("money")
    private BigDecimal money;

    @ApiModelProperty(value = "订单状态（初始化|失败|成功|未付款|已付款|取消订单|已过期|管理员退票|已删除）")
    @TableField("state")
    private Boolean state;

    @ApiModelProperty(value = "订单状态(0已删除1未删除)")
    @TableField("status")
    private StatusEnum status;

    @ApiModelProperty(value = "下单时间")
    @TableField(value = "createtime", fill = FieldFill.INSERT)
    private Date createtime;

    @ApiModelProperty(value = "最后更新时间")
    @TableField("updatetime")
    private Date updatetime;


}
