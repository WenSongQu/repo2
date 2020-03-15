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
 * 消息表
 * </p>
 *
 * @author zuoyu
 * @since 2019-12-04
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("news")
@ApiModel(value="USNewsDO对象", description="消息表")
public class USNewsDO implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "唯一ID")
    @TableId(value = "uid", type = IdType.AUTO)
    private String uid;

    @ApiModelProperty(value = "发送者id")
    @TableField("fromuid")
    private String fromuid;

    @ApiModelProperty(value = "接收者id")
    @TableField("touid")
    private String touid;

    @ApiModelProperty(value = "标题")
    @TableField("title")
    private String title;

    @ApiModelProperty(value = "内容")
    @TableField("content")
    private String content;

    @ApiModelProperty(value = "链接地址")
    @TableField("href")
    private String href;

    @ApiModelProperty(value = "消息类型")
    @TableField("type")
    private Boolean type;

    @ApiModelProperty(value = "消息状态(0未读1已读)")
    @TableField("isread")
    private Boolean isread;

    @ApiModelProperty(value = "状态(0禁用1启用)")
    @TableField("status")
    private StatusEnum status;

    @ApiModelProperty(value = "创建时间")
    @TableField(value = "createtime", fill = FieldFill.INSERT)
    private Date createtime;

    @ApiModelProperty(value = "最后更新时间")
    @TableField( value = "updatetime")
    private Date updatetime;


}
