package com.supergenius.admin.capital.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.supergenius.admin.capital.model.VCUserinfoDO;
import com.supergenius.admin.capital.mapper.VCUserinfoDao;
import com.supergenius.admin.capital.service.IVCUserinfoService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.supergenius.admin.enums.EIdentityType;
import com.supergenius.admin.enums.EReview;
import com.supergenius.admin.enums.EUseStatus;
import com.supergenius.admin.enums.EUsermode;
import com.supergenius.admin.utils.AuthcodeUtils;
import org.springframework.beans.factory.annotation.Autowired;
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
public class VCUserinfoServiceImpl extends ServiceImpl<VCUserinfoDao, VCUserinfoDO> implements IVCUserinfoService {

    @Autowired
    VCUserinfoDao userinfoDao;

    @Override
    public void auditSuccess(List<String> uids, EIdentityType type) {
//        LambdaQueryWrapper<VCUserinfoDO> lambda=new LambdaQueryWrapper<>();
//        VCUserinfoDO temp = new VCUserinfoDO();
//        temp.setReviewstatus(EReview.success);
//        temp.setAuthcode()
//        lambda.in(VCUserinfoDO::getUid,uids);
        uids.forEach(item -> {
            LambdaQueryWrapper<VCUserinfoDO> lambda = new LambdaQueryWrapper<>();
            lambda.eq(VCUserinfoDO::getUseruid, item).eq(VCUserinfoDO::getIdentity,type);
            VCUserinfoDO vcUserinfoDO = userinfoDao.selectOne(lambda);
            vcUserinfoDO.setAuthcode(AuthcodeUtils.generateCode());
            vcUserinfoDO.setReviewstatus(EReview.success);
            vcUserinfoDO.setStatus(EUsermode.normal);
            userinfoDao.updateById(vcUserinfoDO);
        });

    }

    @Override
    public void auditFailed(List<String> uids, EIdentityType type) {
        uids.forEach(item -> {
            LambdaQueryWrapper<VCUserinfoDO> lambda = new LambdaQueryWrapper<>();
            lambda.eq(VCUserinfoDO::getUseruid, item).eq(VCUserinfoDO::getIdentity,type);
            VCUserinfoDO vcUserinfoDO = userinfoDao.selectOne(lambda);
            vcUserinfoDO.setAuthcode(AuthcodeUtils.generateCode());
            vcUserinfoDO.setReviewstatus(EReview.fail);
            userinfoDao.updateById(vcUserinfoDO);
        });
    }

    public void auditBan(List<String> uids, EIdentityType type) {
        uids.forEach(item -> {
            LambdaQueryWrapper<VCUserinfoDO> lambda = new LambdaQueryWrapper<>();
            lambda.eq(VCUserinfoDO::getUseruid, item).eq(VCUserinfoDO::getIdentity,type);
            VCUserinfoDO vcUserinfoDO = userinfoDao.selectOne(lambda);
            vcUserinfoDO.setAuthcode(AuthcodeUtils.generateCode());
            vcUserinfoDO.setStatus(EUsermode.ban);
           // vcUserinfoDO.setReviewstatus(EReview.fail);
            userinfoDao.updateById(vcUserinfoDO);
        });
    }
    public void auditStart(List<String> uids, EIdentityType type) {
        uids.forEach(item -> {
            LambdaQueryWrapper<VCUserinfoDO> lambda = new LambdaQueryWrapper<>();
            lambda.eq(VCUserinfoDO::getUseruid, item).eq(VCUserinfoDO::getIdentity,type);
            VCUserinfoDO vcUserinfoDO = userinfoDao.selectOne(lambda);
            vcUserinfoDO.setAuthcode(AuthcodeUtils.generateCode());
            vcUserinfoDO.setStatus(EUsermode.normal);
            // vcUserinfoDO.setReviewstatus(EReview.fail);
            userinfoDao.updateById(vcUserinfoDO);
        });
    }
}
