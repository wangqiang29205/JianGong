package com.example.jiangong.view.fragment.main;


import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.jiangong.R;
import com.example.jiangong.bean.YanZhengMaLogin_Bean;
import com.example.jiangong.view.login.YanZhengLogin_Activity;
import com.example.jiangong.view.login.ZhangHaoLogin_Activity;

import androidx.fragment.app.Fragment;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

/**
 * A simple {@link Fragment} subclass.
 */
public class WoDe_Fragment extends Fragment {


    @BindView(R.id.myfragment_login_relativelayout)
    RelativeLayout myfragmentLoginRelativelayout;
    @BindView(R.id.myfragment_home_img)
    ImageView myfragmentHomeImg;
    @BindView(R.id.myfragment_biaozhi_img)
    ImageView myfragmentBiaozhiImg;
    @BindView(R.id.myfragment_wodekaoshi_linearlayout)
    LinearLayout myfragmentWodekaoshiLinearlayout;
    @BindView(R.id.myfragment_vipdemo_text)
    TextView myfragmentVipdemoText;
    @BindView(R.id.myfragment_nengli_linearlayout)
    LinearLayout myfragmentNengliLinearlayout;
    @BindView(R.id.myfragment_fatie_linearlayout)
    LinearLayout myfragmentFatieLinearlayout;
    @BindView(R.id.myfragment_jilu_linearlayout)
    LinearLayout myfragmentJiluLinearlayout;
    @BindView(R.id.myfragment_fankui_relativelayout)
    RelativeLayout myfragmentFankuiRelativelayout;
    @BindView(R.id.myfragment_huancun_relativelayout)
    RelativeLayout myfragmentHuancunRelativelayout;
    @BindView(R.id.myfragment_guanyu_relativelayout)
    RelativeLayout myfragmentGuanyuRelativelayout;
    @BindView(R.id.myfragment_gengduoshezhi_relativelayout)
    RelativeLayout myfragmentGengduoshezhiRelativelayout;
    private Intent intent;
    Unbinder unbinder;

    public WoDe_Fragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_wo_de, container, false);
        unbinder = ButterKnife.bind(this, view);
        return view;
    }

    @OnClick({R.id.myfragment_login_relativelayout, R.id.myfragment_home_img, R.id.myfragment_wodekaoshi_linearlayout, R.id.myfragment_nengli_linearlayout, R.id.myfragment_fatie_linearlayout, R.id.myfragment_jilu_linearlayout, R.id.myfragment_fankui_relativelayout, R.id.myfragment_huancun_relativelayout, R.id.myfragment_guanyu_relativelayout, R.id.myfragment_gengduoshezhi_relativelayout})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.myfragment_login_relativelayout:
                intent = new Intent(getActivity(), ZhangHaoLogin_Activity.class);
                intent.putExtra("type",2);
                startActivity(intent);
                break;
            case R.id.myfragment_home_img:
                Toast.makeText(getActivity(), "头像", Toast.LENGTH_SHORT).show();
                break;
            case R.id.myfragment_wodekaoshi_linearlayout:
                Toast.makeText(getActivity(), "我的考试", Toast.LENGTH_SHORT).show();
                break;
            case R.id.myfragment_nengli_linearlayout:
                Toast.makeText(getActivity(), "能力", Toast.LENGTH_SHORT).show();
                break;
            case R.id.myfragment_fatie_linearlayout:
                Toast.makeText(getActivity(), "发帖", Toast.LENGTH_SHORT).show();
                break;
            case R.id.myfragment_jilu_linearlayout:
                Toast.makeText(getActivity(), "记录", Toast.LENGTH_SHORT).show();
                break;
            case R.id.myfragment_fankui_relativelayout:
                Toast.makeText(getActivity(), "反馈", Toast.LENGTH_SHORT).show();
                break;
            case R.id.myfragment_huancun_relativelayout:
                Toast.makeText(getActivity(), "缓存", Toast.LENGTH_SHORT).show();
                break;
            case R.id.myfragment_guanyu_relativelayout:
                Toast.makeText(getActivity(), "关于", Toast.LENGTH_SHORT).show();
                break;
            case R.id.myfragment_gengduoshezhi_relativelayout:
                Toast.makeText(getActivity(), "更多设置", Toast.LENGTH_SHORT).show();
                break;
        }
    }
}
