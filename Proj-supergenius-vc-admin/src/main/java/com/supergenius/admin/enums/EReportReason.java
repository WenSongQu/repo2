package com.supergenius.admin.enums;

import com.baomidou.mybatisplus.annotation.EnumValue;
import lombok.Getter;

/**
 * 举报原因
 *
 * @author jiashitao
 * @date 20190928
 */
@Getter
public enum EReportReason{
    falseinformation(0),//发布虚假信息
    harassment(1),//发布不适当内容对我造成骚扰
    deceive(2),//存在欺诈骗钱行为
    stealing(3),//此账号可能被盗用了
    infringement(4),//存在侵权行为
    pretending(5),//冒充他人
    other(6);
    @EnumValue
    private Integer value;

    private EReportReason(Integer value) {
        this.value = value;
    }


}
