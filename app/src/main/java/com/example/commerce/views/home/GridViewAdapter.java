package com.example.commerce;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.commerce.models.entities.Product;
import com.example.commerce.models.networks.ApiClient;
import com.squareup.picasso.Picasso;

import java.util.List;

public class GridViewAdapter extends BaseAdapter{

    List<Product> result;
    Context context;
    private static LayoutInflater inflater=null;
    public GridViewAdapter(Activity mainActivity, List<Product> data) {
        // TODO Auto-generated constructor stub
        result= data;
        context=mainActivity;
        inflater = ( LayoutInflater )context.
                getSystemService(Context.LAYOUT_INFLATER_SERVICE);

    }

    @Override
    public int getCount() {
        // TODO Auto-generated method stub
        return result.size();
    }

    @Override
    public Object getItem(int position) {
        // TODO Auto-generated method stub
        return position;
    }

    @Override
    public long getItemId(int position) {
        // TODO Auto-generated method stub
        return position;
    }

    public class Holder
    {
        TextView tv1;
        TextView tv2;
        ImageView img;
    }
    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        // TODO Auto-generated method stub
        Holder holder=new Holder();
        View rowView;
        final Product product= result.get(position);

        rowView = inflater.inflate(R.layout.row_grid, null);
        holder.tv1=(TextView) rowView.findViewById(R.id.textView);
        holder.tv2=(TextView) rowView.findViewById(R.id.textView2);
        holder.img=(ImageView) rowView.findViewById(R.id.imageView);

        holder.tv1.setText(result.get(position).getName());
        holder.tv2.setText(String.valueOf(result.get(position).getPrice()));

        Picasso.with(context).load(ApiClient.ASSETS_URL+ result.get(position).getImageProduct().get(0).getUrl()).into(holder.img);
//        Log.e("url",ApiClient.ASSETS_URL+ result.get(position).getImageProduct().get(0).getUrl());

        rowView.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {




                // TODO Auto-generated method stub
                Toast.makeText(context, "You Clicked "+product.getName(), Toast.LENGTH_LONG).show();
                Intent intent = new Intent(context, ActivityDetail.class);
                intent.putExtra("name", product.getName());
//                intent.putExtra("price", String.valueOf(produk.getPrice()) );
                intent.putExtra("description", product.getDescription());
                context.startActivity(intent);
            }
        });

        return rowView;
    }

}