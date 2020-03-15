package com.supergenius.admin.capital.model;

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
 * 
 * </p>
 *
 * @author zuoyu
 * @since 2019-12-04
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("meeting")
@ApiModel(value="VCMeetingDO对象", description="")
public class VCMeetingDO implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "主键")
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @ApiModelProperty(value = "唯一uid")
    @TableField(value = "uid", fill = FieldFill.INSERT)
    private String uid;

    @ApiModelProperty(value = "名字")
    @TableField("name")
    private String name;

    @ApiModelProperty(value = "图片")
    @TableField("images")
    private String images;

    @ApiModelProperty(value = "区域标签")
    @TableField("tag")
    private String tag;

    @ApiModelProperty(value = "详细地址")
    @TableField("address")
    private String address;

    @ApiModelProperty(value = "面积")
    @TableField("area")
    private Integer area;

    @ApiModelProperty(value = "价格（元/小时）")
    @TableField("price")
    private BigDecimal price;

    @ApiModelProperty(value = "会议室可容纳人数（座位数）")
    @TableField("number")
    private Integer number;

    @ApiModelProperty(value = "会议室使用时间（全年|法定节假日...）")
    @TableField("opentime")
    private Boolean opentime;

    @ApiModelProperty(value = "预约的开始时间")
    @TableField("starttime")
    private Date starttime;

    @ApiModelProperty(value = "预约的结束时间")
    @TableField("overtime")
    private Date overtime;

    @ApiModelProperty(value = "上线时间")
    @TableField("showtime")
    private Date showtime;

    @ApiModelProperty(value = "盈利即总金额")
    @TableField("summoney")
    private BigDecimal summoney;

    @ApiModelProperty(value = "盈利即总金额")
    @TableField("timeinterval")
    private Integer timeinterval;

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
