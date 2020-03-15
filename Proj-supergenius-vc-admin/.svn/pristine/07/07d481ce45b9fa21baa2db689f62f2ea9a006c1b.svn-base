package com.supergenius.admin.enums;

/**
 * 返回结果枚举类
 *
 * @author jiashitao
 * @date 20190928
 */
public enum EResult {
    FAILED(404, "失败"),
    SUCCESS(200, "成功"),
    /* 参数错误：1000～1999 */
    PARAM_NOT_VALID(1001, "参数无效"),
    PARAM_IS_BLANK(1002, "参数为空"),
    PARAM_TYPE_ERROR(1003, "参数类型错误"),
    PARAM_NOT_COMPLETE(1004, "参数缺失"),
    PARAM_ILLEGAL_FORMAT(0010, "格式不正确"),

    /* 用户错误 */
    USER_NOT_LOGIN(2001, "用户未登录"),
    USER_ACCOUNT_EXPIRED(2002, "账号已过期"),
    USER_CREDENTIALS_ERROR(2003, "密码错误"),
    USER_CREDENTIALS_EXPIRED(2004, "密码过期"),
    USER_ACCOUNT_DISABLE(2005, "账号不可用"),
    USER_ACCOUNT_LOCKED(2006, "账号被锁定"),
    USER_ACCOUNT_NOT_EXIST(2007, "账号不存在"),
    USER_ACCOUNT_ALREADY_EXIST(2008, "账号已存在"),
    USER_ACCOUNT_USE_BY_OTHERS(2009, "账号下线"),
    USER_TOKEN_EXPIRED(2010, "令牌过期"),

    /* 业务错误 */
    NO_PERMISSION(3001, "没有权限"),
    SYSTEM_ERROR(9999, "系统异常");

    private int code;
    private String msg;

    public int getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }

    private EResult(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }
}
