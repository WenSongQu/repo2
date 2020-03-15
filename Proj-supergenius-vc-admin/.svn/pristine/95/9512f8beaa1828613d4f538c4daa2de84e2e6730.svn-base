package com.supergenius.admin.capital.service.impl;

import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.supergenius.admin.capital.model.VCContentDO;
import com.supergenius.admin.capital.mapper.VCContentDao;
import com.supergenius.admin.capital.service.IVCContentService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.supergenius.admin.enums.ECapitalType;
import com.supergenius.admin.enums.EContentType;
import com.supergenius.admin.enums.ESide;
import com.supergenius.admin.enums.StatusEnum;
import io.swagger.models.auth.In;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Comparator;
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
public class VCContentServiceImpl extends ServiceImpl<VCContentDao, VCContentDO> implements IVCContentService {
    @Autowired
    VCContentDao contentDao;

    //首页创业段轮播图
    @Override
    public List<VCContentDO> getIndexVentureContent() {
        LambdaUpdateWrapper<VCContentDO> lambda = new LambdaUpdateWrapper<>();
        lambda.eq(VCContentDO::getSide, ESide.venture)
                .eq(VCContentDO::getType, EContentType.index)
                .eq(VCContentDO::getStatus, StatusEnum.ENABLE);
        List<VCContentDO> list = contentDao.selectList(lambda);
        return list;
    }

    //首页投资段轮播图
    @Override
    public List<VCContentDO> getIndexCapitalContent() {
        LambdaUpdateWrapper<VCContentDO> lambda = new LambdaUpdateWrapper<>();
        lambda.eq(VCContentDO::getSide, ESide.capital)
                .eq(VCContentDO::getType, EContentType.index)
                .ne(VCContentDO::getStatus, StatusEnum.DISABLE);
        List<VCContentDO> list = contentDao.selectList(lambda);
        return list;
    }

    @Override
    public List<VCContentDO> getContent(ESide side, EContentType type) {
        LambdaUpdateWrapper<VCContentDO> lambda = new LambdaUpdateWrapper<>();
        lambda.eq(VCContentDO::getSide,side)
                .eq(VCContentDO::getType, type)
                .ne(VCContentDO::getStatus, StatusEnum.ENABLE);
        List<VCContentDO> list = contentDao.selectList(lambda);
        return list;
    }

    @Override
    public Boolean statusChange(String uid) {
        LambdaUpdateWrapper<VCContentDO> lambda = new LambdaUpdateWrapper<>();
        lambda.eq(VCContentDO::getUid,uid);
        VCContentDO content = contentDao.selectOne(lambda);
        if(null==content)
            return false;
        if(content.getStatus()==StatusEnum.ENABLE){
            content.setStatus(StatusEnum.freeze);
            int i = contentDao.updateById(content);
            if(i==1){
                return true;
            }
            return false;
        }
        if(content.getStatus()==StatusEnum.freeze){
            content.setStatus(StatusEnum.ENABLE);
            int i = contentDao.updateById(content);
            if(i==1){
                return true;
            }
            return false;
        }
        return false;
    }

    @Override
    public Boolean deleteContent(String uid,ESide side, EContentType type) {
        LambdaUpdateWrapper<VCContentDO> lambda = new LambdaUpdateWrapper<>();
        lambda.eq(VCContentDO::getSide,side)
                .eq(VCContentDO::getType,type)
                .ne(VCContentDO::getStatus,StatusEnum.DISABLE);
        List<VCContentDO> list = contentDao.selectList(lambda);

        VCContentDO temp = list.stream().filter(item -> item.getUid() == uid).findAny().orElse(null);
        if(temp==null){
            return true;
        }
        list.forEach(item->{
            if(item.getUid()==uid){
                item.setStatus(StatusEnum.DISABLE);
                contentDao.updateById(item);
            }else if(item.getOrders()>temp.getOrders()){
                item.setOrders(item.getOrders()-1);
                contentDao.updateById(item);
            }
        });
        return true;
    }

    @Override
    public Integer addContent(VCContentDO content,ESide side, EContentType type) {
        //查询同类轮播图数量
        LambdaUpdateWrapper<VCContentDO> lambda = new LambdaUpdateWrapper<>();
        lambda.eq(VCContentDO::getSide,side)
                .eq(VCContentDO::getType,type)
                .ne(VCContentDO::getStatus,StatusEnum.DISABLE);
        List<VCContentDO> list = contentDao.selectList(lambda);
        if(list==null){
            int insert = contentDao.insert(content.setStatus(StatusEnum.ENABLE).setSide(side).setType(type).setOrders(1));
            return insert;
        }
        VCContentDO contentDO = list.stream().filter(item -> item.getOrders() != null).max((a, b) -> a.getOrders() > b.getOrders() ? 1 : -1).get();
        if(contentDO.getOrders()<5){
            int insert = contentDao.insert(content.setStatus(StatusEnum.ENABLE).setSide(side).setType(type).setOrders(contentDO.getOrders() + 1));
            return insert;
        }
        return 0;
    }

    @Override
    public Integer update(VCContentDO contentDO) {
        int i = contentDao.updateById(contentDO);
        return i;

    }

    @Override
    public void upOrder(ESide side, EContentType type) {
        LambdaUpdateWrapper<VCContentDO> lambda = new LambdaUpdateWrapper<>();
        lambda.eq(VCContentDO::getSide,side)
                .eq(VCContentDO::getType,type)
                .ne(VCContentDO::getStatus,StatusEnum.DISABLE);
        List<VCContentDO> list = contentDao.selectList(lambda);
        if(list==null)
            return;
        Integer maxOrder = list.stream().filter(item -> item.getOrders() != null).max((a, b) -> a.getOrders() > b.getOrders() ? 1 : -1).get().getOrders();
        list.forEach(item->{
            if(item.getOrders()==maxOrder){
                System.out.println(item.getOrders()+"----before");
                item.setOrders(1);
                contentDao.updateById(item);
                System.out.println(item.getOrders()+"----after");
            }else {
                System.out.println(item.getOrders()+"----before");
                item.setOrders(item.getOrders() + 1);
                contentDao.updateById(item);
                System.out.println(item.getOrders()+"----after");
            }
        });
    }

    @Override
    public void downOrder(ESide side, EContentType type) {
        LambdaUpdateWrapper<VCContentDO> lambda = new LambdaUpdateWrapper<>();
        lambda.eq(VCContentDO::getSide,side)
                .eq(VCContentDO::getType,type)
                .ne(VCContentDO::getStatus,StatusEnum.DISABLE);
        List<VCContentDO> list = contentDao.selectList(lambda);
        if(list==null)
            return;
        Integer maxOrder = list.stream().filter(item -> item.getOrders() != null).max((a, b) -> a.getOrders() > b.getOrders() ? 1 : -1).get().getOrders();
        list.forEach(item->{
            if(item.getOrders()==1){
                item.setOrders(maxOrder);
                contentDao.updateById(item);
            }else {
                item.setOrders(item.getOrders() - 1);
                contentDao.updateById(item);
            }
        });

    }

}
