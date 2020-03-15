package com.supergenius.admin.enums;

import com.baomidou.mybatisplus.annotation.EnumValue;
import lombok.Getter;

/**
 * 订单类型
 *
 * @author jiashitao
 * @date 20190928
 */
@Getter
public enum EOrderType {
    member(0),//会员订单
    roadshowvideo(1),//购买路演视频费
    meeting(2),//预约会议室付款
    roadshowsignup(3),//路演报名费
    course(4),//购买课程付款
    guarantee(5),//保荐
    recommend(6),//推荐
    convene(7);//召集
    @EnumValue
    private Integer value;

    private EOrderType(Integer value) {
        this.value = value;
    }

}
