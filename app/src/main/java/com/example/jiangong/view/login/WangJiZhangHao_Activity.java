package com.example.jiangong.view.login;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.jiangong.R;

import androidx.appcompat.app.AppCompatActivity;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class WangJiZhangHao_Activity extends AppCompatActivity {

    @BindView(R.id.wjzhanghao_fanhui_img)
    ImageView wjzhanghaoFanhuiImg;
    @BindView(R.id.wjzhanghao_shoujihao_edittext)
    EditText wjzhanghaoShoujihaoEdittext;
    @BindView(R.id.wjzhanghao_yanzhengma_edittext)
    EditText wjzhanghaoYanzhengmaEdittext;
    @BindView(R.id.wjzhanghao_huoqu_text)
    TextView wjzhanghaoHuoquText;
    @BindView(R.id.wjzhanghao_mima_edittext)
    EditText wjzhanghaoMimaEdittext;
    @BindView(R.id.wjzhanghao_kejian_img)
    ImageView wjzhanghaoKejianImg;
    @BindView(R.id.wjzhanghao_tijiao_button)
    Button wjzhanghaoTijiaoButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wang_ji);
        ButterKnife.bind(this);
    }

    @OnClick({R.id.wjzhanghao_fanhui_img, R.id.wjzhanghao_huoqu_text, R.id.wjzhanghao_kejian_img, R.id.wjzhanghao_tijiao_button})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.wjzhanghao_fanhui_img:
                finish();
                break;

            case R.id.wjzhanghao_huoqu_text:
                break;
            case R.id.wjzhanghao_kejian_img:
                break;
            case R.id.wjzhanghao_tijiao_button:
                break;
        }
    }
}
