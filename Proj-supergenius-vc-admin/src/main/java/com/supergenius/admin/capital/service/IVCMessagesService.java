package com.supergenius.admin.capital.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.supergenius.admin.capital.model.VCMessagesDO;
import com.baomidou.mybatisplus.extension.service.IService;
import com.supergenius.admin.capital.model.vo.VCFiltrateMessageVO;
import com.supergenius.admin.capital.model.vo.VCMessageDisplayVO;
import org.apache.ibatis.annotations.Param;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author zuoyu
 * @since 2019-12-04
 */
public interface IVCMessagesService extends IService<VCMessagesDO> {
    IPage<VCMessageDisplayVO> getPage(Page page, @Param("map") VCFiltrateMessageVO filtrate);
    Integer deleteByUid(String uid);

}
