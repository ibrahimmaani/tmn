package com.example.commerce;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;


public class ActivitySignin extends AppCompatActivity {

    ImageView imageBack;
    Button btn_signin;
    EditText textedituser;
    EditText texteditpass;
    Button btn_signup;
    ProgressDialog loading;

    Context mContext;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signin);
        imageBack = (ImageView) findViewById(R.id.imageBack);
        btn_signin = (Button) findViewById(R.id.btn_signin);
        imageBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent signin=new Intent(ActivitySignin.this, MainActivity.class);
                startActivity(signin);


            }
        });
        btn_signin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent signin = new Intent(ActivitySignin.this, Home.class);
                startActivity(signin);
            }
        });

    }


    }