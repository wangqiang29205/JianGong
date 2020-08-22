package com.example.jiangong.view;

import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.example.jiangong.R;
import com.example.jiangong.view.fragment.main.FaXian_Fragment;
import com.example.jiangong.view.fragment.main.ShouYe_Fragment;
import com.example.jiangong.view.fragment.main.WoDe_Fragment;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

//首页activity
public class ShouYe_Activity extends AppCompatActivity {

    @BindView(R.id.main3_qiehuan_fragment)
    FrameLayout main3QiehuanFragment;
    @BindView(R.id.radio1)
    RadioButton radio1;
    @BindView(R.id.radio2)
    RadioButton radio2;
    @BindView(R.id.radio3)
    RadioButton radio3;
    @BindView(R.id.rg_main)
    RadioGroup rgMain;
    @BindView(R.id.shouye_tianjia_img)
    ImageView shouyeTianjiaImg;

    private ShouYe_Fragment shouYe_fragment;
    private FaXian_Fragment faXian_fragment;
    private WoDe_Fragment woDe_fragment;

    private FragmentTransaction fragmentTransaction;
    private FragmentManager fragmentManage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shou_ye);
        ButterKnife.bind(this);
        if (shouYe_fragment == null) {
            shouYe_fragment = new ShouYe_Fragment();
            replaceFragment(shouYe_fragment);
        } else {
            replaceFragment(shouYe_fragment);
        }
    }

    //然后直接创建这个方法根据id添加
    private void replaceFragment(Fragment fragment) {
        //获取管理器   在活动里直接get获取
        fragmentManage = ShouYe_Activity.this.getSupportFragmentManager();
        //获取事务
        fragmentTransaction = fragmentManage.beginTransaction();
//        //添加一个fragment
//        fragmentTransaction.add(R.id.main3_qiehuan_fragment,fragment);
//        //删除一个fragment
//        fragmentTransaction.remove(fragment);
        //添加或替换一个fragment
        fragmentTransaction.replace(R.id.main3_qiehuan_fragment, fragment);
        //操作完记得提交，否则全扯淡
        fragmentTransaction.commit();
//        fragmentTransaction.show(fragment);
    }

    @OnClick({R.id.radio1, R.id.radio2, R.id.radio3})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.radio1:
                if (shouYe_fragment == null) {
                    shouYe_fragment = new ShouYe_Fragment();
                    replaceFragment(shouYe_fragment);
                } else {
                    replaceFragment(shouYe_fragment);
                }
                break;
            case R.id.radio2:
                if (faXian_fragment == null) {
                    faXian_fragment = new FaXian_Fragment(shouyeTianjiaImg);
                    replaceFragment(faXian_fragment);
                } else {
                    replaceFragment(faXian_fragment);
                }
                break;
            case R.id.radio3:
                if (woDe_fragment == null) {
                    woDe_fragment = new WoDe_Fragment();
                    replaceFragment(woDe_fragment);
                } else {
                    replaceFragment(woDe_fragment);
                }
                break;
        }
    }

    private long exitTime = 0;

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK && event.getAction() == KeyEvent.ACTION_DOWN) {
            //两秒之内按返回键就会退出
            if ((System.currentTimeMillis() - exitTime) > 2000) {
                Toast.makeText(this, "再按一次退出程序", Toast.LENGTH_SHORT).show();
                exitTime = System.currentTimeMillis();
            } else {
                finish();
            }
            return true;
        }
        return false;
    }
}
