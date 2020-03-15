package com.supergenius.admin.capital.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.supergenius.admin.capital.model.VCCommentDO;
import com.supergenius.admin.capital.mapper.VCCommentDao;
import com.supergenius.admin.capital.service.IVCCommentService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author zuoyu
 * @since 2019-12-04
 */
@Service
public class VCCommentServiceImpl extends ServiceImpl<VCCommentDao, VCCommentDO> implements IVCCommentService {
    @Autowired
    VCCommentDao commentDao;


    @Override
    public List<VCCommentDO> getByPid(String pid) {
        LambdaQueryWrapper<VCCommentDO> lambda=new LambdaQueryWrapper<>();
        lambda.eq(VCCommentDO::getEssayuid,pid);
        List<VCCommentDO> result = commentDao.selectList(lambda);
        return result;
    }
}
