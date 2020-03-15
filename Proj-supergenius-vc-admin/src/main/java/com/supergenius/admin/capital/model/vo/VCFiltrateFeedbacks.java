package com.supergenius.admin.capital.model.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value="举报投资人的过滤条件", description="")
public class VCFiltrateFeedbacks {
    @ApiModelProperty(value = "举报者")
    private String username;
    @ApiModelProperty(value = "被举报这")
    private String  toname;
    @ApiModelProperty(value = "举报标签")
    private String  reason;
    @ApiModelProperty(value = "结果")
    private Integer result;
    @ApiModelProperty(value = "最早举报时间")
    private String startTime;
    @ApiModelProperty(value = "最晚举报时间")
    private String endTime;
    @ApiModelProperty(value = "举报者状态")
    private Integer tostatus;
    @ApiModelProperty(value = "复审状态")
    private Integer secondreview;
    @ApiModelProperty("是否按时间排序，默认升序 降序为order 升序=null即可")
    private String order;
}
//      m2.`m2name` like CONCAT('%',#{map.sendName},'%') and
//<if test="map.order != null and map.endTime!='' ">ORDER BY createtime ${map.order}</if>
