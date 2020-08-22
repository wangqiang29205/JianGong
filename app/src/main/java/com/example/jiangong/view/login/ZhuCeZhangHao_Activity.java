package com.example.jiangong.view.login;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.jiangong.R;
import com.example.jiangong.http.BaseView;
import com.example.jiangong.http.Presenter;
import com.example.jiangong.utils.ZaUtil;

import java.util.HashMap;
import java.util.Map;

import androidx.appcompat.app.AppCompatActivity;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
//注册
public class ZhuCeZhangHao_Activity extends AppCompatActivity implements BaseView {

    @BindView(R.id.zhuce_fanhui_img)
    ImageView zhuceFanhuiImg;
    @BindView(R.id.zhuce_shoujihao_edittext)
    EditText zhuceShoujihaoEdittext;
    @BindView(R.id.zhuce_mima_edittext)
    EditText zhuceMimaEdittext;
    @BindView(R.id.zhuce_mima2_edittext)
    EditText zhuceMima2Edittext;
    @BindView(R.id.zhuce_tijiao_button)
    Button zhuceTijiaoButton;
    @BindView(R.id.zhuce_xieyi_text)
    TextView zhuceXieyiText;
    @BindView(R.id.zhuce_zhengce_text)
    TextView zhuceZhengceText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_zhu_ce);
        ButterKnife.bind(this);
    }

    @Override
    public void onSuccess(Object model) {

    }

    @Override
    public void onFailed(String msg) {

    }

    private Presenter presenter = new Presenter(this);

    @OnClick({R.id.zhuce_fanhui_img, R.id.zhuce_tijiao_button, R.id.zhuce_xieyi_text, R.id.zhuce_zhengce_text})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            //返回
            case R.id.zhuce_fanhui_img:
                finish();
                break;

                //提交
            case R.id.zhuce_tijiao_button:
                if(zhuceMimaEdittext.getText().toString().equals(zhuceMima2Edittext.getText().toString())){
                        Map<String, Object> map = new HashMap<>();
                        map.put("idfa", ZaUtil.getAndroidId(this));
                        map.put("os", "android");
                        map.put("osVersion", "android");
//                        map.put("city_id", chengshiid);
//                        map.put("type_id", jiazhaoid);
//                    presenter.ZhuCe(map);
                }else{
                    Toast.makeText(this, "两次密码不一致", Toast.LENGTH_SHORT).show();
                }
                break;

            case R.id.zhuce_xieyi_text:
                break;

            case R.id.zhuce_zhengce_text:
                break;
        }
    }
}
