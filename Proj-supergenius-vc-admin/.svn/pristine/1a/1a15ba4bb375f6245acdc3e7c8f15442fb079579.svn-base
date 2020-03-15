package com.supergenius.admin.management.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.supergenius.admin.management.mapper.MGAdminroleDao;
import com.supergenius.admin.management.model.MGAdminroleDO;
import com.supergenius.admin.management.service.IMGAdminroleService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author zuoyu
 * @since 2019-12-04
 */
@Service
public class MGAdminroleServiceImpl extends ServiceImpl<MGAdminroleDao, MGAdminroleDO> implements IMGAdminroleService {


    private final MGAdminroleDao adminroleDao;

    public MGAdminroleServiceImpl(MGAdminroleDao adminroleDao) {
        this.adminroleDao = adminroleDao;
    }

    @Override
    public List<String> getAuthoritiesByAdminUid(String adminId) {
        return adminroleDao.getAuthoritiesByAdminUid(adminId);
    }
}
