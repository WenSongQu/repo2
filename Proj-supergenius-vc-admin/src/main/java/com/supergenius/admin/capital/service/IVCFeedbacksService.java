package com.supergenius.admin.capital.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.supergenius.admin.capital.model.VCFeedbacksDO;
import com.baomidou.mybatisplus.extension.service.IService;
import com.supergenius.admin.capital.model.vo.*;
import com.supergenius.admin.enums.ELabelType;
import com.supergenius.admin.enums.EReportReason;
import org.apache.ibatis.annotations.Param;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author zuoyu
 * @since 2019-12-04
 */
public interface IVCFeedbacksService extends IService<VCFeedbacksDO> {
  //  IPage
  IPage<VCFeedBacksPersonDisplayVO> getPagePerson(Page page, @Param("map") VCFiltrateFeedbacks filtrate, @Param("labelType") ELabelType labelType);
  VCFeedBacksPersonInfoVO getOne(String uid);
  IPage<VCFeedbackProjectDisplayVO> getPageProject(Page page, @Param("map") VCFiltrateFeedbackProjectVO filtrate, @Param("labelType") ELabelType labelType);
  VCFeedbackProjectInfoVO getOneProject(@Param("uid") String uid);
  IPage<VCFeedbacksMessageDisplayVO> getPageMessage(Page page,@Param("map") VCFiltrateFeedbacksMessageVO filtrate, @Param("labelType") ELabelType labelType);
  VCFeedbacksMessageInfoVO getOneMessage(@Param("uid") String uid);
  IPage<VCFeedbacksEssayDisplayVO> getPageEssay(Page page,@Param("map") VCFiltrateFeedbacksEssayVO filtrate, @Param("labelType") ELabelType labelType);
  VCFeedbacksEssayInfoVO getOneEssay(@Param("uid")String uid);
}
