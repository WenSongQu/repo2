package com.supergenius.admin.capital.model.vo;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.supergenius.admin.capital.model.VCSignupDO;
import com.supergenius.admin.capital.model.VCTrainactivityDO;
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
@ApiModel(value = "入演活动审核", description = "")
@AllArgsConstructor
@NoArgsConstructor
public class VCSignupInfoVO {
    //    personalstartup(1),//个人创业者
//    enterprisestartup(2),//企业创业者
//    personalinvestment(3),//个人投资者
//    mechanisminvestment(4);//机构投资者
    @ApiModelProperty(value = "个人创业者数量")
    private Integer enterprisestartupCount;
    @ApiModelProperty(value = "个人投资者")
    private Integer personalinvestmentCount;
    @ApiModelProperty(value = "个人创业者数量")
    private Integer mechanisminvestmentCount;
    @ApiModelProperty(value = "人员名单")
    private IPage<VCSignupDisplayVO> page;
    @ApiModelProperty(value = "路演信息信息")
    private VCTrainactivityDO trainactivity;

}
