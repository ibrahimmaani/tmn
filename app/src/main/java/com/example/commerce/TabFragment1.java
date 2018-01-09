package com.example.commerce;

import android.annotation.SuppressLint;
import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;

import com.example.commerce.produk.ListProduk;
import com.example.commerce.produk.Produk;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.concurrent.ExecutionException;

public class TabFragment1 extends Fragment{
View view;
GridView gridView;
GridViewAdapter adapterViewAndroid;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.tab_fragment_1, container, false);
        initFromApi1();
        return view;}

    public void initFromApi1(){

        String myUrl= "http://projects.wision.id/sispet/public/api/product";
        //String to place our result in
        String result;
        //Instantiate new instance of our class
        @SuppressLint("StaticFieldLeak")
        HttpGetRequest getRequest = new HttpGetRequest(){
        ProgressDialog nDialog;
            @Override
            protected void onPreExecute() {
                super.onPreExecute();
                nDialog =  new ProgressDialog(getActivity());
                nDialog.setMessage("Loading..");
                nDialog.setTitle("Checking Network");
                nDialog.setIndeterminate(false);
                nDialog.setCancelable(true);
                nDialog.show();

            }
            @Override
            protected void onPostExecute(String result) {
                super.onPostExecute(result);
                try {
                    JSONObject data = new JSONObject(result);
                    JSONArray listProductJson = data.optJSONArray("data");
                    ArrayList<Produk> listProduct = new ArrayList<>();
                    for (int i = 0 ; i < listProductJson.length(); i++) {
                        Produk produk= new Produk();
                        JSONObject obj = listProductJson.getJSONObject(i);
                        produk.setName(obj.getString("name"));
                        produk.setPrice(obj.getLong("price"));
                        listProduct.add(produk);
                    }

                    Log.d("current_page", String.valueOf(data.optInt("current_page")));
                    ListProduk listProduk1 = new ListProduk();
                    listProduk1.getData().addAll(listProduct);

                    adapterViewAndroid = new GridViewAdapter(getActivity(), listProduct);
                    GridView gridView = (GridView) view.findViewById(R.id.gridview1);
                    gridView.setAdapter(adapterViewAndroid);
                    nDialog.dismiss();

                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        };
        //Perform the doInBackground method, passing in our url
        try {
            result = getRequest.execute(myUrl).get();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }
}
