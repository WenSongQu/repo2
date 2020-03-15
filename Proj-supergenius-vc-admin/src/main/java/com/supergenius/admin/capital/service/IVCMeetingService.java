package com.supergenius.admin.capital.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.supergenius.admin.capital.model.VCMeetingDO;
import com.baomidou.mybatisplus.extension.service.IService;
import com.supergenius.admin.capital.model.vo.VCFiltrateMeetingVO;
import com.supergenius.admin.enums.StatusEnum;
import io.swagger.models.auth.In;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author zuoyu
 * @since 2019-12-04
 */
public interface IVCMeetingService extends IService<VCMeetingDO> {
    IPage getMeetingDisplayList(Page page, VCFiltrateMeetingVO filtrateMeeting);
    Integer operateMetting(List<String> list, StatusEnum statusEnum);
    VCMeetingDO getByID(String uid);
;

}
