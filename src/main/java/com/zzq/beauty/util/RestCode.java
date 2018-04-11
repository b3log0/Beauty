package com.zzq.beauty.util;

public enum  RestCode {
    _200(200,"成功"),
    _201(201,"账号已存在！");
    private int code;
    private String message;

    RestCode(int code, String message) {
        this.code = code;
        this.message = message;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
