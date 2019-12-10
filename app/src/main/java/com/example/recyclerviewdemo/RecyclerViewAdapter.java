package com.example.recyclerviewdemo;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.viewHolder> {
    private static final String TAG = "RecyclerViewAdapter";
    private ArrayList<String> Names = new ArrayList<>();
    private ArrayList<String> Birth = new ArrayList<>();
    Context context ;


    public RecyclerViewAdapter(ArrayList<String> names, ArrayList<String> birth, Context context) {
        Names = names;
        Birth = birth;
        this.context = context;
    }


    @NonNull
    @Override
    public viewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.rv_item_layout,parent,false);
        viewHolder holder = new viewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull final viewHolder holder, int position) {
        holder.lblName.setText(Names.get(position));
        holder.lblBirth.setText(Birth.get(position));
        holder.btn.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("ResourceAsColor")
            @Override
            public void onClick(View v) {
                holder.lvParent.setBackgroundColor(Color.GREEN);
            }
        });
    }

    @Override
    public int getItemCount() {
        return Names.size();
    }


    public class viewHolder extends RecyclerView.ViewHolder{
        TextView lblName, lblBirth;
        Button btn;
        LinearLayout lvParent;
        public viewHolder(@NonNull View itemView) {
            super(itemView);
            lvParent = itemView.findViewById(R.id.lvParent);
            lblName = itemView.findViewById(R.id.lblName);
            lblBirth= itemView.findViewById(R.id.lblBirth);
            btn = itemView.findViewById(R.id.btn);
        }
    }

    //添加數據
    public void addData(String name,String birth) {
        int position = Names.size();
        Names.add(name);
        Birth.add(birth);
        notifyItemInserted(position);
    }

}
