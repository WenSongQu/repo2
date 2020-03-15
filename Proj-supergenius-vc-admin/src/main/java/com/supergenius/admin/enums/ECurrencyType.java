package com.supergenius.admin.enums;

import com.baomidou.mybatisplus.annotation.EnumValue;
import lombok.Getter;

/**
 * 币种
 *
 * @author jiashitao
 * @date 20190928
 */
@Getter
public enum ECurrencyType {
    CNY(0),//人名币
    USD(1);//美元
    @EnumValue
    private Integer value;

    private ECurrencyType(Integer value) {
        this.value = value;
    }

    public static ECurrencyType get(int v) {
        String str = String.valueOf(v);
        return get(str);
    }

    public static ECurrencyType get(String str) {
        for (ECurrencyType e : values()) {
            if (e.toString().equals(str)) {
                return e;
            }
        }
        return null;
    }

}
