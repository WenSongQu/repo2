package com.supergenius.admin.utils;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.supergenius.admin.capital.mapper.VCContentDao;
import com.supergenius.admin.capital.mapper.VCOrdersDao;
import com.supergenius.admin.capital.model.VCContentDO;
import com.supergenius.admin.capital.model.vo.VCRefundTradeInfoVO;
import com.supergenius.admin.capital.service.IVCContentService;
import com.supergenius.admin.capital.service.IVCLabelService;
import com.supergenius.admin.enums.EContentType;
import com.supergenius.admin.enums.ELabelType;
import com.supergenius.admin.enums.EOrder;
import com.supergenius.admin.enums.ESide;
import com.supergenius.admin.security.model.AuthorityVO;
import com.supergenius.admin.security.service.Authorities;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 * @author : qws
 * @project : proj-supergenius-vc-admin
 * @description : 工具测试类
 * @date : 2019-12-05 09:36
 **/
public class UtilsTest {
    @Autowired
    VCContentDao vcContentDao;
    @Autowired
    IVCContentService contentService;
    @Autowired
    VCOrdersDao vcOrdersDao;
    @Autowired
    IVCLabelService ivcLabelService;


    @Test
    void jsonTest() throws IOException, URISyntaxException {
//        String s = Files.lines(Paths.get(ClassLoader.getSystemResource("static/authorities.json").toURI())).collect(Collectors.joining());
//        Objects.requireNonNull(JsonUtil.jsonStringToList(s, AuthorityVO.class)).forEach(System.out::println);
        vcContentDao.insert(new VCContentDO());
    }
    @Test
    void tes1t(){
        String s = ImgUtil.resizeImage(20, 20, "D:\\Images\\63b3a0901322958e3fef806d76bf5555.png");

    }

    @Test
    void authoritiesTest(){
        Authorities.getInstance().authorityList().forEach(System.out::println);
    }

    @Test
    void  test(){
        System.out.println(vcOrdersDao);
//        IPage<VCRefundTradeInfoVO> allRefundTradeInfo = vcOrdersDao.getAllRefundTradeInfo(new Page(10, 10), 6);
//        allRefundTradeInfo.getRecords().forEach(System.out::println);

    }
    @Test
    void test2(){
        Integer qqq = ivcLabelService.addLable(ELabelType.industry, "QQQ");
        System.out.println(qqq);
    }
}
