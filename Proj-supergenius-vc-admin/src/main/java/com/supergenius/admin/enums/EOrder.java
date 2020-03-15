package com.supergenius.admin.enums;

import com.baomidou.mybatisplus.annotation.EnumValue;
import lombok.Getter;

/**
 * 订单状态
 *
 * @author jiashitao
 * @date 20190928
 */
@Getter
public enum EOrder {
    fail(0),//支付失败
    success(1),//支付成功
    paying(2),//待支付状态
    expired(3),//订单过期
    cancel(4),//取消订单
    pendingrefund(5),//待退款
    refunded(6);//已退款
    @EnumValue
    private Integer value;

    private EOrder(Integer value) {
        this.value = value;
    }

}
