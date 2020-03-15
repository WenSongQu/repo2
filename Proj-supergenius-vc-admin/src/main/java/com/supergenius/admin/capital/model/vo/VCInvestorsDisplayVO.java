package com.supergenius.admin.capital.model.vo;

import com.supergenius.admin.enums.EIdentity;
import com.supergenius.admin.enums.EStatus;
import io.swagger.annotations.ApiModel;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.util.Date;

@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value="投资者会员d-2", description="")
public class VCInvestorsDisplayVO {
    private String useruid;
    private String usersn;
    private String corporation;
    private String avatarlittle;
    private String phone;
    private EIdentity kind;
    private Date createtime;
    private Integer followcount;
    private EStatus status;
}
