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
public class VCEnterpreneurmemberCompanyInfoVO {
    @ApiModelProperty("基本信息")
    private VCEnterpreneurmemberBaseCompanyVO vcEnterpreneurmemberBaseCompanyVO;
    @ApiModelProperty("融资记录")
    private List<VCEnterpreneurmemberFinancingVO> vcEnterpreneurmemberFinancingVOS;
    @ApiModelProperty("订单记录")
    private   List<VCEnterpreneurmemberOrderVO> vcEnterpreneurmemberOrderVOS;
}
