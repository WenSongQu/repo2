package com.supergenius.admin.capital.model.vo;

import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value="举报消息列表条件过滤", description="")
public class VCFiltrateFeedbacksMessageVO {
    @ApiModelProperty(value = "举报者")
    private String username;
    @ApiModelProperty(value = "被举报者")
    private String toname;
    @ApiModelProperty(value = "举报标签uid")
    private String labeluid;
    @ApiModelProperty(value = "结果")
    private Integer result;
    @ApiModelProperty(value = "被举报者最少冻结次数")
    private Integer minfreezedcount;
    @ApiModelProperty(value = "被举报者最多冻结次数")
    private Integer maxfreezdcount;
    @ApiModelProperty(value = "举报最早开始时间")
    private String starttime;
    @ApiModelProperty(value = "举报最晚开始时间")
    private String endtime;
    @ApiModelProperty(value = "被举报者状态")
    private Integer tostatus;
    @ApiModelProperty("是否按时间排序，默认升序 降序为order 升序=null即可")
    private String order;
}
