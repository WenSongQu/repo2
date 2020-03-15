package com.supergenius.admin.enums;

import com.baomidou.mybatisplus.annotation.EnumValue;
import lombok.Getter;

/**
 * 当企业发展过程中资金短缺时,首选融资方式
 *
 * @author jiashitao
 * @date 20190928
 */
@Getter
public enum EFinancingWay {
    share(0),//股权
    debt(2);//债权
    @EnumValue
    private Integer value;

    private EFinancingWay(Integer value) {
        this.value = value;
    }

}
