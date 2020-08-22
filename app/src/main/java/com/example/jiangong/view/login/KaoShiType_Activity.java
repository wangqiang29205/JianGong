package com.example.jiangong.view.login;

import android.os.Bundle;
import android.util.Log;

import com.example.jiangong.R;
import com.example.jiangong.adapter.viewpageradapter.KsAdapter_Adpater;
import com.example.jiangong.bean.KsType_Bean;
import com.example.jiangong.http.BaseView;
import com.example.jiangong.http.Presenter;
import com.example.jiangong.view.fragment.KsType_Fragment;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;
import butterknife.BindView;
import butterknife.ButterKnife;
import q.rorbin.verticaltablayout.VerticalTabLayout;

public class KaoShiType_Activity extends AppCompatActivity implements BaseView{

    @BindView(R.id.kstype_title_tablayout)
    VerticalTabLayout kstypeTitleTablayout;
    @BindView(R.id.kstype_view_viewpager)
    ViewPager kstypeViewViewpager;

    private Presenter presenter = new Presenter(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kao_shi_type);
        ButterKnife.bind(this);

        Map<String, Object> map = new HashMap<>();
        presenter.getKsType(map);
    }

    @Override
    public void onSuccess(Object model) {
        if (model instanceof KsType_Bean) {
            if(((KsType_Bean) model).isResult()){
                KsType_Bean ksType_bean = (KsType_Bean) model;
                List<KsType_Bean.DataBean> data = ksType_bean.getData();
                List<String> titlelist = new ArrayList<>();
                List<Fragment> fragmentList = new ArrayList<>();
                for (int i=0;i<data.size();i++){
                    titlelist.add(data.get(i).getCate_name());
                    fragmentList.add(KsType_Fragment.getFragment(data.get(i).getSub()));
                }

                //创建适配器、适配器继承自FragmentPagerAdapter
                KsAdapter_Adpater myPagerAdapter = new KsAdapter_Adpater(getSupportFragmentManager(), titlelist,fragmentList);
                kstypeViewViewpager.setAdapter(myPagerAdapter);//绑定适配器
                kstypeTitleTablayout.setupWithViewPager(kstypeViewViewpager);
            }
        }
    }

    @Override
    public void onFailed(String msg) {
        Log.i("wangqiang", "onFailed考试列表类型请求错误: "+msg);
    }
}
