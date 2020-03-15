package com.supergenius.admin.enums;

import com.baomidou.mybatisplus.annotation.EnumValue;
import lombok.Getter;

/**
 * 证件类型(0:身份证,1:护照,2:港澳台居住证)
 *
 * @author jiashitao
 * @date 20190928
 */
@Getter
public enum EIdType {
    idcard(0),
    passport(1),
    residencepermit(2);//居住证，指港澳台
    @EnumValue
    private Integer value;

    private EIdType(Integer value) {
        this.value = value;
    }

    public static EIdType get(int v) {
        String str = String.valueOf(v);
        return get(str);
    }

    public static EIdType get(String str) {
        for (EIdType e : values()) {
            if (e.toString().equals(str)) {
                return e;
            }
        }
        return null;
    }

}
