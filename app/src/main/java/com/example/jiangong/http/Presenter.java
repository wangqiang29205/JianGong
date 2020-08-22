package com.example.jiangong.http;


import android.util.Log;

import com.example.jiangong.bean.GetYanZhengMa_Bean;
import com.example.jiangong.bean.KeMu_Bean;
import com.example.jiangong.bean.KsType_Bean;
import com.example.jiangong.bean.KuMuFengMian_Bean;
import com.example.jiangong.bean.SetKeMu_Bean;
import com.example.jiangong.bean.YanZhengMaLogin_Bean;
import com.example.jiangong.bean.YouKeLogin_Bean;
import com.example.jiangong.utils.Constans;
import com.example.jiangong.utils.StringUtil;
import com.example.jiangong.utils.ZaUtil;

import java.util.Map;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class Presenter{

    private BaseView baseView1;

    public Presenter(BaseView baseView2) {
        this.baseView1 = baseView2;
    }

    //获取验证码
    public void  getYanZhengMa(Map<String, Object> map){
        ApiUrl api = GetRetrofit.getApiUrl();
        Call<GetYanZhengMa_Bean> demo = api.getYanZhengMa(ZaUtil.MD5(StringUtil.getKeyValues(map) + Constans.ToKen), map);
        demo.enqueue(new Callback<GetYanZhengMa_Bean>() {
            @Override
            public void onResponse(Call<GetYanZhengMa_Bean> call, Response<GetYanZhengMa_Bean> response) {
                baseView1.onSuccess(response.body());
            }

            @Override
            public void onFailure(Call<GetYanZhengMa_Bean> call, Throwable t) {
                baseView1.onFailed(t.getMessage());
            }
        });
    }

    //验证码登录
    public void  yanZhengMaDengLu(Map<String, Object> map){
        ApiUrl api = GetRetrofit.getApiUrl();
        Call<YanZhengMaLogin_Bean> demo = api.yanZhengMaDengLu(ZaUtil.MD5(StringUtil.getKeyValues(map) + Constans.ToKen), map);
        demo.enqueue(new Callback<YanZhengMaLogin_Bean>() {
            @Override
            public void onResponse(Call<YanZhengMaLogin_Bean> call, Response<YanZhengMaLogin_Bean> response) {
                baseView1.onSuccess(response.body());
            }

            @Override
            public void onFailure(Call<YanZhengMaLogin_Bean> call, Throwable t) {
                baseView1.onFailed(t.getMessage());
            }
        });
    }

    //注册
    public void  ZhuCe(Map<String, Object> map){
        ApiUrl api = GetRetrofit.getApiUrl();
        Call<YanZhengMaLogin_Bean> demo = api.yanZhengMaDengLu(ZaUtil.MD5(StringUtil.getKeyValues(map) + Constans.ToKen), map);
        demo.enqueue(new Callback<YanZhengMaLogin_Bean>() {
            @Override
            public void onResponse(Call<YanZhengMaLogin_Bean> call, Response<YanZhengMaLogin_Bean> response) {
                baseView1.onSuccess(response.body());
            }

            @Override
            public void onFailure(Call<YanZhengMaLogin_Bean> call, Throwable t) {
                baseView1.onFailed(t.getMessage());
            }
        });
    }

    //考试类型
    public void  getKsType(Map<String, Object> map){
        ApiUrl api = GetRetrofit.getApiUrl();
        Call<KsType_Bean> demo = api.getKsType(ZaUtil.MD5(StringUtil.getKeyValues(map) + Constans.ToKen), map);
        demo.enqueue(new Callback<KsType_Bean>() {
            @Override
            public void onResponse(Call<KsType_Bean> call, Response<KsType_Bean> response) {
                baseView1.onSuccess(response.body());
            }

            @Override
            public void onFailure(Call<KsType_Bean> call, Throwable t) {
                baseView1.onFailed(t.getMessage());
            }
        });
    }

    //获取科目
    public void  getKemu(Map<String, Object> map){
        ApiUrl api = GetRetrofit.getApiUrl();
        Call<KeMu_Bean> demo = api.getKemu(ZaUtil.MD5(StringUtil.getKeyValues(map) + Constans.ToKen), map);
        demo.enqueue(new Callback<KeMu_Bean>() {
            @Override
            public void onResponse(Call<KeMu_Bean> call, Response<KeMu_Bean> response) {
                baseView1.onSuccess(response.body());
            }

            @Override
            public void onFailure(Call<KeMu_Bean> call, Throwable t) {
                baseView1.onFailed(t.getMessage());
            }
        });
    }

    //游客登录
    public void  youKeLogin(Map<String, Object> map){
        ApiUrl api = GetRetrofit.getApiUrl();
        Call<YouKeLogin_Bean> demo = api.youKeLogin(ZaUtil.MD5(StringUtil.getKeyValues(map) + Constans.ToKen), map);
        demo.enqueue(new Callback<YouKeLogin_Bean>() {
            @Override
            public void onResponse(Call<YouKeLogin_Bean> call, Response<YouKeLogin_Bean> response) {
                baseView1.onSuccess(response.body());
            }

            @Override
            public void onFailure(Call<YouKeLogin_Bean> call, Throwable t) {
                baseView1.onFailed(t.getMessage());
            }
        });
    }

    //设置会员科目
    public void  setKeMu(Map<String, Object> map){
        ApiUrl api = GetRetrofit.getApiUrl();
        Call<SetKeMu_Bean> demo = api.setKeMu(ZaUtil.MD5(StringUtil.getKeyValues(map) + Constans.ToKen), map);
        demo.enqueue(new Callback<SetKeMu_Bean>() {
            @Override
            public void onResponse(Call<SetKeMu_Bean> call, Response<SetKeMu_Bean> response) {
                baseView1.onSuccess(response.body());
            }

            @Override
            public void onFailure(Call<SetKeMu_Bean> call, Throwable t) {
                baseView1.onFailed(t.getMessage());
            }
        });
    }

    //科目封面
    public void  kuFengMian(Map<String, Object> map){
        ApiUrl api = GetRetrofit.getApiUrl();
        Call<KuMuFengMian_Bean> demo = api.kuFengMian(ZaUtil.MD5(StringUtil.getKeyValues(map) + Constans.ToKen), map);
        demo.enqueue(new Callback<KuMuFengMian_Bean>() {
            @Override
            public void onResponse(Call<KuMuFengMian_Bean> call, Response<KuMuFengMian_Bean> response) {
                baseView1.onSuccess(response.body());
            }

            @Override
            public void onFailure(Call<KuMuFengMian_Bean> call, Throwable t) {
                baseView1.onFailed(t.getMessage());
            }
        });
    }
}
