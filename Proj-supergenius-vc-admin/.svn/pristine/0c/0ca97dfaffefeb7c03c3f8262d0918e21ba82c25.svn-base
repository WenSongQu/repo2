package com.supergenius.admin.capital.service;

import com.supergenius.admin.capital.mapper.VCContentDao;
import com.supergenius.admin.capital.model.VCContentDO;
import com.baomidou.mybatisplus.extension.service.IService;
import com.supergenius.admin.enums.EContentType;
import com.supergenius.admin.enums.ESide;
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
public interface IVCContentService extends IService<VCContentDO> {
    List<VCContentDO> getIndexVentureContent();
    List<VCContentDO> getIndexCapitalContent();
    List<VCContentDO> getContent(ESide side, EContentType type);
    Boolean statusChange(String uid );
    Boolean deleteContent(String uid,ESide side, EContentType type);
    Integer addContent(VCContentDO content,ESide side, EContentType type);
    Integer update(VCContentDO contentDO);
    void upOrder(ESide side, EContentType type);
    void downOrder(ESide side, EContentType type);
   // void


}
