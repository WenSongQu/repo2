package com.supergenius.admin.capital.model.vo;

import com.baomidou.mybatisplus.annotation.TableField;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.supergenius.admin.convert.EIdentitySerialize;
import com.supergenius.admin.convert.EOrderSerialize;
import com.supergenius.admin.enums.EIdentity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.util.Date;

@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value = "消息展示对象", description = "")
public class VCMessageDisplayVO {
    @ApiModelProperty(value = "uid")
    private String uid;
    @ApiModelProperty(value = "发送者名称")
    private String fromname;
    @ApiModelProperty(value = "发送时间")
    private Date createtime;
    @ApiModelProperty(value = "发送到的人")
    private String toname;
    @ApiModelProperty(value = "发送的内容")
    private String content;
    @ApiModelProperty(value = "信息发送类型")
    @JsonSerialize(using = EIdentitySerialize.class)
    private EIdentity type;
}
