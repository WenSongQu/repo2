package com.supergenius.admin.capital.mapper;

import com.baomidou.dynamic.datasource.annotation.DS;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.supergenius.admin.capital.model.VCSignupDO;
import com.supergenius.admin.capital.model.vo.VCFiltrateSettledVO;
import com.supergenius.admin.capital.model.vo.VCFiltrateSignupVO;
import com.supergenius.admin.capital.model.vo.VCFiltrateTrainactivityVO;
import com.supergenius.admin.capital.model.vo.VCSignupDisplayVO;
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
public interface VCSignupDao extends BaseMapper<VCSignupDO> {
    IPage<VCSignupDisplayVO> getVCSignupDisplayVOByPage(@Param("pid") String pid, Page page);
    List<VCSignupDisplayVO> getAll(@Param("pid")String pid);
    IPage<VCSignupDisplayVO> getByPage(@Param("pid")String pid, Page page, @Param("map") VCFiltrateSignupVO filtrateSettled);

}
