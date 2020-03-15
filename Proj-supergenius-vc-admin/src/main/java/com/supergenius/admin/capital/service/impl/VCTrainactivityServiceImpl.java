package com.supergenius.admin.capital.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.supergenius.admin.capital.model.VCTrainactivityDO;
import com.supergenius.admin.capital.mapper.VCTrainactivityDao;
import com.supergenius.admin.capital.model.vo.VCFiltrateCorporatetrainingVO;
import com.supergenius.admin.capital.model.vo.VCFiltrateTrainactivityVO;
import com.supergenius.admin.capital.service.IVCTrainactivityService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.supergenius.admin.enums.ETrainactivityType;
import com.supergenius.admin.enums.StatusEnum;
import org.apache.commons.lang3.StringUtils;
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
public class VCTrainactivityServiceImpl extends ServiceImpl<VCTrainactivityDao, VCTrainactivityDO> implements IVCTrainactivityService {
    @Autowired
    VCTrainactivityDao vcTrainactivityDao;

    @Override
    public List<VCTrainactivityDO> getList() {
        return vcTrainactivityDao.selectList(null);
    }

    @Override
    public IPage<VCTrainactivityDO> getDisplayList(Page page, VCFiltrateTrainactivityVO filtrate) {
        LambdaQueryWrapper<VCTrainactivityDO> lambda=new LambdaQueryWrapper<>();
        lambda
                .like(StringUtils.isNotEmpty(filtrate.getTname()),VCTrainactivityDO::getName,filtrate.getTname())
                .eq(filtrate.getActivitystatus()!=null,VCTrainactivityDO::getActivitystatus,filtrate.getActivitystatus())
                .ge(filtrate.getMinsummoney()!=null,VCTrainactivityDO::getSummoney,filtrate.getMinsummoney())
                .le(filtrate.getMaxsummoney()!=null,VCTrainactivityDO::getSummoney,filtrate.getMaxsummoney())
                .ge(StringUtils.isNotEmpty(filtrate.getStarttime()),VCTrainactivityDO::getStarttime,filtrate.getStarttime())
                .le(StringUtils.isNotEmpty(filtrate.getOvertime()),VCTrainactivityDO::getOvertime,filtrate.getOvertime())
                .ge(StringUtils.isNotEmpty(filtrate.getSigntime()),VCTrainactivityDO::getSigntime,filtrate.getSigntime())
                .le(StringUtils.isNotEmpty(filtrate.getEndtime()),VCTrainactivityDO::getEndtime,filtrate.getEndtime())
                .eq(VCTrainactivityDO::getType, ETrainactivityType.roadshow)
                .ne(VCTrainactivityDO::getStatus,StatusEnum.DISABLE)
                .select(
                        VCTrainactivityDO::getUid,
                        VCTrainactivityDO::getName,
                        VCTrainactivityDO::getAddress,
                        VCTrainactivityDO::getStarttime,
                        VCTrainactivityDO::getOvertime,
                        VCTrainactivityDO::getSigntime,
                        VCTrainactivityDO::getEndtime,
                        VCTrainactivityDO::getPrice,
                        VCTrainactivityDO::getSummoney,
                        VCTrainactivityDO::getActivitystatus);
        IPage result = vcTrainactivityDao.selectPage(page, lambda);
        return result;
    }

    @Override
    public VCTrainactivityDO getByUid(String uid) {
        LambdaQueryWrapper<VCTrainactivityDO> lambda=new LambdaQueryWrapper<>();
        lambda.eq(VCTrainactivityDO::getUid,uid);
        VCTrainactivityDO result = vcTrainactivityDao.selectOne(lambda);
        return result;
    }

    @Override
    public Integer deleteByUid(List<String> uids) {
        LambdaQueryWrapper<VCTrainactivityDO> lambda=new LambdaQueryWrapper<>();
        lambda.in(VCTrainactivityDO::getUid,uids);
        VCTrainactivityDO update=new VCTrainactivityDO().setStatus(StatusEnum.DISABLE);
        int i = vcTrainactivityDao.update(update,lambda);
        return i;
    }

    @Override
    public IPage<VCTrainactivityDO> getCorporatetraining(Page page, VCFiltrateCorporatetrainingVO filtrate) {
        LambdaQueryWrapper<VCTrainactivityDO> lambda=new LambdaQueryWrapper<>();
        lambda
                .like(StringUtils.isNotEmpty(filtrate.getName()),VCTrainactivityDO::getName,filtrate.getName())
                .gt(filtrate.getCoursecountMin()!=null,VCTrainactivityDO::getCoursecount,filtrate.getCoursecountMin())
                .le(filtrate.getCoursecountMax()!=null,VCTrainactivityDO::getCoursecount,filtrate.getCoursecountMax())
                .gt(filtrate.getPernumberMin()!=null,VCTrainactivityDO::getPernumber,filtrate.getPernumberMin())
                .le(filtrate.getPernumberMax()!=null,VCTrainactivityDO::getPernumber,filtrate.getPernumberMax())
                .gt(StringUtils.isNotEmpty(filtrate.getStartTime()),VCTrainactivityDO::getSigntime,filtrate.getStartTime())
                .le(StringUtils.isNotEmpty(filtrate.getEndTime()),VCTrainactivityDO::getSigntime,filtrate.getEndTime())
                .eq(filtrate.getState()!=null,VCTrainactivityDO::getActivitystatus,filtrate.getState())
                .eq(VCTrainactivityDO::getType,ETrainactivityType.corporatetraining)
                .ne(VCTrainactivityDO::getStatus,StatusEnum.DISABLE)
                .select(VCTrainactivityDO::getUid
                        ,VCTrainactivityDO::getName
                        ,VCTrainactivityDO::getCoursecount
                        ,VCTrainactivityDO::getPernumber
                        ,VCTrainactivityDO::getSigntime
                        ,VCTrainactivityDO::getEndtime
                        ,VCTrainactivityDO::getSummoney
                        ,VCTrainactivityDO::getActivitystatus
                );
        IPage iPage = vcTrainactivityDao.selectPage(page, lambda);
        return iPage;
    }
}
