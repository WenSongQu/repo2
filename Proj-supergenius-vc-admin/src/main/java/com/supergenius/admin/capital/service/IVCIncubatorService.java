package com.supergenius.admin.capital.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.supergenius.admin.capital.model.VCIncubatorDO;
import com.baomidou.mybatisplus.extension.service.IService;
import com.supergenius.admin.capital.model.vo.VCFiltrateIncubatorVO;
import com.supergenius.admin.capital.model.vo.VCFiltrateOrderVO;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author zuoyu
 * @since 2019-12-04
 */
public interface IVCIncubatorService extends IService<VCIncubatorDO> {
    IPage<VCIncubatorDO> getDisplayList(Page page, VCFiltrateIncubatorVO filtrate);
    void closeIncubator(List<String> list);
    void startIncubator(List<String> list);
    void deleteIncubator(List<String> list);
    VCIncubatorDO getByUid(String uid);

}
