package com.supergenius.admin.capital.service;

import com.supergenius.admin.capital.model.VCTemplateDO;
import com.baomidou.mybatisplus.extension.service.IService;
import com.supergenius.admin.enums.StatusEnum;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author zuoyu
 * @since 2019-12-04
 */
public interface IVCTemplateService extends IService<VCTemplateDO> {
    List<VCTemplateDO> getAllTemplate();
    Integer operateTemplate(String uid, StatusEnum statusEnum);
    Integer editTemplate(String uid,String content);

}
