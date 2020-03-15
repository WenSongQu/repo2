package com.supergenius.admin.capital.model.vo;

import com.supergenius.admin.capital.model.VCFinancingDO;
import com.supergenius.admin.capital.model.VCTeamDO;
import com.supergenius.admin.enums.EStage;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value="项目介绍", description="")
public class VCProjectIntroductionVO {
    @ApiModelProperty(value = "项目概述")
    private String overview;
    @ApiModelProperty(value = "市场分析")
    private String analysis;
    @ApiModelProperty(value = "盈利模式")
    private String profit;
    @ApiModelProperty(value = "前景分析")
    private String prospect;
    @ApiModelProperty(value = "团队")
    private List<VCTeamDO> teams;
    @ApiModelProperty(value = "融资记录")
    private List<VCFinancingDO> financingDOList;
    @ApiModelProperty(value = "项目阶段")
    private EStage stage;
    @ApiModelProperty(value = "项目展示")
    private String projectdisplay;
}
