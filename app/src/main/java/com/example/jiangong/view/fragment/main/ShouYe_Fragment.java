package com.example.jiangong.view.fragment.main;


import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.example.jiangong.R;
import com.example.jiangong.bean.KuMuFengMian_Bean;
import com.example.jiangong.http.BaseView;
import com.example.jiangong.http.Presenter;
import com.example.jiangong.utils.Constans;
import com.example.jiangong.view.login.KaoShiType_Activity;

import java.util.HashMap;
import java.util.Map;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

/**
 * A simple {@link Fragment} subclass.
 */
public class ShouYe_Fragment extends Fragment implements BaseView {


    @BindView(R.id.shy_title_text)
    TextView shyTitleText;
    @BindView(R.id.shy_title_linearlaout)
    LinearLayout shyTitleLinearlaout;
    @BindView(R.id.shy_tianshu_text)
    TextView shyTianshuText;
    @BindView(R.id.shy_lianxi_progressbar)
    ProgressBar shy_lianxi_progressbar;

    @BindView(R.id.shy_moni_linearlayout)
    LinearLayout shyMoniLinearlayout;
    @BindView(R.id.shy_cuoti_linearlayout)
    LinearLayout shyCuotiLinearlayout;
    @BindView(R.id.shy_kaodian_linearlayout)
    LinearLayout shyKaodianLinearlayout;
    @BindView(R.id.shy_gaopin_linearlayout)
    LinearLayout shyGaopinLinearlayout;
    @BindView(R.id.shy_linian_linearlayout)
    LinearLayout shyLinianLinearlayout;
    @BindView(R.id.shy_huiyuan_linearlayout)
    LinearLayout shyHuiyuanLinearlayout;
    @BindView(R.id.shy_yilianxi_text)
    TextView shyYilianxiText;
    @BindView(R.id.shy_zongti_text)
    TextView shyZongtiText;
    @BindView(R.id.shy_jindutiao_progressbar)
    ProgressBar shyJindutiaoProgressbar;
    @BindView(R.id.shy_zuotizong_text)
    TextView shyZuotizongText;
    @BindView(R.id.shy_zhengquelv_text)
    TextView shyZhengquelvText;
    @BindView(R.id.shy_wxhaoyou_linearlayout)
    LinearLayout shyWxhaoyouLinearlayout;
    @BindView(R.id.shy_wxpengyouquan_linearlayout)
    LinearLayout shyWxpengyouquanLinearlayout;
    @BindView(R.id.shy_qqhaoyou_linearlayout)
    LinearLayout shyQqhaoyouLinearlayout;
    @BindView(R.id.shy_qqkongjian_linearlayout)
    LinearLayout shyQqkongjianLinearlayout;

    Unbinder unbinder;
    private Presenter presenter = new Presenter(this);

    public ShouYe_Fragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_shou_ye, container, false);
        unbinder = ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

//
//        shy_lianxi_progressbar
    }

    @Override
    public void onResume() {
        super.onResume();
        Map<String, Object> map = new HashMap<>();
        map.put("uid", Constans.guid);
        map.put("subject_id", Constans.subject_id);
        presenter.kuFengMian(map);
    }

    @Override
    public void onSuccess(Object model) {
        if(model instanceof KuMuFengMian_Bean){
            if(((KuMuFengMian_Bean) model).isResult()){
                KuMuFengMian_Bean kuMuFengMian_bean = (KuMuFengMian_Bean) model;

                shyTitleText.setText(kuMuFengMian_bean.getData().getSubject().getTitle()+kuMuFengMian_bean.getData().getSubject().getSubject_id());

                if(kuMuFengMian_bean.getData().getSubject().getExam_days().equals("")){
                    shyTianshuText.setText("0");
                }else{
                    shyTianshuText.setText(kuMuFengMian_bean.getData().getSubject().getExam_days());
                }

                shyZongtiText.setText(kuMuFengMian_bean.getData().getSubject_all_count()+"道");

                shyZuotizongText.setText("做题总数 "+kuMuFengMian_bean.getData().getSubject_done_count()+" 题");

                shyYilianxiText.setText(kuMuFengMian_bean.getData().getSubject_done_percent()+"%");

                shyZhengquelvText.setText("累计正确率 "+kuMuFengMian_bean.getData().getSubject_done_percent()+"%");


            }else{
                Toast.makeText(getActivity(), ""+((KuMuFengMian_Bean) model).getMessage(), Toast.LENGTH_SHORT).show();
            }
        }
    }

    @Override
    public void onFailed(String msg) {
        Log.i("wangqiang", "onFailed科目封面请求错误: "+msg);
    }

    Intent intent;

    @OnClick({R.id.shy_title_linearlaout, R.id.shy_moni_linearlayout, R.id.shy_cuoti_linearlayout, R.id.shy_kaodian_linearlayout, R.id.shy_gaopin_linearlayout, R.id.shy_linian_linearlayout, R.id.shy_huiyuan_linearlayout, R.id.shy_wxhaoyou_linearlayout, R.id.shy_wxpengyouquan_linearlayout, R.id.shy_qqhaoyou_linearlayout, R.id.shy_qqkongjian_linearlayout})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.shy_title_linearlaout:
//                Toast.makeText(getActivity(), "标题", Toast.LENGTH_SHORT).show();
                intent = new Intent(getActivity(), KaoShiType_Activity.class);
                startActivity(intent);
                break;
            case R.id.shy_moni_linearlayout:
                Toast.makeText(getActivity(), "模拟", Toast.LENGTH_SHORT).show();
                break;
            case R.id.shy_cuoti_linearlayout:
                Toast.makeText(getActivity(), "错题", Toast.LENGTH_SHORT).show();
                break;
            case R.id.shy_kaodian_linearlayout:
                Toast.makeText(getActivity(), "考点", Toast.LENGTH_SHORT).show();
                break;
            case R.id.shy_gaopin_linearlayout:
                Toast.makeText(getActivity(), "高频", Toast.LENGTH_SHORT).show();
                break;
            case R.id.shy_linian_linearlayout:
                Toast.makeText(getActivity(), "历年", Toast.LENGTH_SHORT).show();
                break;
            case R.id.shy_huiyuan_linearlayout:
                Toast.makeText(getActivity(), "会员", Toast.LENGTH_SHORT).show();
                break;
            case R.id.shy_wxhaoyou_linearlayout:
                Toast.makeText(getActivity(), "微信好友", Toast.LENGTH_SHORT).show();
                break;
            case R.id.shy_wxpengyouquan_linearlayout:
                Toast.makeText(getActivity(), "微信朋友圈", Toast.LENGTH_SHORT).show();
                break;
            case R.id.shy_qqhaoyou_linearlayout:
                Toast.makeText(getActivity(), "qq好友", Toast.LENGTH_SHORT).show();
                break;
            case R.id.shy_qqkongjian_linearlayout:
                Toast.makeText(getActivity(), "qq空间", Toast.LENGTH_SHORT).show();
                break;
        }
    }


}
