package com.supergenius.admin.capital.service;

import com.supergenius.admin.capital.model.VCOrganizationDO;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author zuoyu
 * @since 2019-12-04
 */
public interface IVCOrganizationService extends IService<VCOrganizationDO> {
    VCOrganizationDO getOrganizationInfo(String useruid);

}
