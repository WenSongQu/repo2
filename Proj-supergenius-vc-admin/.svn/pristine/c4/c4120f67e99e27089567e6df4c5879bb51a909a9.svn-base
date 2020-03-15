package com.supergenius.admin.enums;

import com.baomidou.mybatisplus.annotation.EnumValue;
import lombok.Getter;

/**
 * 活动状态【未发布、报名中、报名结束、活动中、已结束】
 *
 * @author jiashitao
 * @date 20190928
 */
@Getter
public enum EActivity {
    sigup(0),//报名中
    endsigup(1),//报名结束
    activity(2),//活动中
    endactivity(3);//活动结束
    @EnumValue
    private Integer value;

    private EActivity(Integer value) {
        this.value = value;
    }

    public Integer getValue() {
        return this.value;
    }

}
