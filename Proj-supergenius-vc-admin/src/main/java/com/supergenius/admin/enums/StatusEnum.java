package com.supergenius.admin.enums;

import com.baomidou.mybatisplus.annotation.EnumValue;
import lombok.Getter;

/**
 * 状态
 *
 * @author zuoyu
 */
@Getter
public enum StatusEnum {
    /**
     * 冻结
     */
    DISABLE(0,"删除"),
    /**
     * 未删除
     */
    ENABLE(1,"可用"),
    freeze(3,"冻结");

    StatusEnum(int code, String descp) {
        this.code = code;
        this.descp = descp;
    }

    @EnumValue
    private final int code;
    private final String descp;


}
