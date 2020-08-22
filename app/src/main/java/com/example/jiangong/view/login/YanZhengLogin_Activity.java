package com.example.jiangong.view.login;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.jiangong.R;
import com.example.jiangong.bean.GetYanZhengMa_Bean;
import com.example.jiangong.bean.YanZhengMaLogin_Bean;
import com.example.jiangong.http.BaseView;
import com.example.jiangong.http.Presenter;
import com.example.jiangong.utils.Constans;
import com.example.jiangong.utils.CountDownTimerUtils;
import com.example.jiangong.view.ShouYe_Activity;

import java.util.HashMap;
import java.util.Map;

import androidx.appcompat.app.AppCompatActivity;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class YanZhengLogin_Activity extends AppCompatActivity implements BaseView {

    @BindView(R.id.yanlogin_fanhui_img)
    ImageView yanloginFanhuiImg;
    @BindView(R.id.yanlogin_shoujihao_edittext)
    EditText yanloginShoujihaoEdittext;
    @BindView(R.id.yanlogin_yanzhengma_edittext)
    EditText yanloginYanzhengmaEdittext;
    @BindView(R.id.yanlogin_huoqu_text)
    TextView yanloginHuoquText;
    @BindView(R.id.yanlogin_denglu_button)
    Button yanloginDengluButton;
    @BindView(R.id.yanlogin_zhanghaodenglu_text)
    TextView yanloginZhanghaodengluText;
    @BindView(R.id.yanlogin_xieyi_text)
    TextView yanloginXieyiText;
    @BindView(R.id.yanlogin_zhengce_text)
    TextView yanloginZhengceText;
    private Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_yan_zheng_login);
        ButterKnife.bind(this);
    }

    private Presenter presenter = new Presenter(this);

    @OnClick({R.id.yanlogin_fanhui_img, R.id.yanlogin_huoqu_text, R.id.yanlogin_denglu_button, R.id.yanlogin_zhanghaodenglu_text, R.id.yanlogin_xieyi_text, R.id.yanlogin_zhengce_text,R.id.yanlogin_zhuce_text})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.yanlogin_fanhui_img:
//                Toast.makeText(this, "返回至手机号一键登录", Toast.LENGTH_SHORT).show();
                finish();
                break;

                //获取验证码
            case R.id.yanlogin_huoqu_text:
                if(!yanloginShoujihaoEdittext.getText().toString().equals("")){
                    Map<String,Object> map = new HashMap<>();
                    map.put("mobile",yanloginShoujihaoEdittext.getText().toString());
                    map.put("type","3");
                    presenter.getYanZhengMa(map);
                }else{
                    Toast.makeText(this, "手机号不能为空", Toast.LENGTH_SHORT).show();
                }
                break;

                //验证码登录
            case R.id.yanlogin_denglu_button:
                if(!yanloginShoujihaoEdittext.getText().toString().equals("")&&!yanloginYanzhengmaEdittext.getText().toString().equals("")){
                    Map<String,Object> map = new HashMap<>();
                    map.put("mobile",yanloginShoujihaoEdittext.getText().toString());
                    map.put("code",yanloginYanzhengmaEdittext.getText().toString());
                    presenter.yanZhengMaDengLu(map);
                }else{
                    Toast.makeText(this, "请将信息填写完整", Toast.LENGTH_SHORT).show();
                }
                break;

            case R.id.yanlogin_zhanghaodenglu_text:
                intent = new Intent(this,ZhangHaoLogin_Activity.class);
                startActivity(intent);
                break;

            case R.id.yanlogin_xieyi_text:
                break;

            case R.id.yanlogin_zhengce_text:
                break;

                //去注册
            case  R.id.yanlogin_zhuce_text:
//                Toast.makeText(this, "去注册", Toast.LENGTH_SHORT).show();
                intent = new Intent(this,ZhuCeZhangHao_Activity.class);
                startActivity(intent);
                break;
        }
    }

    @Override
    public void onSuccess(Object model) {
        //获取验证码
        if(model instanceof GetYanZhengMa_Bean){
            if(((GetYanZhengMa_Bean) model).isResult()){
                GetYanZhengMa_Bean getYanZhengMa_bean = (GetYanZhengMa_Bean) model;

                CountDownTimerUtils mCountDownTimerUtils = new CountDownTimerUtils(yanloginHuoquText, 60000, 1000); //倒计时1分钟
                mCountDownTimerUtils.start();
                Toast.makeText(this, "已发送", Toast.LENGTH_SHORT).show();
            }else{
                Toast.makeText(this, ""+((GetYanZhengMa_Bean) model).getMessage(), Toast.LENGTH_SHORT).show();
            }
        }
        //验证码登录
        else if(model instanceof YanZhengMaLogin_Bean){
            if(((YanZhengMaLogin_Bean) model).isResult()){
                YanZhengMaLogin_Bean yanZhengMaLogin_bean = (YanZhengMaLogin_Bean) model;

                //将用户登录信息保存至sp
                //可以创建一个新的SharedPreference来对储存的文件进行操作
                SharedPreferences sp = this.getSharedPreferences("login", Context.MODE_PRIVATE);
                //像SharedPreference中写入数据需要使用Editor
                SharedPreferences.Editor editor = sp.edit();
                //类似键值对
                editor.putBoolean("result", yanZhengMaLogin_bean.isResult());
                editor.putString("guid", yanZhengMaLogin_bean.getData().getGuid());
                editor.putString("username", yanZhengMaLogin_bean.getData().getUsername());
                editor.putString("mobile", yanZhengMaLogin_bean.getData().getMobile());
                editor.putString("avatar", yanZhengMaLogin_bean.getData().getAvatar());
                editor.putString("nickname", yanZhengMaLogin_bean.getData().getNickname());
                editor.putInt("status", yanZhengMaLogin_bean.getData().getStatus());
                editor.putInt("city_id", yanZhengMaLogin_bean.getData().getCity_id());
                editor.putInt("login_type", yanZhengMaLogin_bean.getData().getCity_id());
                editor.putInt("subject_id", yanZhengMaLogin_bean.getData().getSubject_id());
                editor.putString("subject_title", yanZhengMaLogin_bean.getData().getSubject_title());
                editor.commit();


                //将用户登录信息保存至本地
                Constans.result = yanZhengMaLogin_bean.isResult();
                Constans.guid = yanZhengMaLogin_bean.getData().getGuid();
                Constans.username = yanZhengMaLogin_bean.getData().getUsername();
                Constans.mobile = yanZhengMaLogin_bean.getData().getMobile();
                Constans.avatar = yanZhengMaLogin_bean.getData().getAvatar();
                Constans.nickname = yanZhengMaLogin_bean.getData().getNickname();
                Constans.status = yanZhengMaLogin_bean.getData().getStatus();
                Constans.city_id = yanZhengMaLogin_bean.getData().getCity_id();
                Constans.login_type = yanZhengMaLogin_bean.getData().getLogin_type();
                Constans.subject_id = yanZhengMaLogin_bean.getData().getSubject_id();
                Constans.subject_title = yanZhengMaLogin_bean.getData().getSubject_title();

                Intent intent = new Intent(this, ShouYe_Activity.class);
                startActivity(intent);
                finish();
            }
        }
    }

    @Override
    public void onFailed(String msg) {
        Log.i("wangqiang", "onFailed验证码登录页面请求错误: "+msg);
    }
}
