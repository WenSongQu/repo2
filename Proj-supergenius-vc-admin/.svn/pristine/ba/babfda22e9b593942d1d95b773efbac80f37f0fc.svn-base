package com.supergenius.admin.enums;

import com.baomidou.mybatisplus.annotation.EnumValue;
import lombok.Getter;

/**
 * 项目阶段
 */
@Getter
public enum EStage {
    seed(0),//种子期
    growth(1),//成长期
    development(2),//发展期
    maturity(3),//成熟期
    preipo(4),//Pre-IPO
    all(5);//All（投资阶段可以选择投资全部阶段）
    @EnumValue
    private Integer value;

    private EStage(Integer value) {
        this.value = value;
    }

    public Integer getValue() {
        return this.value;
    }

    public static EStage get(int v) {
        String str = String.valueOf(v);
        return get(str);
    }

    public static EStage get(String str) {
        for (EStage e : values()) {
            if (e.toString().equals(str)) {
                return e;
            }
        }
        return null;
    }

}
