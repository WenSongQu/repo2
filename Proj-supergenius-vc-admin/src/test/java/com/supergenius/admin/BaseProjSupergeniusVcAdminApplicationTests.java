package com.supergenius.admin;

import com.supergenius.admin.capital.mapper.VCContentDao;
import com.supergenius.admin.capital.model.VCContentDO;
import com.supergenius.admin.capital.service.IVCLabelService;
import com.supergenius.admin.enums.ELabelType;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.web.WebAppConfiguration;

/**
 * 注意测试时候模块分包测试，不要在这里测试
 */
@SpringBootTest
@WebAppConfiguration
public abstract class BaseProjSupergeniusVcAdminApplicationTests {
    @Autowired
    VCContentDao vcContentDao;
    @Autowired
    IVCLabelService ivcLabelService;



    @Test
    void contextLoads() {
        vcContentDao.insert(new VCContentDO());
    }
    @Test
    void test2(){
        Integer qqq = ivcLabelService.addLable(ELabelType.industry, "QQQ");
        System.out.println(qqq);
    }

}
