package com.supergenius.admin.capital.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.supergenius.admin.capital.model.VCSignupDO;
import com.baomidou.mybatisplus.extension.service.IService;
import com.supergenius.admin.capital.model.vo.VCFiltrateSignupVO;
import com.supergenius.admin.capital.model.vo.VCFiltrateTrainactivityVO;
import com.supergenius.admin.capital.model.vo.VCSignupDisplayVO;
import com.supergenius.admin.capital.model.vo.VCSignupInfoVO;
import com.supergenius.admin.enums.EReview;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author zuoyu
 * @since 2019-12-04
 */
public interface IVCSignupService extends IService<VCSignupDO> {
    VCSignupInfoVO getSinguupByUid(String uid, Page page);
    IPage<VCSignupDisplayVO> getByPage(String pid, Page page, VCFiltrateSignupVO filtrateSignupVO);
    Integer operatingUids(List<String> uids, String reviewer, EReview review);


}
