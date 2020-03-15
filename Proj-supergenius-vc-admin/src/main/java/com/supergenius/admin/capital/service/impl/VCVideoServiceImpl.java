package com.supergenius.admin.capital.service.impl;

import com.supergenius.admin.capital.model.VCVideoDO;
import com.supergenius.admin.capital.mapper.VCVideoDao;
import com.supergenius.admin.capital.service.IVCVideoService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
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
public class VCVideoServiceImpl extends ServiceImpl<VCVideoDao, VCVideoDO> implements IVCVideoService {


    @Override
    public VCVideoDO getByPid(String pid) {
        return null;
    }
}
