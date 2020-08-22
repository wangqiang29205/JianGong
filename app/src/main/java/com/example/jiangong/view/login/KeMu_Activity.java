package com.example.jiangong.view.login;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.jiangong.R;
import com.example.jiangong.adapter.KeMu_Adapter;
import com.example.jiangong.bean.KeMu_Bean;
import com.example.jiangong.bean.KsType_Bean;
import com.example.jiangong.bean.SetKeMu_Bean;
import com.example.jiangong.bean.YouKeLogin_Bean;
import com.example.jiangong.http.BaseView;
import com.example.jiangong.http.Presenter;
import com.example.jiangong.utils.Constans;
import com.example.jiangong.utils.ZaUtil;
import com.example.jiangong.view.ShouYe_Activity;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class KeMu_Activity extends AppCompatActivity implements BaseView, KeMu_Adapter.OnCliLin {

    @BindView(R.id.km_fanhui_img)
    ImageView kmFanhuiImg;
    @BindView(R.id.km_kmxuanze_spinner)
    Spinner kmKmxuanzeSpinner;
    @BindView(R.id.km_list_recyclerview)
    RecyclerView kmListRecyclerview;

    public int xiabiaoid;
    private Presenter presenter = new Presenter(this);
    private List<KeMu_Bean.DataBean> data;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ke_mu);
        ButterKnife.bind(this);


        String string = getIntent().getStringExtra("string");
        String list = getIntent().getStringExtra("list");
        int id = getIntent().getIntExtra("id", 0);
        xiabiaoid = id;
        if (string != null && list != null) {
            Gson gson = new Gson();
            Type listType1 = new TypeToken<List<String>>() {
            }.getType();
            List<String> stringList = gson.fromJson(string, listType1);

            Type listType2 = new TypeToken<List<KsType_Bean.DataBean.SubBean>>() {
            }.getType();
            List<KsType_Bean.DataBean.SubBean> datalist = gson.fromJson(list, listType2);

            Map<String, Object> map = new HashMap<>();
            map.put("cate_id", datalist.get(this.xiabiaoid).getId());
            presenter.getKemu(map);

            ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, stringList);
            //设置下拉列表的风格
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

            kmKmxuanzeSpinner.setAdapter(adapter);
            kmKmxuanzeSpinner.setSelection(xiabiaoid, true);
            /**选项选择监听*/
            kmKmxuanzeSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                @Override
                public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                    xiabiaoid = position;
