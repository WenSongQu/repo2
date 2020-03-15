package com.supergenius.admin.capital.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.supergenius.admin.capital.model.VCFinancingDO;
import com.supergenius.admin.capital.mapper.VCFinancingDao;
import com.supergenius.admin.capital.service.IVCFinancingService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author zuoyu
 * @since 2019-12-04
 */
@Service
public class VCFinancingServiceImpl extends ServiceImpl<VCFinancingDao, VCFinancingDO> implements IVCFinancingService {
    @Autowired
    VCFinancingDao dao;

    @Override
    public List<VCFinancingDO> getByPid(String pid) {
        LambdaQueryWrapper<VCFinancingDO> lambda=new LambdaQueryWrapper<>();
        lambda.eq(VCFinancingDO::getPid,pid);
        List<VCFinancingDO> financingDOList = dao.selectList(lambda);
        return financingDOList;
    }
}
