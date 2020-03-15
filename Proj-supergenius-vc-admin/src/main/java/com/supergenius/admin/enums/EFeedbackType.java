package com.supergenius.admin.enums;

import com.baomidou.mybatisplus.annotation.EnumValue;
import lombok.Getter;

/**
 * 反馈表的内容类型
 *
 * @author jiashitao
 * @date 20190928
 */
@Getter
public enum EFeedbackType {
    user(0),//用户
    essay(1),//帖子
    reportinvestor(2),//举报投资人
    reportproject(3),//举报项目
    reportmessage(4),//举报消息
    reportessay(5);//举报动态

    @EnumValue
    private Integer value;

    private EFeedbackType(Integer value) {
        this.value = value;
    }

}
