package com.example.jiangong.bean;

public class SetKeMu_Bean {
    /**
     * result : true
     * message : 切换成功
     * code : 200
     */

    private boolean result;
    private String message;
    private int code;

    public boolean isResult() {
        return result;
    }

    public void setResult(boolean result) {
        this.result = result;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }
}
