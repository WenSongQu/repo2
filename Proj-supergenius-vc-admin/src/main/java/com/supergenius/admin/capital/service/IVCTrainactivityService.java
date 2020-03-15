package com.supergenius.admin.capital.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.supergenius.admin.capital.model.VCIncubatorDO;
import com.supergenius.admin.capital.model.VCTrainactivityDO;
import com.baomidou.mybatisplus.extension.service.IService;
import com.supergenius.admin.capital.model.vo.VCFiltrateCorporatetrainingVO;
import com.supergenius.admin.capital.model.vo.VCFiltrateIncubatorVO;
import com.supergenius.admin.capital.model.vo.VCFiltrateTrainactivityVO;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author zuoyu
 * @since 2019-12-04
 */
public interface IVCTrainactivityService extends IService<VCTrainactivityDO> {
    List<VCTrainactivityDO> getList();
    IPage<VCTrainactivityDO> getDisplayList(Page page, VCFiltrateTrainactivityVO filtrate);
    VCTrainactivityDO getByUid(String uid);
    Integer deleteByUid(List<String> uids);
    IPage<VCTrainactivityDO> getCorporatetraining(Page page, VCFiltrateCorporatetrainingVO filtrate);
}
