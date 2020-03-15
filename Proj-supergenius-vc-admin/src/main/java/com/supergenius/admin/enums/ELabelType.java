package com.supergenius.admin.enums;

import com.baomidou.mybatisplus.annotation.EnumValue;
import lombok.Getter;

/**
 * 标签类型
 *
 * @author jiashitao
 * @date 20190928
 */
@Getter
public enum ELabelType {
    industry(0),//行业分类
    incubatormeeting(1),//孵化器或会议室
    reportinvestor(2),//举报投资人
    reportproject(3),//举报项目
    reportmessage(4),//举报消息
    reportessay(5);//举报动态
    @EnumValue
    private Integer value;

    private ELabelType(Integer value) {
        this.value = value;
    }

    public static ELabelType get(int v) {
        String str = String.valueOf(v);
        return get(str);
    }

    public static ELabelType get(String str) {
        for (ELabelType e : values()) {
            if (e.toString().equals(str)) {
                return e;
            }
        }
        return null;
    }

}
