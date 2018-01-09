package com.example.commerce;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.widget.TextView;

public class ActivityDetail extends AppCompatActivity{


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar_dtl1);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        TextView name = (TextView) findViewById(R.id.name);
        TextView price = (TextView) findViewById(R.id.price);
        TextView description = (TextView) findViewById(R.id.description);
        Intent intent = getIntent();
        Bundle bd = intent.getExtras();
        if(bd != null)
        {

            String getName = (String) bd.get("name");
            name.setText(getName);


            String getPrice = (String) bd.get("price");
            price.setText(getPrice);

            String getDescription = (String) bd.get("description");
            description.setText(getDescription);

        }
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu_detail) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_detail, menu_detail);
        return true;
    }

}