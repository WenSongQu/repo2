package com.supergenius.admin.enums;

import com.baomidou.mybatisplus.annotation.EnumValue;
import lombok.Getter;

/**
 * 记录类型
 *
 * @author jiashitao
 * @date 20190928
 */
@Getter
public enum ERecordType {
    investment(0),//投资记录
    guarantee(1),//保荐记录
    ecomrmended(2),//推荐记录
    convene(3);//召集记录
    @EnumValue
    private Integer value;

    private ERecordType(Integer value) {
        this.value = value;
    }

    public static ERecordType get(int v) {
        String str = String.valueOf(v);
        return get(str);
    }

    public static ERecordType get(String str) {
        for (ERecordType e : values()) {
            if (e.toString().equals(str)) {
                return e;
            }
        }
        return null;
    }

}
