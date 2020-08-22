package com.example.jiangong.bean;

public class KuMuFengMian_Bean {
    /**
     * result : true
     * data : {"subject":{"subject_id":1,"title":"建设工程经济","exam_days":""},"daily_practice":"0/100","exam_score":3,"subject_all_count":2632,"subject_done_count":0,"subject_done_percent":0,"subject_correct_percent":0,"practice":{"chapter_id":6,"chapter_name":"第一章","exam_id":20}}
     * message : ok
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
         * subject : {"subject_id":1,"title":"建设工程经济","exam_days":""}
         * daily_practice : 0/100
         * exam_score : 3
         * subject_all_count : 2632
         * subject_done_count : 0
         * subject_done_percent : 0
         * subject_correct_percent : 0
         * practice : {"chapter_id":6,"chapter_name":"第一章","exam_id":20}
         */

        private SubjectBean subject;
        private String daily_practice;
        private String exam_score;
        private int subject_all_count;
        private int subject_done_count;
        private int subject_done_percent;
        private int subject_correct_percent;
        private PracticeBean practice;

        public SubjectBean getSubject() {
            return subject;
        }

        public void setSubject(SubjectBean subject) {
            this.subject = subject;
        }

        public String getDaily_practice() {
            return daily_practice;
        }

        public void setDaily_practice(String daily_practice) {
            this.daily_practice = daily_practice;
        }

        public String getExam_score() {
            return exam_score;
        }

        public void setExam_score(String exam_score) {
            this.exam_score = exam_score;
        }

        public int getSubject_all_count() {
            return subject_all_count;
        }

        public void setSubject_all_count(int subject_all_count) {
            this.subject_all_count = subject_all_count;
        }

        public int getSubject_done_count() {
            return subject_done_count;
        }

        public void setSubject_done_count(int subject_done_count) {
            this.subject_done_count = subject_done_count;
        }

        public int getSubject_done_percent() {
            return subject_done_percent;
        }

        public void setSubject_done_percent(int subject_done_percent) {
            this.subject_done_percent = subject_done_percent;
        }

        public int getSubject_correct_percent() {
            return subject_correct_percent;
        }

        public void setSubject_correct_percent(int subject_correct_percent) {
            this.subject_correct_percent = subject_correct_percent;
        }

        public PracticeBean getPractice() {
            return practice;
        }

        public void setPractice(PracticeBean practice) {
            this.practice = practice;
        }

        public static class SubjectBean {
            /**
             * subject_id : 1
             * title : 建设工程经济
             * exam_days :
             */

            private int subject_id;
            private String title;
            private String exam_days;

            public int getSubject_id() {
                return subject_id;
            }

            public void setSubject_id(int subject_id) {
                this.subject_id = subject_id;
            }

            public String getTitle() {
                return title;
            }

            public void setTitle(String title) {
                this.title = title;
            }

            public String getExam_days() {
                return exam_days;
            }

            public void setExam_days(String exam_days) {
                this.exam_days = exam_days;
            }
        }

        public static class PracticeBean {
            /**
             * chapter_id : 6
             * chapter_name : 第一章
             * exam_id : 20
             */

            private int chapter_id;
            private String chapter_name;
            private int exam_id;

            public int getChapter_id() {
                return chapter_id;
            }

            public void setChapter_id(int chapter_id) {
                this.chapter_id = chapter_id;
            }

            public String getChapter_name() {
                return chapter_name;
            }

            public void setChapter_name(String chapter_name) {
                this.chapter_name = chapter_name;
            }

            public int getExam_id() {
                return exam_id;
            }

            public void setExam_id(int exam_id) {
                this.exam_id = exam_id;
            }
        }
    }
}
