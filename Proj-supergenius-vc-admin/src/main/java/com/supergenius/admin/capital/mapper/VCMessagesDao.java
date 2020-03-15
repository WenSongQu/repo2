package com.supergenius.admin.capital.mapper;

import com.baomidou.dynamic.datasource.annotation.DS;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.supergenius.admin.capital.model.VCMessagesDO;
import com.supergenius.admin.capital.model.vo.VCFiltrateEssayVO;
import com.supergenius.admin.capital.model.vo.VCFiltrateMessageVO;
import com.supergenius.admin.capital.model.vo.VCMessageDisplayVO;
import com.supergenius.admin.enums.StatusEnum;
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
public interface VCMessagesDao extends BaseMapper<VCMessagesDO> {
     IPage<VCMessageDisplayVO> getPage(Page page, @Param("map") VCFiltrateMessageVO filtrate,@Param("state") StatusEnum statusEnum);

}
