package com.example.jiangong.bean;

import java.util.List;

public class KeMu_Bean {
    /**
     * result : true
     * data : [{"id":1,"title":"建设工程经济","type":1,"completion":0},{"id":2,"title":"建设工程项目管理","type":1,"completion":0},{"id":3,"title":"建设工程法规及相关知识","type":1,"completion":0},{"id":4,"title":"建筑工程","type":2,"completion":0},{"id":5,"title":"机电工程","type":2,"completion":0},{"id":6,"title":"公路工程","type":2,"completion":0},{"id":7,"title":"市政公用工程","type":2,"completion":0},{"id":8,"title":"铁路工程","type":2,"completion":0},{"id":9,"title":"水利水电工程","type":2,"completion":0},{"id":10,"title":"通信与广电","type":2,"completion":0},{"id":11,"title":"民航与机场工程","type":2,"completion":0},{"id":12,"title":"港口与航道工程","type":2,"completion":0},{"id":13,"title":"跨国也工程","type":2,"completion":0}]
     * message : ok
     * code : 200
     */

    private boolean result;
    private String message;
    private int code;
    private List<DataBean> data;

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

    public List<DataBean> getData() {
        return data;
    }

    public void setData(List<DataBean> data) {
        this.data = data;
    }

    public static class DataBean {
        /**
         * id : 1
         * title : 建设工程经济
         * type : 1
         * completion : 0
         */

        private int id;
        private String title;
        private int type;
        private int completion;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public int getType() {
            return type;
        }

        public void setType(int type) {
            this.type = type;
        }

        public int getCompletion() {
            return completion;
        }

        public void setCompletion(int completion) {
            this.completion = completion;
        }
    }
}
