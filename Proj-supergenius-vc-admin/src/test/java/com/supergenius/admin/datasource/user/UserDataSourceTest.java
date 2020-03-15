package com.supergenius.admin.datasource.user;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.supergenius.admin.BaseProjSupergeniusVcAdminApplicationTests;
import com.supergenius.admin.user.model.USUserDO;
import com.supergenius.admin.user.service.IUSUserService;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.math.BigDecimal;
import java.util.List;

/**
 * @author : zuoyu
 * @project : proj-supergenius-vc-admin
 * @description : user数据源测试
 * @date : 2019-12-05 09:38
 **/
@Slf4j
public class UserDataSourceTest extends BaseProjSupergeniusVcAdminApplicationTests {

    @Autowired
    private IUSUserService iusUserService;

    @Test
    void userTest(){

       // USUserDO usUserDO = new USUserDO();
      //  usUserDO.setUid("qwsdsfdsfsfsfsfsfsf");
     //   boolean save = iusUserService.save(usUserDO);
//        QueryWrapper<USUserDO> queryWrapper=new QueryWrapper<>();
//        queryWrapper.eq("uid","qwsdsfdsfsfsfsfsfsf");
//        List<USUserDO> list = iusUserService.list(queryWrapper);
//        USUserDO usUserDO = list.get(0);
//        usUserDO.setChannelfrom(true);
//        boolean b = iusUserService.updateById(usUserDO);
//        list = iusUserService.list(queryWrapper);
//         usUserDO = list.get(0);
//        list.forEach(System.out::println);

        USUserDO byId = new USUserDO();
        byId.setOid(318);
        byId.setAccount(new BigDecimal(21223));
        boolean b = iusUserService.updateById(byId);
        byId = iusUserService.getById(318);
        System.out.println(byId);


    }


    @Test
    void uuidTest(){
        USUserDO userDO = new USUserDO().setPhone("lala");
        log.info("result:\t" + iusUserService.save(userDO));
    }
}
