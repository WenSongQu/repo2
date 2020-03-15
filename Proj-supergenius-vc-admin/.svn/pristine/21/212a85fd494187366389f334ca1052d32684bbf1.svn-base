package com.supergenius.admin.user.model;

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
 * 动态表
 * </p>
 *
 * @author zuoyu
 * @since 2019-12-04
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("scoredetail")
@ApiModel(value="USScoredetailDO对象", description="动态表")
public class USScoredetailDO implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "唯一ID")
    @TableId(value = "uid", type = IdType.AUTO)
    private String uid;

    @ApiModelProperty(value = "用户uid")
    @TableField("useruid")
    private String useruid;

    @ApiModelProperty(value = "变动积分")
    @TableField("score")
    private Integer score;

    @ApiModelProperty(value = "变动的站点，对应ESite枚举")
    @TableField("site")
    private Boolean site;

    @ApiModelProperty(value = "获得积分与消费积分事件uid")
    @TableField("refuid")
    private String refuid;

    @ApiModelProperty(value = "分数类型（写文章获得，转载文章获得，积分晋级）")
    @TableField("type")
    private Boolean type;

    @ApiModelProperty(value = "状态(0原创1非原创)")
    @TableField("status")
    private StatusEnum status;

    @ApiModelProperty(value = "创建时间")
    @TableField(value = "createtime", fill = FieldFill.INSERT)
    private Date createtime;

    @ApiModelProperty(value = "最后更新时间")
    @TableField("updatetime")
    private Date updatetime;


}
