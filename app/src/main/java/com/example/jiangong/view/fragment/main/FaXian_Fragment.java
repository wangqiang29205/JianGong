package com.example.jiangong.view.fragment.main;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.jiangong.R;
import com.example.jiangong.adapter.FaXianHeng_Adapter;

import java.util.ArrayList;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

/**
 * A simple {@link Fragment} subclass.
 */
public class FaXian_Fragment extends Fragment implements FaXianHeng_Adapter.OnClit {


    @BindView(R.id.faxianfragment_sousuo_img)
    ImageView faxianfragmentSousuoImg;
    @BindView(R.id.faxianfragment_sousuo_edittext)
    EditText faxianfragmentSousuoEdittext;
    @BindView(R.id.faxianfragment_heng_recyclerview)
    RecyclerView faxianfragmentHengRecyclerview;
    @BindView(R.id.faxianfragment_shu_recyclerview)
    RecyclerView faxianfragmentShuRecyclerview;

    Unbinder unbinder;
    ImageView imageView;
    private List<Integer> list;
    private FaXianHeng_Adapter faXianHeng_adapter;
    private LinearLayoutManager linearLayoutManager;

    public FaXian_Fragment(ImageView imageView) {
        // Required empty public constructor
        this.imageView = imageView;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_fa_xian, container, false);
        unbinder = ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        imageView.setVisibility(View.VISIBLE);
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getActivity(), "添加按钮", Toast.LENGTH_SHORT).show();
            }
        });

        linearLayoutManager = new LinearLayoutManager(getActivity());
        linearLayoutManager.setOrientation(RecyclerView.HORIZONTAL);
        faxianfragmentHengRecyclerview.setLayoutManager(linearLayoutManager);

        list = new ArrayList<>();
        list.add(R.mipmap.kaoshiganhuo);
        list.add(R.mipmap.fenxiangqiandao);
        list.add(R.mipmap.wentiqiuzhu);

        if(faXianHeng_adapter==null){
            faXianHeng_adapter = new FaXianHeng_Adapter(getActivity(), list);
            faxianfragmentHengRecyclerview.setAdapter(faXianHeng_adapter);
        }else {
            faxianfragmentHengRecyclerview.setAdapter(faXianHeng_adapter);
        }

        faXianHeng_adapter.setOnClit(this);
    }

    @OnClick({R.id.faxianfragment_sousuo_img})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.faxianfragment_sousuo_img:
                Toast.makeText(getActivity(), "搜索", Toast.LENGTH_SHORT).show();
                break;
        }
    }
    
    
    @Override
    public void onPause() {
        super.onPause();
        imageView.setVisibility(View.GONE);
    }

    @Override
    public void onCli(int potion) {
        if(potion == 0){
            Toast.makeText(getActivity(), "考试干货", Toast.LENGTH_SHORT).show();
        }else if(potion == 1){
            Toast.makeText(getActivity(), "分享签到", Toast.LENGTH_SHORT).show();
        }else if(potion == 2){
            Toast.makeText(getActivity(), "问题求助", Toast.LENGTH_SHORT).show();
        }
    }
}
