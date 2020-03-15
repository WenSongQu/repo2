package com.supergenius.admin.capital.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.supergenius.admin.capital.model.VCMessagesDO;
import com.supergenius.admin.capital.mapper.VCMessagesDao;
import com.supergenius.admin.capital.model.vo.VCFiltrateMessageVO;
import com.supergenius.admin.capital.model.vo.VCMessageDisplayVO;
import com.supergenius.admin.capital.service.IVCMessagesService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.supergenius.admin.enums.StatusEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author zuoyu
 * @since 2019-12-04
 */
@Service
public class VCMessagesServiceImpl extends ServiceImpl<VCMessagesDao, VCMessagesDO> implements IVCMessagesService {
    @Autowired
    VCMessagesDao vcMessagesDao;

    @Override
    public IPage<VCMessageDisplayVO> getPage(Page page, VCFiltrateMessageVO filtrate) {
        return vcMessagesDao.getPage(page,filtrate,StatusEnum.DISABLE);
    }

    @Override
    public Integer deleteByUid(String uid) {
        LambdaQueryWrapper<VCMessagesDO> lambda=new LambdaQueryWrapper<>();
        lambda.eq(VCMessagesDO::getUid,uid);
        VCMessagesDO delete = new VCMessagesDO();
        delete.setStatus(StatusEnum.DISABLE);
        int result = vcMessagesDao.update(delete, lambda);
        return result;
    }

}
