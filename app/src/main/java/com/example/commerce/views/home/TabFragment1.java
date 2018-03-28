package com.example.commerce;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;
import android.widget.Toast;

import com.example.commerce.models.entities.Object;
import com.example.commerce.models.entities.Product;
import com.example.commerce.models.networks.ApiClient;
import com.example.commerce.models.networks.Endpoint;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;


public class TabFragment1 extends Fragment {
    View view;
    GridView gridView;
    GridViewAdapter adapterViewAndroid;
    private static final String TAG = TabFragment1.class.getSimpleName();
    private final static String API_KEY = "http://projects.wision.id/sispet/public/api";
    List<Product> prod;
    Object img;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.tab_fragment_1, container, false);

        /*initFromApi1();*/


        Endpoint endpoint = ApiClient.getClient().create(Endpoint.class);

        Call<Object> call = endpoint.listProduct();
        call.enqueue(new Callback<Object>() {

            @Override
            public void onResponse(Call<Object> call, retrofit2.Response<Object> response) {


                prod = response.body().getData().getProduct();
//                for (int i = 0; i < prod.size(); i++) {
//                    Object img = prod.get(0).getImageProduct().get(0).url;
//                }
                    Log.d("TabFragment1", "Number of product received: " + prod.size());

                adapterViewAndroid = new GridViewAdapter(getActivity(),prod);
                GridView gridView = (GridView) view.findViewById(R.id.gridview1);
                gridView.setAdapter(adapterViewAndroid);
            }


            @Override
            public void onFailure(Call<Object> call, Throwable t) {
                Toast.makeText(getActivity(), t.getMessage(), Toast.LENGTH_SHORT).show();

            }
        });

        return view;
    }


    /*public void initFromApi1() {

        String myUrl = "http://projects.wision.id/sispet/public/api/product";
        //String to place our result in
        String result;
        //Instantiate new instance of our class
        @SuppressLint("StaticFieldLeak")
        HttpGetRequest getRequest = new HttpGetRequest() {
            ProgressDialog nDialog;

            @Override
            protected void onPreExecute() {
                super.onPreExecute();
                nDialog = new ProgressDialog(getActivity());
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

                    *//*Gson gson = new Gson();
                    Produk prod = gson.fromJson(result, Produk.class);
                    List<Produk> produk = produk.getData().getProduk();

                    JSONObject data = new JSONObject(result);
                    JSONArray listProductJson = data.optJSONArray("data");
                    ArrayList<Produk> listProduct = new ArrayList<>();

                    final ArrayList<Produk> listProduk = new ArrayList<>();
                    for (int i = 0; i < produk.size(); i++) {
                        Produk produk = new Produk();
                        //JSONObject obj = listProductJson.getJSONObject(i);
                        produk.setName(produk.get(i).getName());
                        produk.setDescription(produk.get(i).getDescription());
                        produk.setPrice(produk.get(i).getPrice());
                        produk.add(produk);


                    Log.d("current_page", String.valueOf(data.optInt("current_page")));
                    ListProduk listProduk1 = new ListProduk();
                    listProduk1.getData().addAll(listProduct);


                    adapterViewAndroid = new GridViewAdapter(getActivity(), Product);
                    GridView gridView = (GridView) view.findViewById(R.id.gridview1);
                    gridView.setAdapter(adapterViewAndroid);
                    nDialog.dismiss();

                } catch (Exception e) {
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
    }*/
}
