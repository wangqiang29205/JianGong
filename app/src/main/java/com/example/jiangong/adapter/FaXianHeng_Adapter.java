package com.example.jiangong.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.example.jiangong.R;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class FaXianHeng_Adapter extends RecyclerView.Adapter<FaXianHeng_Adapter.Holder> {

    private Context context;
    private List<Integer> integerList;

    OnClit onClit;

    public void setOnClit(OnClit onClit) {
        this.onClit = onClit;
    }

    public FaXianHeng_Adapter(Context context, List<Integer> integerList) {
        this.context = context;
        this.integerList = integerList;
    }

    @NonNull
    @Override
    public Holder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new Holder(LayoutInflater.from(context).inflate(R.layout.faxianheng_layout, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull Holder holder, int position) {
        Glide.with(context).load(integerList.get(position)).into(holder.faxianheng_adapter_img);
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onClit.onCli(position);
            }
        });
    }

    @Override
    public int getItemCount() {
        return integerList.size();
    }

    class Holder extends RecyclerView.ViewHolder{

        ImageView faxianheng_adapter_img;

        public Holder(@NonNull View itemView) {
            super(itemView);
            faxianheng_adapter_img = itemView.findViewById(R.id.faxianheng_adapter_img);
        }
    }

    public interface OnClit{
        void onCli(int potion);
    }

}
