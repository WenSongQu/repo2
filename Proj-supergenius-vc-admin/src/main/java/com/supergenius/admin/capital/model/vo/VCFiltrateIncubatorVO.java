package com.supergenius.admin.capital.model.vo;

import com.sun.xml.internal.ws.spi.db.DatabindingException;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.util.Date;

@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value="孵化器过滤对象", description="")
public class VCFiltrateIncubatorVO {
    @ApiModelProperty("孵化器名称")
    private String name;
    @ApiModelProperty("所属地区")
    private String tag;
    @ApiModelProperty("最早上线时间")
    private Date beginshowtime;
    @ApiModelProperty("最晚上线时间")
    private Date lateshowtime;
    @ApiModelProperty("状态")
    private Integer status;
    @ApiModelProperty("最大入驻企业数量")
    private Integer maxcompanycount;
    @ApiModelProperty("最小入驻企业数量")
    private Integer mincompanycount;
}
