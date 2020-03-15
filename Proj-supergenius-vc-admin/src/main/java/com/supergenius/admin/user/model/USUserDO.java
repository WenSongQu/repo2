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
 * 用户表
 * </p>
 *
 * @author zuoyu
 * @since 2019-12-04
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("user")
@ApiModel(value="USUserDO对象", description="用户表")
public class USUserDO implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "oid", type = IdType.AUTO)
    private Integer oid;

    @ApiModelProperty(value = "唯一uid")
    @TableField(value = "uid", fill = FieldFill.INSERT)
    private String uid;

    @ApiModelProperty(value = "会员号")
    @TableField("usersn")
    private String usersn;

    @TableField("email")
    private String email;

    @ApiModelProperty(value = "新邮箱")
    @TableField("newemail")
    private String newemail;

    @ApiModelProperty(value = "电话")
    @TableField("phone")
    private String phone;

    @ApiModelProperty(value = "第三方身份id")
    @TableField("openid")
    private String openid;

    @ApiModelProperty(value = "手机")
    @TableField("mobile")
    private String mobile;

    @ApiModelProperty(value = "邮箱验证码")
    @TableField("validcode")
    private String validcode;

    @TableField("password")
    private String password;

    @ApiModelProperty(value = "支付密码")
    @TableField("paypwd")
    private String paypwd;

    @ApiModelProperty(value = "重置密码VALUE")
    @TableField("resetpwd")
    private String resetpwd;

    @ApiModelProperty(value = "账户余额")
    @TableField("account")
    private BigDecimal account;

    @ApiModelProperty(value = "冻结金额")
    @TableField("freezeaccount")
    private BigDecimal freezeaccount;

    @ApiModelProperty(value = "累计支出")
    @TableField("totalpay")
    private BigDecimal totalpay;

    @ApiModelProperty(value = "累计收入")
    @TableField("totalincome")
    private BigDecimal totalincome;

    @ApiModelProperty(value = "用户类别，如会员、学员、裁判、专家等")
    @TableField("type")
    private Integer type;

    @ApiModelProperty(value = "来自渠道(缴费|特批|邀请)")
    @TableField("channelfrom")
    private Boolean channelfrom;

    @ApiModelProperty(value = "最后登录设备")
    @TableField("channelid")
    private String channelid;

    @ApiModelProperty(value = "登录次数")
    @TableField("logincount")
    private Integer logincount;

    @ApiModelProperty(value = "最后登录时间")
    @TableField("lastlogintime")
    private Date lastlogintime;

    @ApiModelProperty(value = "最后登录IP")
    @TableField("lastloginip")
    private String lastloginip;

    @ApiModelProperty(value = "存放其他状态信息")
    @TableField("data")
    private String data;

    @ApiModelProperty(value = "状态")
    @TableField("status")
    private StatusEnum status;

    @ApiModelProperty(value = "开户时间")
    @TableField(value = "createtime", fill = FieldFill.INSERT)
    private Date createtime;

    @ApiModelProperty(value = "最后更新时间")
    @TableField("updatetime")
    private Date updatetime;


}
