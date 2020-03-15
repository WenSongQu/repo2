package com.supergenius.admin.capital.model.vo;

import com.supergenius.admin.capital.model.VCInvestmentDO;
import com.supergenius.admin.capital.model.VCOrdersDO;
import com.supergenius.admin.capital.model.VCOrganizationDO;
import com.supergenius.admin.capital.model.VCRecordDO;
import io.swagger.annotations.ApiModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.util.List;

@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value="投资者会员d-2-2", description="")
@AllArgsConstructor
@NoArgsConstructor
public class VCInvestorsmemberConpanyVO {
    private VCInvestorsBaseConpantyInfoVO2 vcInvestorsBaseConpantyInfoVO2;
    private VCOrganizationDO vcOrganizationDO;
    private VCInvestmentDO vcInvestmentDO;
//    private List<VCOrdersDO> vcOrdersDOS ;
//    //投资纪录
//    private List<VCRecordDO> investmentRecord;
//    //召集记录
//    private List<VCRecordDO> conveneRecord ;
//    //推荐记录
//    private List<VCRecordDO> ecomrmendedRecord;
//    //保推记录
//    private List<VCRecordDO> gnvestmentRecord;
}
