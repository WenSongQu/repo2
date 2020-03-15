package com.supergenius.admin.enums;

import com.baomidou.mybatisplus.annotation.EnumValue;
import lombok.Getter;

@Getter
public enum EProjectStatus {
    freeze(0),
    pause(1),
    ongoing(2),
    complete(3),
    delete(4);
    @EnumValue
    private Integer value;

    private EProjectStatus(Integer value) {
        this.value = value;
    }

    public static EProjectStatus get(int v) {
        String str = String.valueOf(v);
        return get(str);
    }

    public static EProjectStatus get(String str) {
        for (EProjectStatus e : values()) {
            if (e.toString().equals(str)) {
                return e;
            }
        }
        return null;
    }

}
