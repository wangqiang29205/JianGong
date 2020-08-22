package com.example.jiangong.http;

import com.example.jiangong.bean.GetYanZhengMa_Bean;
import com.example.jiangong.bean.KeMu_Bean;
import com.example.jiangong.bean.KsType_Bean;
import com.example.jiangong.bean.KuMuFengMian_Bean;
import com.example.jiangong.bean.SetKeMu_Bean;
import com.example.jiangong.bean.YanZhengMaLogin_Bean;
import com.example.jiangong.bean.YouKeLogin_Bean;

import java.util.Map;

import retrofit2.Call;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.Header;
import retrofit2.http.POST;

public interface ApiUrl {

    //获取验证码
    @FormUrlEncoded
    @POST("api/SendCode")
    Call<GetYanZhengMa_Bean> getYanZhengMa(@Header("sign") String sign, @FieldMap Map<String, Object> map);

    //验证码登录
    @FormUrlEncoded
    @POST("api/login_sms")
    Call<YanZhengMaLogin_Bean> yanZhengMaDengLu(@Header("sign") String sign, @FieldMap Map<String, Object> map);

    //验证码登录
    @FormUrlEncoded
    @POST("api/exam_category")
    Call<KsType_Bean> getKsType(@Header("sign") String sign, @FieldMap Map<String, Object> map);

    //获取科目
    @FormUrlEncoded
    @POST("api/exam_subject")
    Call<KeMu_Bean> getKemu(@Header("sign") String sign, @FieldMap Map<String, Object> map);

    //游客登录
    @FormUrlEncoded
    @POST("api/visitor")
    Call<YouKeLogin_Bean> youKeLogin(@Header("sign") String sign, @FieldMap Map<String, Object> map);

    //设置会员科目
    @FormUrlEncoded
    @POST("api/set_subject")
    Call<SetKeMu_Bean> setKeMu(@Header("sign") String sign, @FieldMap Map<String, Object> map);

    //设置会员科目
    @FormUrlEncoded
    @POST("api/subject_cover")
    Call<KuMuFengMian_Bean> kuFengMian(@Header("sign") String sign, @FieldMap Map<String, Object> map);
}
