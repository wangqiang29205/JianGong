package com.example.jiangong.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.jiangong.R;
import com.example.jiangong.bean.KsType_Bean;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class KsType_Adater extends RecyclerView.Adapter<KsType_Adater.Holder> {

    private Context context;
    private List<KsType_Bean.DataBean.SubBean> subBeanList;
    OnCliLin onCliLin;

    public void setOnCliLin(OnCliLin onCliLin) {
        this.onCliLin = onCliLin;
    }


    public KsType_Adater(Context context, List<KsType_Bean.DataBean.SubBean> subBeanList) {
        this.context = context;
        this.subBeanList = subBeanList;
    }

    @NonNull
    @Override
    public Holder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new Holder(LayoutInflater.from(context).inflate(R.layout.tstype_layout,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull Holder holder, int position) {
        holder.tstype_kemu_text.setText(subBeanList.get(position).getCate_name());
        if(subBeanList.get(position).type){
            holder.tstype_xuanzhong_img.setVisibility(View.VISIBLE);
        }else{
            holder.tstype_xuanzhong_img.setVisibility(View.GONE);
        }

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onCliLin.onCli(position,subBeanList.get(position).getId());
            }
        });
    }

    @Override
    public int getItemCount() {
        return subBeanList.size();
    }

    class Holder extends RecyclerView.ViewHolder{

        TextView tstype_kemu_text;
        ImageView tstype_xuanzhong_img;

        public Holder(@NonNull View itemView) {
            super(itemView);
            tstype_kemu_text = itemView.findViewById(R.id.tstype_kemu_text);
            tstype_xuanzhong_img = itemView.findViewById(R.id.tstype_xuanzhong_img);
        }
    }

    public interface OnCliLin{
        void onCli(int potion,int id);
    }
}
