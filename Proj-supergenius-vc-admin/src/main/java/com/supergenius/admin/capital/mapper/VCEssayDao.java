package com.supergenius.admin.capital.mapper;

import com.baomidou.dynamic.datasource.annotation.DS;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.supergenius.admin.capital.model.VCEssayDO;
import com.supergenius.admin.capital.model.vo.*;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

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
public interface VCEssayDao extends BaseMapper<VCEssayDO> {
    public IPage<VCEssayVO> getAll(Page page, @Param("map") VCFiltrateEssayVO filtrate);
    public VCEssayVO getByUid (@Param("uid") String uid);
//     IPage<VCMessageDisplayVO> selectPage(Page page, @Param("map") VCFiltrateOrderVO vcFiltrateVO,
}
