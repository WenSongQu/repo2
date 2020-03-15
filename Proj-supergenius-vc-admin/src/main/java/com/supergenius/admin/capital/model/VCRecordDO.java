package com.supergenius.admin.capital.model;

import java.math.BigDecimal;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import java.util.Date;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import java.io.Serializable;

import com.supergenius.admin.enums.ECurrencyType;
import com.supergenius.admin.enums.ERecordType;
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
@TableName("record")
@ApiModel(value="VCRecordDO对象", description="")
public class VCRecordDO implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "主键")
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @ApiModelProperty(value = "唯一uid")
    @TableField(value = "uid", fill = FieldFill.INSERT)
    private String uid;

    @ApiModelProperty(value = "用户唯一uid")
    @TableField("useruid")
    private String useruid;

    @ApiModelProperty(value = "项目名称")
    @TableField("name")
    private String name;

    @ApiModelProperty(value = "轮次")
    @TableField("rounds")
    private Long rounds;

    @ApiModelProperty(value = "币种")
    @TableField("currencytype")
    private ECurrencyType currencytype;

    @ApiModelProperty(value = "金额")
    @TableField("amount")
    private BigDecimal amount;

    @ApiModelProperty(value = "投资日期")
    @TableField("time")
    private Date time;

    @ApiModelProperty(value = "记录类型")
    @TableField("type")
    private ERecordType type;

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
