package com.supergenius.admin.capital.mapper;

import com.baomidou.dynamic.datasource.annotation.DS;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.supergenius.admin.capital.model.VCProjectDO;
import com.supergenius.admin.capital.model.vo.VCFiltrateProjectVO;
import com.supergenius.admin.capital.model.vo.VCProjectDisplayVO;
import com.supergenius.admin.capital.model.vo.VCRelaseProjectInfoVO;
import com.supergenius.admin.capital.model.vo.VShowinfoVO;
import com.supergenius.admin.enums.EProjecttype;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

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
public interface VCProjectDao extends BaseMapper<VCProjectDO> {
    IPage<VShowinfoVO> selectStartUpProjectPageVo(Page page, @Param("map") Map<String, Object> map);

    Integer freezeProject(List<String> list);

    Integer unFreezeProject(List<String> list);

    IPage<VCRelaseProjectInfoVO> selectVCRelaseProjectInoPage(Page page, @Param("map") Map<String, Object> map);
    //查看创业项目列表
    IPage<VCProjectDisplayVO> selectProjectDisplayPage(Page page, @Param("map") VCFiltrateProjectVO filtrateProject, @Param("projecttype") EProjecttype projecttype);

}
