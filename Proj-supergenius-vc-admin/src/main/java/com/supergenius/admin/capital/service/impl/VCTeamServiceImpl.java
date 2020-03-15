package com.supergenius.admin.capital.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.supergenius.admin.capital.model.VCTeamDO;
import com.supergenius.admin.capital.mapper.VCTeamDao;
import com.supergenius.admin.capital.service.IVCTeamService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
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
public class VCTeamServiceImpl extends ServiceImpl<VCTeamDao, VCTeamDO> implements IVCTeamService {
    @Autowired
    VCTeamDao dao;

    @Override
    public List<VCTeamDO> getTeamByProjectId(String uid) {
        LambdaQueryWrapper<VCTeamDO> lambda=new LambdaQueryWrapper<>();
        lambda.eq(VCTeamDO::getPid,uid);
        List<VCTeamDO> list = dao.selectList(lambda);
        return list;
    }
}
