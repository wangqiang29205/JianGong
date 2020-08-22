package com.example.jiangong.http;

public interface BaseView<T> {

    void onSuccess(T model);

    void onFailed(String msg);
}
