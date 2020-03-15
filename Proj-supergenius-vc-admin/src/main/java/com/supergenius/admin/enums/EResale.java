package com.supergenius.admin.enums;

import com.baomidou.mybatisplus.annotation.EnumValue;
import lombok.Getter;

/**
 * 性别
 *
 * @author jiashitao
 * @date 20190928
 */
@Getter
public enum EResale {
    pause(0),//暂停转售
    reselling(1),//转售中
    freeze(2);//已冻结
    @EnumValue
    private Integer value;

    private EResale(Integer value) {
        this.value = value;
    }


    public static EResale get(int v) {
        String str = String.valueOf(v);
        return get(str);
    }

    public static EResale get(String str) {
        for (EResale e : values()) {
            if (e.toString().equals(str)) {
                return e;
            }
        }
        return null;
    }
}