//                    Toast.makeText(KeMu_Activity.this, "点击了" + stringList.get(position), Toast.LENGTH_SHORT).show();
                    Map<String, Object> map = new HashMap<>();
                    map.put("cate_id", datalist.get(xiabiaoid).getId());
                    presenter.getKemu(map);
                }

                @Override
                public void onNothingSelected(AdapterView<?> parent) {

                }
            });
        }
    }

    @OnClick({R.id.km_fanhui_img})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.km_fanhui_img:
                finish();
                break;
        }
    }

    @Override
    public void onSuccess(Object model) {
        if (model instanceof KeMu_Bean) {
            if (((KeMu_Bean) model).isResult()) {
                KeMu_Bean keMu_bean = (KeMu_Bean) model;
                if (keMu_bean.getData() != null) {
                    data = keMu_bean.getData();

                    LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
                    kmListRecyclerview.setLayoutManager(linearLayoutManager);

                    KeMu_Adapter keMu_adapter = new KeMu_Adapter(KeMu_Activity.this, data);
                    kmListRecyclerview.setAdapter(keMu_adapter);
                    keMu_adapter.setOnCliLin(this);
                    keMu_adapter.notifyDataSetChanged();
                }
            } else {
                Log.i("wangqiang", "onSuccess: " + ((KeMu_Bean) model).getMessage());
            }
        }
        //游客登录
        else if (model instanceof YouKeLogin_Bean) {
            if (((YouKeLogin_Bean) model).isResult()) {
                YouKeLogin_Bean youKeLogin_bean = (YouKeLogin_Bean) model;

                Constans.guid = youKeLogin_bean.getData().getGuid();
                Constans.username = youKeLogin_bean.getData().getUsername();
                Constans.mobile = youKeLogin_bean.getData().getMobile();
                Constans.avatar = youKeLogin_bean.getData().getAvatar();
                Constans.nickname = youKeLogin_bean.getData().getNickname();
                Constans.status = youKeLogin_bean.getData().getStatus();
                Constans.city_id = youKeLogin_bean.getData().getCity_id();
                Constans.login_type = youKeLogin_bean.getData().getLogin_type();
                Constans.subject_id = youKeLogin_bean.getData().getSubject_id();
                Constans.subject_title = youKeLogin_bean.getData().getSubject_title();


                //将用户登录信息保存至sp
                //可以创建一个新的SharedPreference来对储存的文件进行操作
                SharedPreferences sp = this.getSharedPreferences("login", Context.MODE_PRIVATE);
                //像SharedPreference中写入数据需要使用Editor
                SharedPreferences.Editor editor = sp.edit();
                //类似键值对
                editor.putString("guid", youKeLogin_bean.getData().getGuid());
                editor.putString("username", youKeLogin_bean.getData().getUsername());
                editor.putString("mobile", youKeLogin_bean.getData().getMobile());
                editor.putString("avatar", youKeLogin_bean.getData().getAvatar());
                editor.putString("nickname", youKeLogin_bean.getData().getNickname());
                editor.putInt("status", youKeLogin_bean.getData().getStatus());
                editor.putInt("city_id", youKeLogin_bean.getData().getCity_id());
                editor.putString("login_type", youKeLogin_bean.getData().getLogin_type());
                editor.putInt("subject_id", youKeLogin_bean.getData().getSubject_id());
                editor.putString("subject_title", youKeLogin_bean.getData().getSubject_title());
                editor.commit();

                //保存值下次就不会跳转至引导页
                SharedPreferences yindao = getSharedPreferences("qidong", MODE_PRIVATE);
                SharedPreferences.Editor edit = yindao.edit();
                edit.putString("qidong", "1");
                edit.commit();

//                Intent intent = new Intent(this, ShouYe_Activity.class);
//                intent.putExtra("subject_title", youKeLogin_bean.getData().getSubject_title());
//                startActivity(intent);
                Map<String, Object> map1 = new HashMap<>();
                map1.put("uid", Constans.guid);
                map1.put("subject_id", data.get(dianji).getId());
                presenter.setKeMu(map1);
            }else{
                Toast.makeText(this, ""+((YouKeLogin_Bean) model).getMessage(), Toast.LENGTH_SHORT).show();
            }
        }
        //设置会员科目
        if (model instanceof SetKeMu_Bean) {
            if (((SetKeMu_Bean) model).isResult()) {
                SetKeMu_Bean setKeMu_bean = (SetKeMu_Bean) model;
//                Toast.makeText(this, ""+setKeMu_bean.getMessage(), Toast.LENGTH_SHORT).show();

                Intent intent = new Intent(this, ShouYe_Activity.class);
                startActivity(intent);
                finish();
            }
        }
    }

    @Override
    public void onFailed(String msg) {
        Log.i("wangqiang", "onFailed科目请求失败: " + msg);
    }

    private int dianji;

    @Override
    public void onCli(int potion) {
        dianji = potion;
        SharedPreferences sp = getSharedPreferences("qidong", MODE_PRIVATE);
        //第二个参数为缺省值，如果不存在该key，返回缺省值
        String qidong = sp.getString("qidong", "");

        if (qidong.equals("")) {
            Map<String, Object> map = new HashMap<>();
            map.put("idfa", ZaUtil.getAndroidId(this));
            map.put("os", "android");
            map.put("osVersion", "");
            map.put("city_id", "");
            map.put("subject_id", data.get(potion).getId());
            presenter.youKeLogin(map);
        } else {
            Map<String, Object> map1 = new HashMap<>();
            map1.put("uid", Constans.guid);
            map1.put("subject_id", data.get(potion).getId());
            presenter.setKeMu(map1);
        }
    }
}
