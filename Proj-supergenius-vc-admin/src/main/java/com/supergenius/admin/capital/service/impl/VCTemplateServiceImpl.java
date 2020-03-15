package com.supergenius.admin.capital.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.supergenius.admin.capital.mapper.VCTrainactivityDao;
import com.supergenius.admin.capital.model.VCTemplateDO;
import com.supergenius.admin.capital.mapper.VCTemplateDao;
import com.supergenius.admin.capital.model.VCTrainactivityDO;
import com.supergenius.admin.capital.service.IVCTemplateService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.supergenius.admin.enums.StatusEnum;
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
public class VCTemplateServiceImpl extends ServiceImpl<VCTemplateDao, VCTemplateDO> implements IVCTemplateService {
    @Autowired
    VCTemplateDao templateDao;

    @Override
    public List<VCTemplateDO> getAllTemplate() {
        List<VCTemplateDO> list = templateDao.selectList(null);
        return list;
    }

    @Override
    public Integer operateTemplate(String uid, StatusEnum statusEnum) {
        LambdaQueryWrapper<VCTemplateDO> lambda=new LambdaQueryWrapper<>();
        lambda.eq(VCTemplateDO::getUid,uid);
        VCTemplateDO vcTemplateDO = new VCTemplateDO();
        vcTemplateDO.setStatus(statusEnum);
        int update = templateDao.update(vcTemplateDO, lambda);
        return update;
    }

    @Override
    public Integer editTemplate(String uid, String content) {
        LambdaQueryWrapper<VCTemplateDO> lambda=new LambdaQueryWrapper<>();
        lambda.eq(VCTemplateDO::getUid,uid);
        VCTemplateDO vcTemplateDO = new VCTemplateDO();
        vcTemplateDO.setContent(content);
        int update = templateDao.update(vcTemplateDO, lambda);
        return update;
    }
}
