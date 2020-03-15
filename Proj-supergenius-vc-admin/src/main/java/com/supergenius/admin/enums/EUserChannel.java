package com.supergenius.admin.enums;

import com.baomidou.mybatisplus.annotation.EnumValue;
import lombok.Getter;

/**
 * 用户来自渠道枚举类
 *
 * @author chenminchang
 */
@Getter
public enum EUserChannel {

    userfee("0"),//缴费会员
    specialuser("1"),//特批会员
    inviteuser("2");//邀请会员
    @EnumValue
    private final String value;

    private EUserChannel(String v) {
        this.value = v;
    }

    public String toString() {
        return this.value;
    }

    public static EUserChannel get(int v) {
        String str = String.valueOf(v);
        return get(str);
    }

    public static EUserChannel get(String value) {
        for (EUserChannel e : values()) {
            if (e.toString().equals(value)) {
                return e;
            }
        }
        return null;
    }
}
