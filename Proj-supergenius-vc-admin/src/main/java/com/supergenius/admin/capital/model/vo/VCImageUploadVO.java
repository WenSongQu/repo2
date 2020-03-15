package com.supergenius.admin.capital.model.vo;

import com.supergenius.admin.enums.EUpload;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value="图片上传返回值", description="")
@AllArgsConstructor
@NoArgsConstructor
public class VCImageUploadVO {
    @ApiModelProperty(value = "状态")
    private EUpload status;
    @ApiModelProperty(value = "地址")
    private String path;
}
