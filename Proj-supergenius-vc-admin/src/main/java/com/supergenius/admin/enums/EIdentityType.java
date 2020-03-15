package com.supergenius.admin.enums;

import com.baomidou.mybatisplus.annotation.EnumValue;
import lombok.Getter;

/**
 * 身份[1:天才投资人,2:天才保荐人,4:天才推荐人,8：天才召集人]
 *
 * @author jiashitao
 * @date 20190928
 */
@Getter
public enum EIdentityType {
    investor(0),
    guarantor(1),
    recommend(2),
    convener(3);
    @EnumValue
    private Integer value;

    private EIdentityType(Integer value) {
        this.value = value;
    }


    public static EIdentityType get(int v) {
        String str = String.valueOf(v);
        return get(str);
    }

    public static EIdentityType get(String str) {
        for (EIdentityType e : values()) {
            if (e.toString().equals(str)) {
                return e;
            }
        }
        return null;
    }

}

