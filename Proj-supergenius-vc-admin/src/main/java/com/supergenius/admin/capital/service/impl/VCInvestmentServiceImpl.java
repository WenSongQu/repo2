package com.supergenius.admin.capital.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.supergenius.admin.capital.model.VCInvestmentDO;
import com.supergenius.admin.capital.mapper.VCInvestmentDao;
import com.supergenius.admin.capital.model.VCInvoiceDO;
import com.supergenius.admin.capital.service.IVCInvestmentService;
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
public class VCInvestmentServiceImpl extends ServiceImpl<VCInvestmentDao, VCInvestmentDO> implements IVCInvestmentService {
    @Autowired
    VCInvestmentDao vcInvestmentDao;

    //获取投机意向
    @Override
    public VCInvestmentDO getInvestmentInfo(String uid) {
        QueryWrapper<VCInvestmentDO>  wrapper=new QueryWrapper<>();
        wrapper.eq("useruid",uid);
        return vcInvestmentDao.selectOne(wrapper);
    }
}
