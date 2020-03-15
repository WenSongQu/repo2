package com.supergenius.admin.enums;

import com.baomidou.mybatisplus.annotation.EnumValue;
import lombok.Getter;

/**
 * 组织形式
 *
 * @author jiashitao
 * @date 20190928
 */
@Getter
public enum EOpentime {
    everyday(0),//全年每天
    legalworkingday(1),//法定工作日
    legalholidays(2);//法定节假日
    @EnumValue
    private Integer value;

    private EOpentime(Integer value) {
        this.value = value;
    }

}
