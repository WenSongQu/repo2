package com.supergenius.admin.capital.model.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value="站内信息过滤类", description="")
public class VCFiltrateMessageVO {
    @ApiModelProperty("发布人员")
    private String sendName;
    @ApiModelProperty("关键字")
    private String keyWord;
    @ApiModelProperty("开始时间")
    private String startTime;
    @ApiModelProperty("结束时间")
    private String endTime;
    @ApiModelProperty("是否按时间排序，默认升序 降序为order 升序=null即可")
    private String order;

}
