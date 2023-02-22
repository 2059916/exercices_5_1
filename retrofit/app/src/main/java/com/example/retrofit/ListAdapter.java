package com.example.retrofit;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class ListAdapter extends RecyclerView.Adapter<ListAdapter.MyViewHolder> {
    public List<Object> list;

    @Override
    public MyViewHolder onCreateViewHolder( ViewGroup parent, int viewType) {
        LinearLayout v = (LinearLayout) LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item, parent, false);
        MyViewHolder vh = new MyViewHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder( MyViewHolder holder, int position) {
        Long aLong = (Long) list.get(position);
        holder.a.setText(aLong.toString());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public ListAdapter(){ list = new ArrayList<>(); }

    public static class MyViewHolder extends RecyclerView.ViewHolder{
        public TextView a;
        public TextView b;
        public TextView c;
        public final Context context;
        public MyViewHolder(LinearLayout v){
            super(v);
            a = v.findViewById(R.id.a);
            b = v.findViewById(R.id.b);
            c = v.findViewById(R.id.c);
            context = v.getContext();
        }
    }
}
