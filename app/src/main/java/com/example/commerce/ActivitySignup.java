package com.example.commerce;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;


public class ActivitySignup extends AppCompatActivity {
    ImageView imageClose;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
        imageClose = (ImageView)findViewById(R.id.imageClose);
        imageClose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent signup= new Intent(ActivitySignup.this, MainActivity.class);
                startActivity(signup);
            }
        });

    }

}
