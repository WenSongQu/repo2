package com.supergenius.admin.capital.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.supergenius.admin.capital.model.VCSettledDO;
import com.baomidou.mybatisplus.extension.service.IService;
import com.supergenius.admin.capital.model.vo.VCFiltrateSettledVO;
import com.supergenius.admin.capital.model.vo.VCSettledDisplayVO;
import com.supergenius.admin.capital.model.vo.VCSettledInfoVO;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author zuoyu
 * @since 2019-12-04
 */
public interface IVCSettledService extends IService<VCSettledDO> {
    IPage<VCSettledDisplayVO> getSettledDisplay(Page page, @Param("map") VCFiltrateSettledVO filtrate);
    VCSettledInfoVO getSettledById(@Param("uid") String uid);
    void updateSettled(VCSettledDO after);
    void exit(List<String> uids);

}
