package com.example.commerce.views.detail;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.commerce.R;
import com.example.commerce.models.entities.FavModel;
import com.example.commerce.models.entities.Product;
import com.example.commerce.models.networks.ApiClient;
import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by Arie-Ezio on 12-Apr-18.
 */

public class FavListAdapter extends ArrayAdapter<FavModel>{

    private Context context;
    List<FavModel> products;
    SharedPreference sharedPreference;
    Product checkProduct;

    public FavListAdapter(Context context,List<FavModel> products){
        super(context, R.layout.activity_favorite_list);
        this.context = context;
        this.products = products;
        sharedPreference = new SharedPreference();
    }

    private class ViewHolder{
        TextView favName, favPrice;
        ImageView favImg;
    }

    @Override
    public int getCount() {return products.size();}


    @Override
    public FavModel getItem(int position) {return products.get(position);}

    @Override
    public long getItemId(int position) {return 0;}

    @Override
    public View getView(int position,  View convertView,  ViewGroup parent) {
        ViewHolder holder = null;
        if (convertView == null){
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Activity.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.fav_list_item, null);
            holder = new ViewHolder();
            holder.favName = (TextView) convertView.findViewById(R.id.nama);
            holder.favPrice = (TextView) convertView.findViewById(R.id.harga);
            holder.favImg = (ImageView) convertView.findViewById(R.id.gambar);

            convertView.setTag(holder);
        }else {
            holder = (ViewHolder) convertView.getTag();
        }
        FavModel product = (FavModel) getItem(position);
        holder.favName.setText(product.getName());
        holder.favPrice.setText(String.valueOf(product.getPrice()));
        Picasso.with(context).load(ApiClient.ASSETS_URL + product.getUrl()).into(holder.favImg);

        return convertView;
    }
}
