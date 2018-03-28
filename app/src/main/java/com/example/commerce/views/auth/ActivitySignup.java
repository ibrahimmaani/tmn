package com.example.commerce;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;


public class ActivitySignup extends AppCompatActivity implements View.OnClickListener{

    private EditText edit_text_email;
    private EditText edit_text_pass;
    private Button btn_signup;
    private ProgressDialog progressDialog;
    private FirebaseAuth firebaseAuth;

    ImageView imageClose;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
        firebaseAuth = FirebaseAuth.getInstance();

        edit_text_email = (EditText)findViewById(R.id.edit_text_email);
        edit_text_pass = (EditText)findViewById(R.id.edit_text_pass);
        btn_signup = (Button)findViewById(R.id.btn_signup);
        progressDialog = new ProgressDialog(this);
        btn_signup.setOnClickListener(this);


        imageClose = (ImageView)findViewById(R.id.imageClose);
        imageClose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent signup= new Intent(ActivitySignup.this, MainActivity.class);
                startActivity(signup);
            }
        });

    }

    protected void registerUser(){
        String email = edit_text_email.getText().toString().trim();
        String password = edit_text_pass.getText().toString().trim();

        if (TextUtils.isEmpty(email)){
            Toast.makeText(this,"please enter email", Toast.LENGTH_LONG).show();
            return;
        }
        if (TextUtils.isEmpty(password)){
            Toast.makeText(this,"please enter password",Toast.LENGTH_LONG).show();
            return;
        }

        progressDialog.setMessage("Registering Please Wait...");
        progressDialog.show();


        firebaseAuth.createUserWithEmailAndPassword(email,password)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {

                        //checking if success
                        if(task.isSuccessful()){
                            //display some message here
                            Toast.makeText(ActivitySignup.this,"Successfully Registered", Toast.LENGTH_LONG).show();
                            startActivity(new Intent(getApplicationContext(),ActivitySignin.class));
                        }else{
                            //display some message here
                            Toast.makeText(ActivitySignup.this,"Registration Error", Toast.LENGTH_LONG).show();
                        }
                        progressDialog.dismiss();

                    }
                });
    }

    @Override
    public void onClick(View v) {
        registerUser();
    }
}
