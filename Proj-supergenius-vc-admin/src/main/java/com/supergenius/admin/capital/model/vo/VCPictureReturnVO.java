package com.supergenius.admin.capital.model.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value="轮播图图片上传返回服务器地址地址", description="")
public class VCPictureReturnVO {
    @ApiModelProperty("大图")
    private String ImaBig;
    @ApiModelProperty("中图")
    private String imgMedium;
    @ApiModelProperty("小图")
    private String imgLittle;
    @ApiModelProperty("原图")
    private String imgOriginal;
}
