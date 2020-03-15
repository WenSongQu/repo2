package com.supergenius.admin.enums;

import com.baomidou.mybatisplus.annotation.EnumValue;
import lombok.Getter;

/**
 * 支付方式
 *
 * @author jiashitao
 * @date 20190928
 */
@Getter
public enum EPayMethod {
    wechatpay(0),//微信支付
    alipay(1),//支付宝
    unionpay(2);//银联
    @EnumValue
    private Integer value;

    private EPayMethod(Integer value) {
        this.value = value;
    }

}
