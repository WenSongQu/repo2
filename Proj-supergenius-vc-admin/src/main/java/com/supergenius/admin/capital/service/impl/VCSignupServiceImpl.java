package com.supergenius.admin.capital.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.api.R;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.supergenius.admin.capital.mapper.VCTrainactivityDao;
import com.supergenius.admin.capital.model.VCSignupDO;
import com.supergenius.admin.capital.mapper.VCSignupDao;
import com.supergenius.admin.capital.model.VCTrainactivityDO;
import com.supergenius.admin.capital.model.vo.VCFiltrateSignupVO;
import com.supergenius.admin.capital.model.vo.VCFiltrateTrainactivityVO;
import com.supergenius.admin.capital.model.vo.VCSignupDisplayVO;
import com.supergenius.admin.capital.model.vo.VCSignupInfoVO;
import com.supergenius.admin.capital.service.IVCSignupService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.supergenius.admin.enums.EIdentity;
import com.supergenius.admin.enums.EReview;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author zuoyu
 * @since 2019-12-04
 */
@Service
public class VCSignupServiceImpl extends ServiceImpl<VCSignupDao, VCSignupDO> implements IVCSignupService {
    @Autowired
    VCTrainactivityDao trainactivityDao;
    @Autowired
    VCSignupDao signupDao;

    @Override
    public VCSignupInfoVO getSinguupByUid(String uid, Page page) {
        LambdaQueryWrapper<VCTrainactivityDO> lambda=new LambdaQueryWrapper<>();
        lambda.eq(VCTrainactivityDO::getUid,uid);
        //获取路演活动信息
        VCTrainactivityDO trainactivityDO = trainactivityDao.selectOne(lambda);
        //获取下面展示列表
        IPage<VCSignupDisplayVO> iPage = signupDao.getVCSignupDisplayVOByPage(uid, page);
        //
        Stream<VCSignupDisplayVO> stream1 = signupDao.getAll(uid).stream();
        Stream<VCSignupDisplayVO> stream2 = signupDao.getAll(uid).stream();
        Stream<VCSignupDisplayVO> stream3 = signupDao.getAll(uid).stream();
        //企业创业者报名数量
        int enterprisestartupSize = stream1.filter(item -> item.getKind() == EIdentity.enterprisestartup).collect(Collectors.toList()).size();
        //个人投资者
        int personalinvestmentSize = stream2.filter(item -> item.getKind() == EIdentity.personalinvestment).collect(Collectors.toList()).size();
        //企业投资者
        int mechanisminvestmentSize = stream3.filter(item -> item.getKind() == EIdentity.mechanisminvestment).collect(Collectors.toList()).size();
        //返回对象
        VCSignupInfoVO signupInfoVO=new VCSignupInfoVO(enterprisestartupSize,personalinvestmentSize,mechanisminvestmentSize,iPage,trainactivityDO);
        return signupInfoVO;
    }

    @Override
    public IPage<VCSignupDisplayVO> getByPage(String pid, Page page, VCFiltrateSignupVO filtrateSignupVO) {
        return signupDao.getByPage(pid,page,filtrateSignupVO);
    }

    @Override
    public Integer operatingUids(List<String> uids, String reviewer, EReview review) {
        LambdaQueryWrapper<VCSignupDO> lambda=new LambdaQueryWrapper<>();
        lambda.in(VCSignupDO::getUseruid,uids);
        VCSignupDO after = new VCSignupDO().setReviewstatus(review).setReviewer(reviewer).setReviewtime(new Date());
        int update = signupDao.update(after, lambda);
        return update;
    }

}
