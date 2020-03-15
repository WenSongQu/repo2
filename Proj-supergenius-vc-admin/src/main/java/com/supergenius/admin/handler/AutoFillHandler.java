package com.supergenius.admin.handler;

import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import com.supergenius.admin.constants.SysConst;
import com.supergenius.admin.utils.CodeUtil;
import org.apache.commons.lang3.StringUtils;
import org.apache.ibatis.reflection.MetaObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.UUID;

/**
 * @author : zuoyu
 * @project : proj-supergenius-vc-admin
 * @description : Mybatis-Plus的自动填充
 * @date : 2019-12-06 10:19
 **/
@Component
public class AutoFillHandler implements MetaObjectHandler {

    private static final Logger LOGGER = LoggerFactory.getLogger(AutoFillHandler.class);

    //自动填充createtime字段
    @Override
    public void insertFill(MetaObject metaObject) {
        LOGGER.info("start insert fill ....");
        boolean hasSetter = metaObject.hasSetter(SysConst.createtime);
        if (hasSetter) {
            Object value = getFieldValByName(SysConst.createtime, metaObject);
            if (value == null) {
                //this.setFieldValByName("createtime", new Date(), metaObject);//版本号3.0.6以及之前的版本
                this.setFieldValByName(SysConst.createtime, new Date(), metaObject);
                //this.setInsertFieldValByName(SysConst.createtime, new Date(), metaObject);//@since 快照：3.0.7.2-SNAPSHOT， @since 正式版暂未发布3.0.7
            }
        }
        if (metaObject.hasSetter("uid") && StringUtils.isEmpty((CharSequence) metaObject.getValue("uid"))) {
            this.setFieldValByName("uid", CodeUtil.getUUID(), metaObject);
        }
    }


    @Override
    public void updateFill(MetaObject metaObject) {

    }

    private String uuidGenerator() {
        return UUID.randomUUID().toString().replaceAll("-", "");
    }
}
