package com.supergenius.admin.capital.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.supergenius.admin.capital.model.VCEssayDO;
import com.baomidou.mybatisplus.extension.service.IService;
import com.supergenius.admin.capital.model.vo.VCEssayVO;
import com.supergenius.admin.capital.model.vo.VCFiltrateEssayVO;
import org.apache.ibatis.annotations.Param;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author zuoyu
 * @since 2019-12-04
 */
public interface IVCEssayService extends IService<VCEssayDO> {
     IPage<VCEssayVO> getAll(Page page, @Param("map") VCFiltrateEssayVO filtrate);
     VCEssayVO getByUid(String uid);
     Integer deleteEssay(String uid);

}
