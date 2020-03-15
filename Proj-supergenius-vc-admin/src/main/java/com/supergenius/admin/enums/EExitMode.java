package com.supergenius.admin.enums;

import com.baomidou.mybatisplus.annotation.EnumValue;
import lombok.Getter;

/**
 * 项目的目标退出方式
 *
 * @author jiashitao
 * @date 20190928
 */
@Getter
public enum EExitMode {
    ipo(0),//IPO
    merger(1),//并购
    repurchase(2),//企业回购
    shareresale(3);//股份转售
    @EnumValue
    private Integer value;

    private EExitMode(Integer value) {
        this.value = value;
    }

}
