package com.example.jiangong.view.fragment;


import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.jiangong.R;
import com.example.jiangong.adapter.KsType_Adater;
import com.example.jiangong.adapter.viewpageradapter.KsAdapter_Adpater;
import com.example.jiangong.bean.KsType_Bean;
import com.example.jiangong.view.login.KeMu_Activity;
import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class KsType_Fragment extends Fragment implements KsType_Adater.OnCliLin{

    List<KsType_Bean.DataBean.SubBean> sub = new ArrayList<>();
    private KsType_Adater ksType_adater;
    private KsType_Adater ksType_adater1;
    private List<String> stringList;


    public KsType_Fragment() {
        // Required empty public constructor
    }

    public static Fragment getFragment(List<KsType_Bean.DataBean.SubBean> sub){
        KsType_Fragment ksType_fragment = new KsType_Fragment();
        ksType_fragment.sub.addAll(sub);
        return ksType_fragment;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_ks_type, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        RecyclerView ksfragment_list_recyclerview = view.findViewById(R.id.ksfragment_list_recyclerview);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity());
        ksfragment_list_recyclerview.setLayoutManager(linearLayoutManager);

        stringList = new ArrayList<>();

        for (int i=0;i<sub.size();i++){
            sub.get(i).type = false;
            stringList.add(sub.get(i).getCate_name());
        }

        ksType_adater1 = new KsType_Adater(getActivity(),sub);
        ksfragment_list_recyclerview.setAdapter(ksType_adater1);
        ksType_adater1.setOnCliLin(this);
    }

    int potion;

    @Override
    public void onCli(int potion,int id) {
        for (int i=0;i<sub.size();i++){
            sub.get(i).type = false;
        }
        sub.get(potion).type = true;
        this.potion = potion;
        ksType_adater1.notifyDataSetChanged();

        Gson gson = new Gson();
        String string = gson.toJson(stringList);
        String list = gson.toJson(sub);
        Intent intent = new Intent(getActivity(), KeMu_Activity.class);
        intent.putExtra("string",string);
        intent.putExtra("list",list);
        intent.putExtra("id",potion);
        startActivity(intent);
    }
}
