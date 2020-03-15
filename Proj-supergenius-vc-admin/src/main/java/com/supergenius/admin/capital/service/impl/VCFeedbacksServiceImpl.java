package com.supergenius.admin.capital.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.supergenius.admin.capital.model.VCFeedbacksDO;
import com.supergenius.admin.capital.mapper.VCFeedbacksDao;
import com.supergenius.admin.capital.model.vo.*;
import com.supergenius.admin.capital.service.IVCFeedbacksService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.supergenius.admin.enums.ELabelType;
import com.supergenius.admin.enums.EReportReason;
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
public class VCFeedbacksServiceImpl extends ServiceImpl<VCFeedbacksDao, VCFeedbacksDO> implements IVCFeedbacksService {
    @Autowired
    VCFeedbacksDao feedbacksDao;

    @Override
    public IPage<VCFeedBacksPersonDisplayVO> getPagePerson(Page page, VCFiltrateFeedbacks filtrate, ELabelType labelType) {
        IPage<VCFeedBacksPersonDisplayVO> pagePerson = feedbacksDao.getPagePerson(page, filtrate, labelType);
        return pagePerson;
    }

    @Override
    public VCFeedBacksPersonInfoVO getOne(String uid) {
        return feedbacksDao.getOne(uid);
    }

    @Override
    public IPage<VCFeedbackProjectDisplayVO> getPageProject(Page page, VCFiltrateFeedbackProjectVO filtrate, ELabelType labelType) {
        return feedbacksDao.getPageProject(page,filtrate,labelType);
    }

    @Override
    public VCFeedbackProjectInfoVO getOneProject(String uid) {
        return feedbacksDao.getOneProject(uid);
    }

    @Override
    public IPage<VCFeedbacksMessageDisplayVO> getPageMessage(Page page, VCFiltrateFeedbacksMessageVO filtrate, ELabelType labelType) {
        return feedbacksDao.getPageMessage(page,filtrate,labelType);
    }

    @Override
    public VCFeedbacksMessageInfoVO getOneMessage(String uid) {
        return feedbacksDao.getOneMessage(uid);
    }

    @Override
    public IPage<VCFeedbacksEssayDisplayVO> getPageEssay(Page page, VCFiltrateFeedbacksEssayVO filtrate, ELabelType labelType) {
        return feedbacksDao.getPageEssay(page,filtrate,labelType);
    }

    @Override
    public VCFeedbacksEssayInfoVO getOneEssay(String uid) {
        return feedbacksDao.getOneEssay(uid);
    }
}
