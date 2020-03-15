package com.supergenius.admin.utils;

import java.util.Random;
import java.util.UUID;

public class CodeUtil {
    /**
     * 随机获取UID字符串(无中划线)
     *
     * @return UUID字符串
     */
    public static String getUUID() {
        String uuid = UUID.randomUUID().toString();
        return uuid.substring(0, 8) + uuid.substring(9, 13) + uuid.substring(14, 18) + uuid.substring(19, 23) + uuid.substring(24);
    }

    /**
     * 获取VIP会员编号
     *
     * @return
     */
    public static String getVipCode() {
        String prefix = "SGGI";
        String num = DateUtil.NowTime().toString(DateUtil.FORMAT_DATE_SHORT);
        String randomStr = getRandomStr(6);
        return prefix + num + randomStr;
    }

    /**
     * 获取报名编号
     *
     * @return
     */
    public static String getSignupCode() {
        String num = DateUtil.NowTime().toString(DateUtil.FORMAT_DATE_LONG);
        String randomStr = getRandomStr(4);
        return num + randomStr;
    }

    /**
     * 产生随机的数字字符串,最大6位
     *
     * @return
     */
    public static String getRandomStr(int length) {
        Random rad = new Random();
        String result = rad.nextInt(1000000) + "";
        if (result.length() != length) {
            return getRandomStr(length);
        }
        return result;
    }
}
