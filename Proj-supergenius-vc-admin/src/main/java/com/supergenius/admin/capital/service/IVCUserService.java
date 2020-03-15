package com.supergenius.admin.capital.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.supergenius.admin.capital.model.VCUserDO;
import com.baomidou.mybatisplus.extension.service.IService;
import com.supergenius.admin.capital.model.vo.*;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * <p>
 * 服务类
 * </p>
 *
 * @author zuoyu
 * @since 2019-12-04
 */
public interface IVCUserService extends IService<VCUserDO> {
    public Map<String, Integer> getUserCount();

    IPage<VCEntrepreneurmemberDisplayVO> selectMemberOrderDisplayDO(Page page, @Param("map") VCFiltrateUserVO vcFiltrateUserVO);

    void freezeUser(@Param("list") List<String> users);

    void unFreezeUser(@Param("list") List<String> users);

    VCEnterpreneurmemberBasePersonVO getVCEnterpreneurmemberBaseInfoVOById(@Param("uid") String uid);

    List<VCEnterpreneurmemberFinancingVO> getVCEnterpreneurmemberFinancingInfoVOById(@Param("uid") String uid, int pageNum);

    List<VCEnterpreneurmemberOrderVO> getVCEnterpreneurmemberOrderVOById(@Param("uid") String uid, int pageNum);

    VCEnterpreneurmemberBaseCompanyVO getVCEnterpreneurmemberBaseCompanyVOById(@Param("uid") String uid);

    IPage<VCInvestorsDisplayVO> selectInvestorsDisplayVO(Page page, @Param("map") VCFiltrateUserVO vcFiltrateUserVO);

    //查询创业者信息的基本信息（个人）
    VCInvestorsBasePersonInfoVO getVCInvestorsBasePersonInfoVCById(@Param("uid") String uid);

    //查询投资者信息的基本信息（公司）
    VCInvestorsBaseConpantyInfoVO2 getVCInvestorsBaseConpantyInfoVCById(@Param("uid") String uid);

    IPage<VCUserinfoVo> getGuaranteeMembers(Page page, @Param("map") VCFiltrateUserVO vcFiltrateUserVO);

    //查询推荐人列表
    IPage<VCUserinfoVo> getRecommendMembers(Page page, @Param("map") VCFiltrateUserVO vcFiltrateUserVO);

    //查询召集人列表
    IPage<VCUserinfoVo> getConvenerMembers(Page page, @Param("map") VCFiltrateUserVO vcFiltrateUserVO);


}
