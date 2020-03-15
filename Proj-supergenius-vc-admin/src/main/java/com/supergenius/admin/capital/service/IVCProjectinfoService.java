package com.supergenius.admin.capital.service;

import com.supergenius.admin.capital.model.VCProjectinfoDO;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author zuoyu
 * @since 2019-12-04
 */
public interface IVCProjectinfoService extends IService<VCProjectinfoDO> {
    VCProjectinfoDO getByPid(String uid);

}
