package com.supergenius.admin.capital.model.vo;

import io.swagger.annotations.ApiModelProperty;

public class VCFinancingRecordVO {
    @ApiModelProperty(value = "举报者")
    private String username;
    @ApiModelProperty(value = "被举报者")
    private String toname;
    @ApiModelProperty(value = "举报标签uid")
    private String labeluid;
    @ApiModelProperty(value = "结果")
    private Integer result;
    @ApiModelProperty(value = "举报最早开始时间")
    private String starttime;
    @ApiModelProperty(value = "举报最晚开始时间")
    private String endtime;
    @ApiModelProperty(value = "被举报者状态")
    private Integer tostatus;
    @ApiModelProperty("是否按时间排序，默认升序 降序为order 升序=null即可")
    private String order;

}
