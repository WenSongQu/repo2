package com.supergenius.admin.capital.service;

import com.supergenius.admin.capital.mapper.VCTeamDao;
import com.supergenius.admin.capital.model.VCTeamDO;
import com.baomidou.mybatisplus.extension.service.IService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author zuoyu
 * @since 2019-12-04
 */
public interface IVCTeamService extends IService<VCTeamDO> {
   List<VCTeamDO> getTeamByProjectId(String uid);



}
