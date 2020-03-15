package com.supergenius.admin.enums;

import com.baomidou.mybatisplus.annotation.EnumValue;
import lombok.Getter;

/**
 * 路演还是企业培训
 *
 * @author jiashitao
 * @date 20190928
 */
@Getter
public enum ETrainactivityType{
    roadshow(0),//人名币
    corporatetraining(1);//美元
    @EnumValue
    private Integer value;

    private ETrainactivityType(Integer value) {
        this.value = value;
    }

}
