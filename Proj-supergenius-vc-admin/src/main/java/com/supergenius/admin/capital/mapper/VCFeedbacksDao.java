package com.supergenius.admin.capital.mapper;

import com.baomidou.dynamic.datasource.annotation.DS;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.supergenius.admin.capital.model.VCFeedbacksDO;
import com.supergenius.admin.capital.model.vo.*;
import com.supergenius.admin.enums.ELabelType;
import com.supergenius.admin.enums.EReportReason;
import com.supergenius.admin.enums.StatusEnum;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

/**
 * <p>
 * Mapper 接口
 * </p>
 *
 * @author zuoyu
 * @since 2019-12-04
 */
@DS(value = "master_capital")
@Repository
public interface VCFeedbacksDao extends BaseMapper<VCFeedbacksDO> {
    IPage<VCFeedBacksPersonDisplayVO> getPagePerson(Page page, @Param("map") VCFiltrateFeedbacks filtrate, @Param("labelType") ELabelType labelType);
    VCFeedBacksPersonInfoVO getOne(@Param("uid") String uid);
    IPage<VCFeedbackProjectDisplayVO> getPageProject(Page page, @Param("map") VCFiltrateFeedbackProjectVO filtrate, @Param("labelType") ELabelType labelType);
    VCFeedbackProjectInfoVO getOneProject(@Param("uid") String uid);
    IPage<VCFeedbacksMessageDisplayVO> getPageMessage(Page page,@Param("map") VCFiltrateFeedbacksMessageVO filtrate, @Param("labelType") ELabelType labelType);
    VCFeedbacksMessageInfoVO getOneMessage(@Param("uid") String uid);
    IPage<VCFeedbacksEssayDisplayVO> getPageEssay(Page page,@Param("map") VCFiltrateFeedbacksEssayVO filtrate, @Param("labelType") ELabelType labelType);
    VCFeedbacksEssayInfoVO getOneEssay(@Param("uid")String uid);

}
