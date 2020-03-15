package com.supergenius.admin.capital.mapper;

import com.baomidou.dynamic.datasource.annotation.DS;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.supergenius.admin.capital.model.VCSettledDO;
import com.supergenius.admin.capital.model.vo.VCFiltrateSettledVO;
import com.supergenius.admin.capital.model.vo.VCFiltrateUserVO;
import com.supergenius.admin.capital.model.vo.VCSettledDisplayVO;
import com.supergenius.admin.capital.model.vo.VCSettledInfoVO;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

/**
 * <p>
 * Mapper 接口
 * </p>
 *
 * @author zuoyu
 * @since 2019-12-04
 */
@DS(value = "master_capital")
@Repository
public interface VCSettledDao extends BaseMapper<VCSettledDO> {

    IPage<VCSettledDisplayVO> getSettledDisplay(Page page, @Param("map") VCFiltrateSettledVO filtrate);
    VCSettledInfoVO getSettledById(@Param("uid") String uid);
}
