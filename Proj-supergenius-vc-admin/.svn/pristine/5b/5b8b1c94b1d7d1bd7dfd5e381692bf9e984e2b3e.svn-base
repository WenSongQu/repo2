package com.supergenius.admin.enums;

import com.baomidou.mybatisplus.annotation.EnumValue;
import lombok.Getter;

/**
 * 发票抬头
 *
 * @author jiashitao
 * @date 20190928
 */
@Getter
public enum EInvoiceHead {
    personal(0),//个人
    company(1);//企业
    @EnumValue
    private Integer value;

    private EInvoiceHead(Integer value) {
        this.value = value;
    }

    public Integer getValue() {
        return this.value;
    }

}
