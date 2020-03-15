package com.supergenius.admin.enums;

import com.baomidou.mybatisplus.annotation.EnumValue;
import lombok.Getter;

/**
 * 资本类型
 *
 * @author jiashitao
 * @date 20190928
 */
@Getter
public enum ECapitalType {
    domesticstateowned(0),//中资（国有背景）
    domestic(1),//中资（非国有背景）
    foreign(2),//外资
    domesticforeign(3);//中外资（国有背景）
    @EnumValue
    private Integer value;

    private ECapitalType(Integer value) {
        this.value = value;
    }

    public Integer getValue() {
        return this.value;
    }

    public static ECapitalType get(int v) {
        String str = String.valueOf(v);
        return get(str);
    }

    public static ECapitalType get(String str) {
        for (ECapitalType e : values()) {
            if (e.toString().equals(str)) {
                return e;
            }
        }
        return null;
    }

}
