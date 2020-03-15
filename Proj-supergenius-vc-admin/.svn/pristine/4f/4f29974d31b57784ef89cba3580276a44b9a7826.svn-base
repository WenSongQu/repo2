package com.supergenius.admin.capital.model.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.util.List;

@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value="创业这会员具体信息（个人）", description="")
@AllArgsConstructor
@NoArgsConstructor
public class VCEnterpreneurmemberInfoPersonVO {
    @ApiModelProperty("创业者基本信息")
    private VCEnterpreneurmemberBasePersonVO vcEnterpreneurmemberBasePersonVO;
    @ApiModelProperty("创业者融资记录")
    private List<VCEnterpreneurmemberFinancingVO> vcEnterpreneurmemberFinancingVOS;
    @ApiModelProperty("创业者订单记录")
    private  List<VCEnterpreneurmemberOrderVO> vcEnterpreneurmemberOrderVOS;
}
