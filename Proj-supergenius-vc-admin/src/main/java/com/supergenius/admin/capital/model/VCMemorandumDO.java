package com.supergenius.admin.capital.model;

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
@TableName("memorandum")
@ApiModel(value="VCMemorandumDO对象", description="")
public class VCMemorandumDO implements Serializable {

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

    @ApiModelProperty(value = "内容")
    @TableField("content")
    private String content;

    @ApiModelProperty(value = "时间")
    @TableField("time")
    private Date time;

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
