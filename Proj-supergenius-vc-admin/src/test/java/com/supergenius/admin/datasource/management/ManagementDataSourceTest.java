package com.supergenius.admin.datasource.management;

import com.supergenius.admin.BaseProjSupergeniusVcAdminApplicationTests;
import com.supergenius.admin.management.service.IMGAdminService;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author : zuoyu
 * @project : proj-supergenius-vc-admin
 * @description : management数据源测试
 * @date : 2019-12-05 09:37
 **/
@Slf4j
public class ManagementDataSourceTest extends BaseProjSupergeniusVcAdminApplicationTests {

    @Autowired
    private IMGAdminService imgAdminService;

    @Test
    void adminTest(){
        imgAdminService.list().forEach(System.out::println);
    }
}
