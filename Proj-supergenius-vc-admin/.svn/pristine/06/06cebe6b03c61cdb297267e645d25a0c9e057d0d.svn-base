package com.supergenius.admin.enums;

import com.baomidou.mybatisplus.annotation.EnumValue;
import lombok.Getter;

/**
 * 状态
 *
 * @author jiashitao
 * @date 20190928
 */
@Getter
public enum EStatus {
    disable(0),
    enable(1),
    deleted(2),
    freeze(3),
    init(10),
    start(11),
    wait(12),
    end(13),
    ongoing(22),
    over(23);

    @EnumValue
    private int value;

    private EStatus(int value) {
        this.value = value;
    }


    //获取枚举实例
    public static EStatus get(int v) {
        String str = String.valueOf(v);
        return get(str);
    }

    public static EStatus get(String str) {
        for (EStatus e : values()) {
            if (e.toString().equals(str)) {
                return e;
            }
        }
        return null;
    }


}
