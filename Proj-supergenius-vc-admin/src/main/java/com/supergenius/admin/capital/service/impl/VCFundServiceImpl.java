package com.supergenius.admin.capital.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.supergenius.admin.capital.model.VCFundDO;
import com.supergenius.admin.capital.mapper.VCFundDao;
import com.supergenius.admin.capital.service.IVCFundService;
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
public class VCFundServiceImpl extends ServiceImpl<VCFundDao, VCFundDO> implements IVCFundService {
    @Autowired
    VCFundDao vcFundDao;


    @Override
    public List<VCFundDO> getFundsById(String useruid) {
        LambdaQueryWrapper<VCFundDO> lambda=new LambdaQueryWrapper<>();
        lambda.eq(VCFundDO::getUseruid,useruid);
        List<VCFundDO> list = vcFundDao.selectList(lambda);
        return list;
    }
}
