package com.supergenius.admin.capital.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.supergenius.admin.capital.model.VCOrganizationDO;
import com.supergenius.admin.capital.mapper.VCOrganizationDao;
import com.supergenius.admin.capital.service.IVCOrganizationService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author zuoyu
 * @since 2019-12-04
 */
@Service
public class VCOrganizationServiceImpl extends ServiceImpl<VCOrganizationDao, VCOrganizationDO> implements IVCOrganizationService {
    @Autowired
    VCOrganizationDao vcOrganizationDao;

    @Override
    public VCOrganizationDO getOrganizationInfo(String useruid) {
        LambdaQueryWrapper<VCOrganizationDO> vcOrganizationDOLambdaQueryWrapper=new LambdaQueryWrapper<>();
        vcOrganizationDOLambdaQueryWrapper.eq(VCOrganizationDO::getUseruid,useruid);
        VCOrganizationDO vcOrganizationDO = vcOrganizationDao.selectOne(vcOrganizationDOLambdaQueryWrapper);
        return vcOrganizationDO;
    }
}
