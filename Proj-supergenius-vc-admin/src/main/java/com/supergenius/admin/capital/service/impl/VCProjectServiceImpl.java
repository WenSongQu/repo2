package com.supergenius.admin.capital.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.supergenius.admin.capital.model.VCFinancingDO;
import com.supergenius.admin.capital.model.VCProjectDO;
import com.supergenius.admin.capital.mapper.VCProjectDao;
import com.supergenius.admin.capital.model.VCTeamDO;
import com.supergenius.admin.capital.model.vo.VCFiltrateProjectVO;
import com.supergenius.admin.capital.model.vo.VCProjectDisplayVO;
import com.supergenius.admin.capital.model.vo.VCProjectIntroductionVO;
import com.supergenius.admin.capital.service.IVCFinancingService;
import com.supergenius.admin.capital.service.IVCProjectService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.supergenius.admin.capital.service.IVCTeamService;
import com.supergenius.admin.enums.EFinacingStatus;
import com.supergenius.admin.enums.EProjecttype;
import com.supergenius.admin.enums.EResale;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author zuoyu
 * @since 2019-12-04
 */
@Service
public class VCProjectServiceImpl extends ServiceImpl<VCProjectDao, VCProjectDO> implements IVCProjectService {
    @Autowired
    VCProjectDao vcProjectDao;
    @Autowired
    IVCTeamService teamService;
    @Autowired
    IVCFinancingService financingService;

    @Override
    public Map<String, Integer> selectProjectCount() {
        Map<String, Integer> map = new HashMap<>();
        //正在融资数量
        QueryWrapper<VCProjectDO> finacingWrapper = new QueryWrapper<>();
        finacingWrapper.lambda().eq(VCProjectDO::getFinacingstatus, EFinacingStatus.finacing);
        int finacingSize = vcProjectDao.selectList(finacingWrapper).size();
        map.put("finacingSize", finacingSize);
        //获取全部融资
        QueryWrapper<VCProjectDO> allWapper = new QueryWrapper<>();
        allWapper.lambda().in(VCProjectDO::getFinacingstatus, Arrays.asList(3, 0));
        int allSize = vcProjectDao.selectList(allWapper).size();
        map.put("allFinacingSize", allSize);
        //融资成功
        QueryWrapper<VCProjectDO> completeWapper = new QueryWrapper<>();
        completeWapper.lambda().eq(VCProjectDO::getFinacingstatus, EFinacingStatus.complete);
        int completeSize = vcProjectDao.selectList(completeWapper).size();
        map.put("completeSize", completeSize);
        //正在转售
        QueryWrapper<VCProjectDO> resellingWapper = new QueryWrapper<>();
        resellingWapper.lambda().eq(VCProjectDO::getResalestatus, EResale.reselling);
        int resellingSize = vcProjectDao.selectList(resellingWapper).size();
        map.put("resellingSize", resellingSize);
        //全部转售
        QueryWrapper<VCProjectDO> allResaleWapper = new QueryWrapper<>();
        allResaleWapper.lambda().in(VCProjectDO::getResalestatus, Arrays.asList(1, 0));
        int allResaleSize = vcProjectDao.selectList(allResaleWapper).size();
        map.put("allResaleSize", allResaleSize);
        return map;
    }

    @Override
    public IPage<VCProjectDisplayVO> selectProjectDisplayPage(Page page, VCFiltrateProjectVO filtrateProject, EProjecttype projecttype) {
        return vcProjectDao.selectProjectDisplayPage(page, filtrateProject, projecttype);
    }

    @Override
    public Integer freezeProject(List<String> pids) {
        Integer result = vcProjectDao.freezeProject(pids);
        return result;
    }

    @Override
    public Integer unFreezeProject(List<String> pids) {
        Integer result = vcProjectDao.unFreezeProject(pids);
        return result;
    }

    @Override
    public VCProjectDO getBaseinfo(String uid) {
        LambdaQueryWrapper<VCProjectDO> lambda = new LambdaQueryWrapper<>();
        lambda.eq(VCProjectDO::getPid,uid);
        VCProjectDO result = vcProjectDao.selectOne(lambda);
        return result;
    }

    @Override
    public VCProjectIntroductionVO getProjectIntroduction(String uid) {
        VCProjectIntroductionVO result = new VCProjectIntroductionVO();
        LambdaQueryWrapper<VCProjectDO> lambda = new LambdaQueryWrapper<>();
        lambda.eq(VCProjectDO::getPid,uid);
        VCProjectDO project = vcProjectDao.selectOne(lambda);
        result.setOverview(project.getOverview());
        result.setAnalysis(project.getAnalysis());
        result.setProfit(project.getProfit());
        result.setProspect(project.getProspect());
        List<VCTeamDO> teams = teamService.getTeamByProjectId(uid);
        result.setTeams(teams);
        List<VCFinancingDO> financingList = financingService.getByPid(uid);
        result.setFinancingDOList(financingList);
        result.setStage(project.getStage());
        result.setProjectdisplay(project.getProjectdisplay());
        return result;
    }

    @Override
    public String getProjectSummary(String uid) {
        //VCProjectIntroductionVO result = new VCProjectIntroductionVO();
        LambdaQueryWrapper<VCProjectDO> lambda = new LambdaQueryWrapper<>();
        lambda.eq(VCProjectDO::getPid,uid);
        VCProjectDO project = vcProjectDao.selectOne(lambda);
        return project.getSummary();
    }

    @Override
    public Float getSharestock(String uid) {
        LambdaQueryWrapper<VCProjectDO> lambda = new LambdaQueryWrapper<>();
        lambda.eq(VCProjectDO::getPid,uid);
        VCProjectDO project = vcProjectDao.selectOne(lambda);
        return project.getSharestock();
    }

}
