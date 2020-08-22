package com.example.jiangong.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.jiangong.R;
import com.example.jiangong.bean.KeMu_Bean;

import org.w3c.dom.Text;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class KeMu_Adapter extends RecyclerView.Adapter<KeMu_Adapter.Holder> {

    private Context context;
    private List<KeMu_Bean.DataBean> list;
    OnCliLin onCliLin;

    public void setOnCliLin(OnCliLin onCliLin) {
        this.onCliLin = onCliLin;
    }

    public KeMu_Adapter(Context context, List<KeMu_Bean.DataBean> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public Holder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new Holder(LayoutInflater.from(context).inflate(R.layout.kemu_layout,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull Holder holder, int position) {
        holder.kemu_title_text.setText(list.get(position).getTitle());
        holder.kemu_jindu_text.setText(list.get(position).getCompletion()+"%");

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onCliLin.onCli(position);
            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class Holder extends RecyclerView.ViewHolder{
        TextView kemu_title_text;
        TextView kemu_jindu_text;
        public Holder(@NonNull View itemView) {
            super(itemView);
            kemu_title_text = itemView.findViewById(R.id.kemu_title_text);
            kemu_jindu_text = itemView.findViewById(R.id.kemu_jindu_text);
        }
    }

    public interface OnCliLin{
        void onCli(int potion);
    }

}
