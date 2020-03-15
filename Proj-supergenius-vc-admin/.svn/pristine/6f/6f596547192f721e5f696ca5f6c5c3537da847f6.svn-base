package com.supergenius.admin.enums;

import com.baomidou.mybatisplus.annotation.EnumValue;
import lombok.Getter;

/**
 * 身份枚举[0:游客,1:会员]
 *
 * @author jiashitao
 * @date 20190928
 */
@Getter
public enum EIdentity {
    personalstartup(1),//个人创业者
    enterprisestartup(2),//企业创业者
    personalinvestment(3),//个人投资者
    mechanisminvestment(4);//机构投资者
    @EnumValue
    private Integer value;

    private EIdentity(Integer value) {
        this.value = value;
    }

    public static EIdentity get(int v) {
        String str = String.valueOf(v);
        return get(str);
    }

    public static EIdentity get(String str) {
        for (EIdentity e : values()) {
            if (e.toString().equals(str)) {
                return e;
            }
        }
        return null;
    }

}

