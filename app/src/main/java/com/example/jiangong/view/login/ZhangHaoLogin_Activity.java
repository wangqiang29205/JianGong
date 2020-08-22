package com.example.jiangong.view.login;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.jiangong.R;
import com.example.jiangong.view.ShouYe_Activity;

import androidx.appcompat.app.AppCompatActivity;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class ZhangHaoLogin_Activity extends AppCompatActivity {


    @BindView(R.id.zhlogin_fanhui_img)
    ImageView zhloginFanhuiImg;
    @BindView(R.id.zhlogin_guangguang_text)
    TextView zhloginGuangguangText;
    @BindView(R.id.zhlogin_shoujihao_edittext)
    EditText zhloginShoujihaoEdittext;
    @BindView(R.id.zhlogin_mima_edittext)
    EditText zhloginMimaEdittext;
    @BindView(R.id.zhlogin_kejian_img)
    ImageView zhloginKejianImg;
    @BindView(R.id.zhlogin_denglu_button)
    Button zhloginDengluButton;
    @BindView(R.id.zhlogin_yanzhengma_text)
    TextView zhloginYanzhengmaText;
    @BindView(R.id.zhlogin_wangji_text)
    TextView zhloginWangjiText;
    @BindView(R.id.zhlogin_zhuce_text)
    TextView zhloginZhuceText;
    @BindView(R.id.zhlogin_xieyi_text)
    TextView zhloginXieyiText;
    @BindView(R.id.zhlogin_zhengce_text)
    TextView zhloginZhengceText;
    private Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_zhang_hao_login);
        ButterKnife.bind(this);

        //
        int type = getIntent().getIntExtra("type", 1);
        if(type!=1){
            zhloginGuangguangText.setVisibility(View.INVISIBLE);
        }
    }

    @OnClick({R.id.zhlogin_fanhui_img, R.id.zhlogin_guangguang_text, R.id.zhlogin_kejian_img, R.id.zhlogin_denglu_button, R.id.zhlogin_yanzhengma_text, R.id.zhlogin_wangji_text, R.id.zhlogin_zhuce_text, R.id.zhlogin_xieyi_text, R.id.zhlogin_zhengce_text})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.zhlogin_fanhui_img:
                finish();
                break;

            case R.id.zhlogin_guangguang_text:
                intent = new Intent(this, KaoShiType_Activity.class);
                startActivity(intent);
                finish();
                break;

            case R.id.zhlogin_kejian_img:
                break;

            case R.id.zhlogin_denglu_button:
                break;

                //验证码登录
            case R.id.zhlogin_yanzhengma_text:
                intent = new Intent(this,YanZhengLogin_Activity.class);
                startActivity(intent);
                break;

                //忘记密码
            case R.id.zhlogin_wangji_text:
                intent = new Intent(this,WangJiZhangHao_Activity.class);
                startActivity(intent);
                break;

            case R.id.zhlogin_zhuce_text:
                intent = new Intent(this,ZhuCeZhangHao_Activity.class);
                startActivity(intent);
                break;
            case R.id.zhlogin_xieyi_text:
                break;
            case R.id.zhlogin_zhengce_text:
                break;
        }
    }
}
