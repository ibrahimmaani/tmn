package com.example.commerce;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class ActivityDetail extends AppCompatActivity {

    List<Data> data;
    RecyclerView recycle_horizontal;
    HorizontalAdapter horizontalAdapter;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar_dtl1);

        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowTitleEnabled(false);

        recycle_horizontal = (RecyclerView) findViewById(R.id.inner_recyclerView);
        data = fill_with_data();
        horizontalAdapter = new HorizontalAdapter(data, getApplication());
        recycle_horizontal.setLayoutManager(new StaggeredGridLayoutManager(1, StaggeredGridLayoutManager.HORIZONTAL));
        recycle_horizontal.setAdapter(horizontalAdapter);

        TextView name = (TextView) findViewById(R.id.name);
        TextView price = (TextView) findViewById(R.id.price);
        TextView description = (TextView) findViewById(R.id.description);

        Intent intent = getIntent();
        Bundle bd = intent.getExtras();
        if (bd != null) {

            String getName = (String) bd.get("name");
            name.setText(getName);


            String getPrice = (String) bd.get("price");
            price.setText(getPrice);


            String getDescription = (String) bd.get("description");
            description.setText(getDescription);

        }
    }

    public List<Data> fill_with_data() {
        List<Data> data = new ArrayList<>();
        data.add(new Data(R.drawable.home1, "image1"));
        data.add(new Data(R.drawable.detail2, "image2"));
        data.add(new Data(R.drawable.detail3, "image3"));
        return data;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu_detail) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_detail, menu_detail);
        return true;
    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }



}