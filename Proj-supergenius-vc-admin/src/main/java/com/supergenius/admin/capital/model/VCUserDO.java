package com.supergenius.admin.capital.model;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import java.util.Date;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import java.io.Serializable;

import com.supergenius.admin.enums.EIdentity;
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
@TableName("user")
@ApiModel(value="VCUserDO对象", description="")
public class VCUserDO implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "主键")
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @ApiModelProperty(value = "用户唯一uid")
    @TableField("useruid")
    private String useruid;

    @ApiModelProperty(value = "证件照的照片")
    @TableField("idcardimg")
    private String idcardimg;

    @ApiModelProperty(value = "证件照的大照片")
    @TableField("idcardimgbig")
    private String idcardimgbig;

    @ApiModelProperty(value = "证件照的中照片")
    @TableField("idcardimgmedium")
    private String idcardimgmedium;

    @ApiModelProperty(value = "证件照的小照片")
    @TableField("idcardimglittle")
    private String idcardimglittle;

    @ApiModelProperty(value = "企业工商代码")
    @TableField("businesscode")
    private String businesscode;

    @ApiModelProperty(value = "法人姓名")
    @TableField("corporation")
    private String corporation;

    @ApiModelProperty(value = "会员身份类别")
    @TableField("kind")
    private EIdentity kind;

    @ApiModelProperty(value = "成功融资次数")
    @TableField("financingcount")
    private Integer financingcount;

    @ApiModelProperty(value = "关注量")
    @TableField("followcount")
    private Integer followcount;

    @ApiModelProperty(value = "冻结次数")
    @TableField("freezecount")
    private Integer freezecount;

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
