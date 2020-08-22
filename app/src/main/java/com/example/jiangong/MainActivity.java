package com.example.jiangong;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;

import com.example.jiangong.utils.Constans;
import com.example.jiangong.utils.ZaUtil;
import com.example.jiangong.view.ShouYe_Activity;
import com.example.jiangong.view.login.YanZhengLogin_Activity;
import com.example.jiangong.view.login.ZhangHaoLogin_Activity;

import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity {

    private SharedPreferences sp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        sp = getSharedPreferences("qidong",MODE_PRIVATE);
        //第二个参数为缺省值，如果不存在该key，返回缺省值
        String qidong= sp.getString("qidong","");

        if(qidong.equals("")){
            Intent intent = new Intent(this, ZhangHaoLogin_Activity.class);
            startActivity(intent);
            finish();
        }else{
            //如果不需要引导说明之前走过
            //取值
            sp =getSharedPreferences("login",MODE_PRIVATE);
            Constans.guid = sp.getString("guid","");
            Constans.username = sp.getString("username","");
            Constans.mobile = sp.getString("mobile","");
            Constans.avatar = sp.getString("avatar","");
            Constans.nickname = sp.getString("nickname","");
            Constans.status = sp.getInt("status",0);
            Constans.city_id = sp.getInt("city_id",0);
            Constans.login_type = sp.getString("login_type","");
            Constans.subject_id = sp.getInt("subject_id",0);
            Constans.subject_title = sp.getString("subject_title","");

            Intent intent = new Intent(this,ShouYe_Activity.class);
            startActivity(intent);
            finish();
        }

    }

}
