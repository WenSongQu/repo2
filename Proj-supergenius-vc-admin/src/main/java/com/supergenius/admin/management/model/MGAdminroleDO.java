package com.supergenius.admin.management.model;

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
@TableName("adminrole")
@ApiModel(value="MGAdminroleDO对象", description="")
public class MGAdminroleDO implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "唯一ID")
    @TableId(value = "uid", type = IdType.AUTO)
    private String uid;

    @ApiModelProperty(value = "管理员UID")
    @TableField("adminuid")
    private String adminuid;

    @ApiModelProperty(value = "管理员ID")
    @TableField("adminid")
    private String adminid;

    @ApiModelProperty(value = "权限")
    @TableField("roleid")
    private String roleid;

    @ApiModelProperty(value = "权限名")
    @TableField("rolename")
    private String rolename;

    @ApiModelProperty(value = "描述")
    @TableField("desc")
    private String desc;

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
