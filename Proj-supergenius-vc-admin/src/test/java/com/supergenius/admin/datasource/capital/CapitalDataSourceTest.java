package com.supergenius.admin.datasource.capital;

import com.supergenius.admin.BaseProjSupergeniusVcAdminApplicationTests;
import com.supergenius.admin.capital.model.VCInvestmentDO;
import com.supergenius.admin.capital.model.VCMeetingDO;
import com.supergenius.admin.capital.model.VCUserDO;
import com.supergenius.admin.capital.service.IVCInvestmentService;
import com.supergenius.admin.capital.service.IVCMeetingService;
import com.supergenius.admin.capital.service.IVCUserService;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.UUID;

/**
 * @author : zuoyu
 * @project : proj-supergenius-vc-admin
 * @description : capital数据源测试
 * @date : 2019-12-05 09:36
 **/
@Slf4j
public class CapitalDataSourceTest extends BaseProjSupergeniusVcAdminApplicationTests {

    @Autowired
    private IVCUserService ivcUserService;

    @Autowired
    private IVCMeetingService ivcMeetingService;
    @Autowired
    private IVCInvestmentService ivcInvestmentService;


    @Test
    void capitalTest(){
        VCUserDO userDO = new VCUserDO().setUseruid(UUID.randomUUID().toString().replaceAll("-", "")).setIdcardimg("test");
        log.info("save result:\t" + ivcUserService.save(userDO));
    }

    @Test
    void uuidTest(){
        VCMeetingDO meetingDO = new VCMeetingDO().setName("hello");
        log.info("save result:\t" + ivcMeetingService.save(meetingDO));
    }
    @Test
    void  testIv(){
        VCInvestmentDO d1044b3a080148b4ae64f75ebd005cc7 = ivcInvestmentService.getInvestmentInfo("d1044b3a080148b4ae64f75ebd005cc7");
        System.out.println(d1044b3a080148b4ae64f75ebd005cc7);
    }
}
