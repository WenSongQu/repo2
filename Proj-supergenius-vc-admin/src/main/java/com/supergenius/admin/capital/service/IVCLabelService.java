package com.supergenius.admin.capital.service;

import com.supergenius.admin.capital.model.VCLabelDO;
import com.baomidou.mybatisplus.extension.service.IService;
import com.supergenius.admin.enums.ELabelType;
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
public interface IVCLabelService extends IService<VCLabelDO> {
    List<VCLabelDO> getLableByType(ELabelType eLabelType);
    Integer addLable(ELabelType eLabelType,String name);
    Integer deletet(String uid);

}
