package com.supergenius.admin.capital.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.supergenius.admin.capital.model.VCMeetingDO;
import com.supergenius.admin.capital.mapper.VCMeetingDao;
import com.supergenius.admin.capital.model.vo.VCFiltrateMeetingVO;
import com.supergenius.admin.capital.service.IVCMeetingService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.supergenius.admin.enums.StatusEnum;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
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
public class VCMeetingServiceImpl extends ServiceImpl<VCMeetingDao, VCMeetingDO> implements IVCMeetingService {
    @Autowired
    VCMeetingDao meetingDao;

    @Override
    public IPage getMeetingDisplayList(Page page, VCFiltrateMeetingVO filtrateMeeting) {
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        LambdaQueryWrapper<VCMeetingDO> lambda=new LambdaQueryWrapper<>();
        lambda
                .like(StringUtils.isNotEmpty(filtrateMeeting.getMname()),VCMeetingDO::getName,filtrateMeeting.getMname())
                .eq(filtrateMeeting.getArea()!=null,VCMeetingDO::getAddress,filtrateMeeting.getArea())
                .le(filtrateMeeting.getMaxArea()!=null,VCMeetingDO::getArea,filtrateMeeting.getMaxArea())
                .ge(filtrateMeeting.getMinArea()!=null,VCMeetingDO::getArea,filtrateMeeting.getMinArea())
                .le(filtrateMeeting.getMaxNumber()!=null,VCMeetingDO::getNumber,filtrateMeeting.getMaxNumber())
                .ge(filtrateMeeting.getMinNumber()!=null,VCMeetingDO::getNumber,filtrateMeeting.getMinNumber())
                .le(filtrateMeeting.getMaxPrice()!=null,VCMeetingDO::getPrice,filtrateMeeting.getMaxPrice())
                .ge(filtrateMeeting.getMinPrice()!=null,VCMeetingDO::getPrice,filtrateMeeting.getMinPrice())
                .le(filtrateMeeting.getMaxSummoney()!=null,VCMeetingDO::getSummoney,filtrateMeeting.getMaxSummoney())
                .ge(filtrateMeeting.getMinSummoney()!=null,VCMeetingDO::getSummoney,filtrateMeeting.getMinSummoney())
                .eq(filtrateMeeting.getStatus()!=null,VCMeetingDO::getStatus,filtrateMeeting.getStatus())
                .le(filtrateMeeting.getShowtimeEnd()!=null,VCMeetingDO::getShowtime,filtrateMeeting.getShowtimeEnd())
                .ge(filtrateMeeting.getShowtimeBegin()!=null,VCMeetingDO::getShowtime,filtrateMeeting.getShowtimeBegin())
                .ne(VCMeetingDO::getStatus, StatusEnum.DISABLE)
                .select(VCMeetingDO::getUid,VCMeetingDO::getName,VCMeetingDO::getAddress,VCMeetingDO::getArea,VCMeetingDO::getNumber,VCMeetingDO::getPrice,VCMeetingDO::getShowtime,VCMeetingDO::getStatus,VCMeetingDO::getSummoney);
        IPage iPage = meetingDao.selectPage(page, lambda);
        return iPage;
    }

    @Override
    public Integer operateMetting(List<String> list,StatusEnum statusEnum) {
        LambdaQueryWrapper<VCMeetingDO> lambda=new LambdaQueryWrapper<>();
        lambda.in(VCMeetingDO::getUid,list);
        VCMeetingDO update=new VCMeetingDO().setStatus(statusEnum);
        int result = meetingDao.update(update, lambda);
        return result;
    }

    @Override
    public VCMeetingDO getByID(String uid) {
        LambdaQueryWrapper<VCMeetingDO> lambda=new LambdaQueryWrapper<>();
        lambda.eq(VCMeetingDO::getUid,uid);
        VCMeetingDO vcMeetingDO = meetingDao.selectOne(lambda);
        return vcMeetingDO;
    }


}
