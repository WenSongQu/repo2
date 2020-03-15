package com.supergenius.admin.enums;

import com.baomidou.mybatisplus.annotation.EnumValue;
import lombok.Getter;

/**
 * 投资轮次
 *
 * @author jiashitao
 * @date 20190928
 */
@Getter
public enum ERounds {
    Angel(00000001),//天使轮
    A(00000010),//A轮
    B(00000100),//B轮
    C(00001000),//C轮
    D(00010000),//D轮
    E(00100000),//E轮及以上
    PreIPO(01000000);//Pre-IPO
    @EnumValue
    private Integer value;

    private ERounds(Integer value) {
        this.value = value;
    }

    public static ERounds get(int v) {
        String str = String.valueOf(v);
        return get(str);
    }

    public static ERounds get(String str) {
        for (ERounds e : values()) {
            if (e.toString().equals(str)) {
                return e;
            }
        }
        return null;
    }
}
