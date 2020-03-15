package com.supergenius.admin.capital.controller;

import com.supergenius.admin.capital.service.IVCProjectService;
import com.supergenius.admin.capital.service.IVCUserService;
import com.supergenius.admin.utils.RedisUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;
@Api(description="首页的api")
@RestController
public class IndexController {
    @Autowired
    RedisUtil redisUtil;
    @Autowired
    IVCUserService ivcUserService;
    @Autowired
    IVCProjectService ivcProjectService;

    @ApiOperation("\n" +
            "startupSize 创业人数量，investmentSize投资人数量，guarantorSize 天才保荐人数量，recommendSize天才推荐人数量，convenerSize天才召集人，finacingSize正在融资项目数，\n" +
            "allFinacingSize 全部融资项目数，completeSize融资成功项目数，resellingSize 正在转售项目树，allResaleSize全部转售项目数")
    @GetMapping("/index")
    public Map<String,Integer> index(){
         Map<String,Integer>  data =(Map<String,Integer> ) redisUtil.get("data");
        //判断缓存是否存在数据
        if(data!=null){
            System.out.println("走的缓存");
            return data;
        }
        Map<String,Integer> allMap=new HashMap<>();
        Map<String, Integer> projectMap = ivcProjectService.selectProjectCount();
        Map<String, Integer> userMap = ivcUserService.getUserCount();
        allMap.putAll(projectMap);
        allMap.putAll(userMap);
        redisUtil.set("data",allMap,60*60*12);
        return allMap;
    }
}
