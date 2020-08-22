package com.example.jiangong.bean;

import java.util.List;

public class KsType_Bean {
    /**
     * result : true
     * data : [{"id":2,"cate_name":"一二级建造师","sub":[{"id":3,"cate_name":"一级建造师"},{"id":4,"cate_name":"二级建造师"}]},{"id":5,"cate_name":"注册安全工程师","sub":[{"id":6,"cate_name":"初级注册安全工程师"},{"id":7,"cate_name":"中级注册安全工程师"}]},{"id":8,"cate_name":"消防工程师","sub":[{"id":9,"cate_name":"一级消防工程师"},{"id":10,"cate_name":"二级消防工程师"}]},{"id":11,"cate_name":"注册测绘师","sub":[]}]
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
         * id : 2
         * cate_name : 一二级建造师
         * sub : [{"id":3,"cate_name":"一级建造师"},{"id":4,"cate_name":"二级建造师"}]
         */

        private int id;
        private String cate_name;
        private List<SubBean> sub;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getCate_name() {
            return cate_name;
        }

        public void setCate_name(String cate_name) {
            this.cate_name = cate_name;
        }

        public List<SubBean> getSub() {
            return sub;
        }

        public void setSub(List<SubBean> sub) {
            this.sub = sub;
        }

        public static class SubBean {
            /**
             * id : 3
             * cate_name : 一级建造师
             */

            private int id;
            private String cate_name;
            public boolean type;

            public int getId() {
                return id;
            }

            public void setId(int id) {
                this.id = id;
            }

            public String getCate_name() {
                return cate_name;
            }

            public void setCate_name(String cate_name) {
                this.cate_name = cate_name;
            }
        }
    }
}
