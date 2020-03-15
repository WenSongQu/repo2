package com.supergenius.admin.capital.service;

import com.supergenius.admin.capital.model.VCUserinfoDO;
import com.baomidou.mybatisplus.extension.service.IService;
import com.supergenius.admin.enums.EIdentityType;
import com.supergenius.admin.enums.EReview;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author zuoyu
 * @since 2019-12-04
 */
public interface IVCUserinfoService extends IService<VCUserinfoDO> {
    //审核通过
    void auditSuccess(List<String> uids, EIdentityType type);
    //审核失败
    void auditFailed(List<String> uids, EIdentityType type);
    //启用
     void auditStart(List<String> uids, EIdentityType type);
     //禁用
     void auditBan(List<String> uids, EIdentityType type);

}
