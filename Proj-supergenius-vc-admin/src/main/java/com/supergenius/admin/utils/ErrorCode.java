package com.supergenius.admin.utils;

import com.baomidou.mybatisplus.extension.api.IErrorCode;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class ErrorCode implements IErrorCode {
    private long code;
    private String msg;
    @Override
    public long getCode() {
        return code;
    }

    @Override
    public String getMsg() {
        return msg;
    }

    public ErrorCode(long code) {
        this.code = code;
    }
}
