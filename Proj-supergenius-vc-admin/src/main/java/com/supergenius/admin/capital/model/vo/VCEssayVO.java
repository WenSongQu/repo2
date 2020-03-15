package com.supergenius.admin.capital.model.vo;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.util.Date;

@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value="动态展示", description="")
public class VCEssayVO {
    @ApiModelProperty(value = "uid")
    private String uid;
    @ApiModelProperty(value = "小图")
    private String img;
    @ApiModelProperty(value = "中图")
    private String imgmedium ;
    @ApiModelProperty(value = "大图")
    private String imgbig ;
    @ApiModelProperty(value = "原图")
    private String imgoriginal ;
    @ApiModelProperty(value = "内容")
    private String content;
    @ApiModelProperty(value = "用户名")
    private String uname;
    @ApiModelProperty(value = "头像")
    private String avatar;
    @ApiModelProperty(value = "创建时间")
    private Date createtime;
    @ApiModelProperty(value = "点赞数")
    private Integer likenum;
    @ApiModelProperty(value = "评论数")
    private Integer  commentnum;
}
