package com.supergenius.admin.enums;

import com.baomidou.mybatisplus.annotation.EnumValue;
import lombok.Getter;

@Getter
public enum EUsermode {
    normal(0),//创业端
    ban(1),
    due(2);//投资端
    @EnumValue
    private Integer value;

    private EUsermode(Integer value) {
        this.value = value;
    }

}
