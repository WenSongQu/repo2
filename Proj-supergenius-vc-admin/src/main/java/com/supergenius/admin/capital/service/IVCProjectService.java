package com.supergenius.admin.capital.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.supergenius.admin.capital.model.VCProjectDO;
import com.baomidou.mybatisplus.extension.service.IService;
import com.supergenius.admin.capital.model.vo.VCFiltrateProjectVO;
import com.supergenius.admin.capital.model.vo.VCProjectDisplayVO;
import com.supergenius.admin.capital.model.vo.VCProjectIntroductionVO;
import com.supergenius.admin.enums.EProjecttype;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author zuoyu
 * @since 2019-12-04
 */
public interface IVCProjectService extends IService<VCProjectDO> {
    Map<String,Integer> selectProjectCount();
    IPage<VCProjectDisplayVO> selectProjectDisplayPage(Page page, @Param("map") VCFiltrateProjectVO filtrateProject, @Param("projecttype") EProjecttype projecttype);
    Integer freezeProject(List<String> pids);
    Integer unFreezeProject(List<String> pids);
    VCProjectDO getBaseinfo(String uid);
    VCProjectIntroductionVO getProjectIntroduction(String uid);
    String getProjectSummary(String uid);
    Float getSharestock(String uid);


}
