package com.supergenius.admin.capital.service.impl;

import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.supergenius.admin.capital.model.VCSettledDO;
import com.supergenius.admin.capital.mapper.VCSettledDao;
import com.supergenius.admin.capital.model.vo.VCFiltrateSettledVO;
import com.supergenius.admin.capital.model.vo.VCSettledDisplayVO;
import com.supergenius.admin.capital.model.vo.VCSettledInfoVO;
import com.supergenius.admin.capital.service.IVCSettledService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.supergenius.admin.enums.ESettledStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
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
public class VCSettledServiceImpl extends ServiceImpl<VCSettledDao, VCSettledDO> implements IVCSettledService {
    @Autowired
    VCSettledDao settledDao;

    @Override
    public IPage<VCSettledDisplayVO> getSettledDisplay(Page page, VCFiltrateSettledVO filtrate) {
        return settledDao.getSettledDisplay(page,filtrate);
    }

    @Override
    public VCSettledInfoVO getSettledById(String uid) {
        return settledDao.getSettledById(uid);
    }

    @Override
    public void updateSettled(VCSettledDO after) {
        LambdaUpdateWrapper<VCSettledDO> lambda = new LambdaUpdateWrapper<>();
        lambda.eq(VCSettledDO::getUid,after.getUid());
        settledDao.update(after,lambda);
    }

    @Override
    public void exit(List<String> uids) {
        LambdaUpdateWrapper<VCSettledDO> lambda = new LambdaUpdateWrapper<>();
        lambda.in(VCSettledDO::getUid,uids);
        VCSettledDO temp = new VCSettledDO();
        temp.setReviewtime(new Date());
        temp.setStatus(ESettledStatus.exit);
        settledDao.update(temp,lambda);
    }
}
