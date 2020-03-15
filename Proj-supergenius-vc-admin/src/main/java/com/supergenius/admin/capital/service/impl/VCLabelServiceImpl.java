package com.supergenius.admin.capital.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.supergenius.admin.capital.model.VCLabelDO;
import com.supergenius.admin.capital.mapper.VCLabelDao;
import com.supergenius.admin.capital.service.IVCLabelService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.supergenius.admin.enums.ELabelType;
import com.supergenius.admin.enums.StatusEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author zuoyu
 * @since 2019-12-04
 */
@Service
public class VCLabelServiceImpl extends ServiceImpl<VCLabelDao, VCLabelDO> implements IVCLabelService {
    @Autowired
    VCLabelDao labelDao;

    @Override
    public List<VCLabelDO> getLableByType(ELabelType eLabelType) {
        LambdaQueryWrapper<VCLabelDO> lambda=new LambdaQueryWrapper<>();
        lambda
                .eq(VCLabelDO::getType,eLabelType)
                .eq(VCLabelDO::getStatus, StatusEnum.ENABLE);
        List<VCLabelDO> vcLabelDOS = labelDao.selectList(lambda);
        return vcLabelDOS;
    }

    @Override
    public Integer addLable(ELabelType eLabelType, String name) {
        LambdaQueryWrapper<VCLabelDO> lambda=new LambdaQueryWrapper<>();
        lambda
                .eq(VCLabelDO::getType,eLabelType);
        List<VCLabelDO> vcLabelDOS = labelDao.selectList(lambda);
        Optional<Integer> maxOrder = vcLabelDOS.stream().max((a, b) -> a.getOrders() - b.getOrders()).map(a -> a.getOrders());
        Integer result = maxOrder.get();
        VCLabelDO vcLabelDO=new VCLabelDO().setName(name).setStatus(StatusEnum.ENABLE).setType(eLabelType).setOrders(result+1);
        int insert = labelDao.insert(vcLabelDO);
        return insert;
    }

    @Override
    public Integer deletet(String uid) {
        LambdaQueryWrapper<VCLabelDO> lambda=new LambdaQueryWrapper<>();
        lambda.eq(VCLabelDO::getUid,uid);
        VCLabelDO vcLabelDO = labelDao.selectOne(lambda);
        vcLabelDO.setStatus(StatusEnum.DISABLE);
        int result = labelDao.updateById(vcLabelDO);
        return result;
    }
}
