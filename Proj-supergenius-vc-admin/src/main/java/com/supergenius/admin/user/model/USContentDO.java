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
 * 内容表
 * </p>
 *
 * @author zuoyu
 * @since 2019-12-04
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("content")
@ApiModel(value="USContentDO对象", description="内容表")
public class USContentDO implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "唯一uid")
    @TableId(value = "uid", type = IdType.AUTO)
    private String uid;

    @ApiModelProperty(value = "名字")
    @TableField("name")
    private String name;

    @ApiModelProperty(value = "类型")
    @TableField("type")
    private Boolean type;

    @ApiModelProperty(value = "标题")
    @TableField("title")
    private String title;

    @ApiModelProperty(value = "短标题")
    @TableField("titleshort")
    private String titleshort;

    @ApiModelProperty(value = "简介")
    @TableField("summary")
    private String summary;

    @ApiModelProperty(value = "内容")
    @TableField("content")
    private String content;

    @ApiModelProperty(value = "以json的方式记录")
    @TableField("data")
    private String data;

    @ApiModelProperty(value = "标题图片")
    @TableField("imgtitle")
    private String imgtitle;

    @ApiModelProperty(value = "小图")
    @TableField("imglittle")
    private String imglittle;

    @ApiModelProperty(value = "中图")
    @TableField("imgmedium")
    private String imgmedium;

    @ApiModelProperty(value = "大图")
    @TableField("imgbig")
    private String imgbig;

    @ApiModelProperty(value = "原图")
    @TableField("imgoriginal")
    private String imgoriginal;

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
