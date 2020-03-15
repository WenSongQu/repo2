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
public enum EGender  {
    woman(0),
    man(1);

    @EnumValue
    private int value;

    private EGender(int value) {
        this.value = value;
    }

}
