package com.supergenius.admin.capital.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.supergenius.admin.capital.mapper.VCCommentDao;
import com.supergenius.admin.capital.model.VCCommentDO;
import com.supergenius.admin.capital.model.VCEssayDO;
import com.supergenius.admin.capital.mapper.VCEssayDao;
import com.supergenius.admin.capital.model.vo.VCEssayVO;
import com.supergenius.admin.capital.model.vo.VCFiltrateEssayVO;
import com.supergenius.admin.capital.service.IVCEssayService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.supergenius.admin.enums.StatusEnum;
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
public class VCEssayServiceImpl extends ServiceImpl<VCEssayDao, VCEssayDO> implements IVCEssayService {
    @Autowired
    VCEssayDao essayDao;
    @Autowired
    VCCommentDao commentDao;

    @Override
    public IPage<VCEssayVO> getAll(Page page, VCFiltrateEssayVO filtrate) {
        IPage<VCEssayVO> iPage = essayDao.getAll(page, filtrate);
        List<VCEssayVO> records = iPage.getRecords();
        //获取点赞数
        //获取评论数
        records.forEach(item->{
            LambdaQueryWrapper<VCCommentDO> lambda=new LambdaQueryWrapper<>();
            lambda.eq(VCCommentDO::getEssayuid,item.getUid());
            int size = commentDao.selectList(lambda).size();
            item.setCommentnum(size);
        });
        iPage.setRecords(records);
        return iPage;
    }

    @Override
    public VCEssayVO getByUid(String uid) {
        return essayDao.getByUid(uid);
    }

    @Override
    public Integer deleteEssay(String uid) {
        //先获取只身
        int result=0;
        LambdaQueryWrapper<VCCommentDO> lambda=new LambdaQueryWrapper<>();
        lambda.eq(VCCommentDO::getUid,uid);
        VCCommentDO vcCommentDO = commentDao.selectOne(lambda);
        vcCommentDO.setStatus(StatusEnum.DISABLE);
        int i = commentDao.updateById(vcCommentDO);
        result+=i;
        //循环删除子评论
        while (true){
            String fatherUid = vcCommentDO.getUid();
            LambdaQueryWrapper<VCCommentDO> tempLambda=new LambdaQueryWrapper<>();
            tempLambda.eq(VCCommentDO::getUid,fatherUid);
             vcCommentDO = commentDao.selectOne(lambda);
             if (vcCommentDO==null)
                 break;
             vcCommentDO.setStatus(StatusEnum.DISABLE);
            int i1 = commentDao.updateById(vcCommentDO);
            result+=i1;
        }
        return result;
    }
}
