package com.example.jiangong.http;

import com.example.jiangong.utils.Constans;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class GetRetrofit {

    public static ApiUrl getApiUrl(){
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(Constans.BaseUrl_01)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        ApiUrl api = retrofit.create(ApiUrl.class);

        return api;
    }

}
