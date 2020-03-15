package com.supergenius.admin.capital.service;

import com.supergenius.admin.capital.model.VCCommentDO;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author zuoyu
 * @since 2019-12-04
 */
public interface IVCCommentService extends IService<VCCommentDO> {
    List<VCCommentDO> getByPid(String pid);

}
