package com.supergenius.admin.enums;

import com.baomidou.mybatisplus.annotation.EnumValue;
import lombok.Getter;

/**
 * 组织形式
 *
 * @author jiashitao
 * @date 20190928
 */
@Getter
public enum EForm {
    company(0),//公司制
    limitedpartnership(1),//有限合伙制
    trust(2);//信托制
    @EnumValue
    private Integer value;

    private EForm(Integer value) {
        this.value = value;
    }

    public static EForm get(int v) {
        String str = String.valueOf(v);
        return get(str);
    }

    public static EForm get(String str) {
        for (EForm e : values()) {
            if (e.toString().equals(str)) {
                return e;
            }
        }
        return null;
    }
}
