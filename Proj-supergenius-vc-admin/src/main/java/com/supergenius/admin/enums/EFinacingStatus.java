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
public enum EFinacingStatus {
    pause(0),//暂停融资
    complete(1),//完成融资
    finacing(3),//融资中
    freeze(4);//已冻结
    @EnumValue
    private Integer value;

    private EFinacingStatus(Integer value) {
        this.value = value;
    }

    public static EFinacingStatus get(int v) {
        String str = String.valueOf(v);
        return get(str);
    }

    public static EFinacingStatus get(String str) {
        for (EFinacingStatus e : values()) {
            if (e.toString().equals(str)) {
                return e;
            }
        }
        return null;
    }

}
