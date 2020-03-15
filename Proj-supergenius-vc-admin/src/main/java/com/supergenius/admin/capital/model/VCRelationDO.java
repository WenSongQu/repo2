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
@TableName("relation")
@ApiModel(value="VCRelationDO对象", description="")
public class VCRelationDO implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "主键")
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @ApiModelProperty(value = "用户唯一uid")
    @TableField("useruid")
    private String useruid;

    @ApiModelProperty(value = "关注人：Map<(人)+id,时间戳>")
    @TableField("followperson")
    private String followperson;

    @ApiModelProperty(value = "关注项目：Map<(项目)+id,时间戳>")
    @TableField("followproject")
    private String followproject;

    @ApiModelProperty(value = "置顶人的唯一uid")
    @TableField("top")
    private String top;

    @ApiModelProperty(value = "黑名单：Map<uid,时间戳>")
    @TableField("black")
    private String black;

    @ApiModelProperty(value = "备注：Map<uid,备注名>")
    @TableField("remark")
    private String remark;

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
