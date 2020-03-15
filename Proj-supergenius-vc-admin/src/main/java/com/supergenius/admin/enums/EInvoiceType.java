package com.supergenius.admin.enums;

import com.baomidou.mybatisplus.annotation.EnumValue;
import lombok.Getter;

/**
 * 发票类型
 *
 * @author jiashitao
 * @date 20190928
 */
@Getter
public enum EInvoiceType {
    electronic(0),//电子发票
    paper(1);//纸质发票
    @EnumValue
    private Integer value;

    private EInvoiceType(Integer value) {
        this.value = value;
    }

}
