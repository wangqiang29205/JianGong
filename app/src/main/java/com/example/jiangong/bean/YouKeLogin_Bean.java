package com.example.jiangong.bean;

public class YouKeLogin_Bean {
    /**
     * result : true
     * data : {"guid":"23E5CB3D143547A7E87F75EEEA94B45F","username":"94B45F","mobile":"","avatar":"http://127.0.0.1/upload/avatar.png","nickname":"JK_94B45F","status":1,"city_id":1,"login_type":"游客","subject_id":1,"subject_title":"建设工程经济"}
     * message : 登录成功
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
         * guid : 23E5CB3D143547A7E87F75EEEA94B45F
         * username : 94B45F
         * mobile :
         * avatar : http://127.0.0.1/upload/avatar.png
         * nickname : JK_94B45F
         * status : 1
         * city_id : 1
         * login_type : 游客
         * subject_id : 1
         * subject_title : 建设工程经济
         */

        private String guid;
        private String username;
        private String mobile;
        private String avatar;
        private String nickname;
        private int status;
        private int city_id;
        private String login_type;
        private int subject_id;
        private String subject_title;

        public String getGuid() {
            return guid;
        }

        public void setGuid(String guid) {
            this.guid = guid;
        }

        public String getUsername() {
            return username;
        }

        public void setUsername(String username) {
            this.username = username;
        }

        public String getMobile() {
            return mobile;
        }

        public void setMobile(String mobile) {
            this.mobile = mobile;
        }

        public String getAvatar() {
            return avatar;
        }

        public void setAvatar(String avatar) {
            this.avatar = avatar;
        }

        public String getNickname() {
            return nickname;
        }

        public void setNickname(String nickname) {
            this.nickname = nickname;
        }

        public int getStatus() {
            return status;
        }

        public void setStatus(int status) {
            this.status = status;
        }

        public int getCity_id() {
            return city_id;
        }

        public void setCity_id(int city_id) {
            this.city_id = city_id;
        }

        public String getLogin_type() {
            return login_type;
        }

        public void setLogin_type(String login_type) {
            this.login_type = login_type;
        }

        public int getSubject_id() {
            return subject_id;
        }

        public void setSubject_id(int subject_id) {
            this.subject_id = subject_id;
        }

        public String getSubject_title() {
            return subject_title;
        }

        public void setSubject_title(String subject_title) {
            this.subject_title = subject_title;
        }
    }
}
