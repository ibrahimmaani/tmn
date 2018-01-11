package com.example.commerce;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Collections;
import java.util.List;

public class HorizontalAdapter extends RecyclerView.Adapter<HorizontalAdapter.MyViewHolder> {

    List<Data> horizontalList = Collections.emptyList();
    Context context;

    public HorizontalAdapter(List<Data> horizontaList, Context context) {
        this.horizontalList = horizontaList;
        this.context = context;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        ImageView imageView;
        TextView textView;

        public MyViewHolder(View view) {
            super(view);
            imageView = (ImageView) view.findViewById(R.id.recycle_image);
        }
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.horizontal, parent, false);
        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {

        holder.imageView.setImageResource(horizontalList.get(position).imageId);

    }

    @Override
    public int getItemCount() {
        return horizontalList.size();
    }


}
