package com.supergenius.admin.enums;

import com.baomidou.mybatisplus.annotation.EnumValue;
import lombok.Getter;

/**
 * 内容表的内容类型
 *
 * @author jiashitao
 * @date 20190928
 */
@Getter
public enum ESide {
    venture(0),//创业端
    capital(1);//投资端
    @EnumValue
    private Integer value;

    private ESide(Integer value) {
        this.value = value;
    }

}
