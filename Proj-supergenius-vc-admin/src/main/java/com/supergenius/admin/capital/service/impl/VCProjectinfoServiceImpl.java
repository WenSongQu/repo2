package com.supergenius.admin.capital.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.supergenius.admin.capital.model.VCProjectinfoDO;
import com.supergenius.admin.capital.mapper.VCProjectinfoDao;
import com.supergenius.admin.capital.service.IVCProjectinfoService;
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
public class VCProjectinfoServiceImpl extends ServiceImpl<VCProjectinfoDao, VCProjectinfoDO> implements IVCProjectinfoService {
    @Autowired
    VCProjectinfoDao vcProjectinfoDao;

    @Override
    public VCProjectinfoDO getByPid(String uid) {
        LambdaQueryWrapper<VCProjectinfoDO> lambda=new LambdaQueryWrapper<>();
        lambda.eq(VCProjectinfoDO::getPid,uid);
        VCProjectinfoDO vcProjectinfoDO = vcProjectinfoDao.selectOne(lambda);
        return vcProjectinfoDO;
    }
}
