package com.supergenius.admin.enums;

import com.baomidou.mybatisplus.annotation.EnumValue;
import lombok.Getter;

/**
 * 注册通道:0:手机号,1:qq,2:微信,3:微博:4:超天才
 *
 * @author jiashitao
 * @date 20190928
 */
@Getter
public enum EChannel {
    mobile(0),
    qq(1),
    wechat(2),
    sina(3),
    supergenius(4);
    @EnumValue
    private Integer value;

    private EChannel(Integer value) {
        this.value = value;
    }
}
