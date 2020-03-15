package com.supergenius.admin.enums;

import com.baomidou.mybatisplus.annotation.EnumValue;
import lombok.Getter;

@Getter
public enum  EUseStatus {
    normal(0),//正常
    ban(1);//禁止
    @EnumValue
    private Integer value;

    private EUseStatus(Integer value) {
        this.value = value;
    }

}
