package com.example.jiangong.bean;

public class GetYanZhengMa_Bean {
    /**
     * result : true
     * data : {"code":9095}
     * message : 发送成功
     * code : 200
     */

    private boolean result;
    private DataBean data;
    private String message;
    private int code;

    public boolean isResult() {
        return result;
    }

    public void setResult(boolean result) {
        this.result = result;
    }

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
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

    public static class DataBean {
        /**
         * code : 9095
         */

        private int code;

        public int getCode() {
            return code;
        }

        public void setCode(int code) {
            this.code = code;
        }
    }
}
