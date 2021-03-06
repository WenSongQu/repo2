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
 * 交易明细
 * </p>
 *
 * @author zuoyu
 * @since 2019-12-04
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("tradedetail")
@ApiModel(value="USTradedetailDO对象", description="交易明细")
public class USTradedetailDO implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "唯一ID")
    @TableId(value = "uid", type = IdType.AUTO)
    private String uid;

    @ApiModelProperty(value = "用户uid")
    @TableField("useruid")
    private String useruid;

    @ApiModelProperty(value = "交易事件uid(pk|申请答辩)")
    @TableField("tradeeventuid")
    private String tradeeventuid;

    @ApiModelProperty(value = "金额")
    @TableField("money")
    private BigDecimal money;

    @ApiModelProperty(value = "余额")
    @TableField("accountcurr")
    private BigDecimal accountcurr;

    @ApiModelProperty(value = "流水号")
    @TableField("sn")
    private String sn;

    @ApiModelProperty(value = "订单Uid")
    @TableField("orderuid")
    private String orderuid;

    @ApiModelProperty(value = "交易类型(充值、视频收入、扣除挑战费、作为裁判奖励、购买视频、购买门票、购买道具、取消门票、管理员退票、申请答辩、冻结挑战费用、解冻挑战费用、挑战获胜奖励、特批增加金额、特批减少金额)")
    @TableField("type")
    private Boolean type;

    @ApiModelProperty(value = "操作名称(扣除挑战费、作为裁判奖励、购买视频、购买门票、购买道具、取消门票、管理员退票、申请答辩、冻结挑战费用、解冻挑战费用、挑战获胜奖励、特批增加金额、特批减少金额)")
    @TableField("name")
    private String name;

    @ApiModelProperty(value = "交易来源的平台")
    @TableField("site")
    private Boolean site;

    @ApiModelProperty(value = "成功时间")
    @TableField("successtime")
    private Date successtime;

    @ApiModelProperty(value = "失败时间")
    @TableField("failedtime")
    private Date failedtime;

    @ApiModelProperty(value = "备注")
    @TableField("memo")
    private String memo;

    @ApiModelProperty(value = "状态(0禁用1启用)")
    @TableField("status")
    private StatusEnum status;

    @ApiModelProperty(value = "创建时间")
    @TableField(value = "createtime", fill = FieldFill.INSERT)
    private Date createtime;

    @ApiModelProperty(value = "最后更新时间")
    @TableField("updatetime")
    private Date updatetime;


}
