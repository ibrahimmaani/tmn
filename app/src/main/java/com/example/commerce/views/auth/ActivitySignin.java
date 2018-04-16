package com.example.commerce.views.auth;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.example.commerce.R;
import com.example.commerce.Session.UserSession;
import com.example.commerce.models.networks.ApiClient;
import com.example.commerce.models.networks.Endpoint;
import com.example.commerce.sidenavigation.NavBar;
import com.example.commerce.views.auth.resp.RespSignin;
import com.google.android.gms.common.SignInButton;
import com.google.android.gms.common.api.GoogleApiClient;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class ActivitySignin extends AppCompatActivity {

    private EditText inputEmail, inputPassword;
    //    private FirebaseAuth auth;
    private ProgressBar progressBar;
    private Button btnLogin;
    private SignInButton signInButton;
    private static final int RC_SIGN_IN = 1;
    private GoogleApiClient mGoogleApiClient;
    private String email;
    private String pass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        inputEmail = (EditText) findViewById(R.id.email);
        inputPassword = (EditText) findViewById(R.id.pass);


        //Get Firebase auth instance
        /*auth = FirebaseAuth.getInstance();
        if (auth.getCurrentUser() != null) {
            startActivity(new Intent(ActivitySignin.this, NavBar.class));
            finish();
        }*/

        // set the view now
        setContentView(R.layout.activity_signin);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setDisplayShowTitleEnabled(false);

        inputEmail = (EditText) findViewById(R.id.email);
        inputPassword = (EditText) findViewById(R.id.pass);
        progressBar = (ProgressBar) findViewById(R.id.progressBar);
        btnLogin = (Button) findViewById(R.id.btn_login);


        //Get Firebase auth instance
//        auth = FirebaseAuth.getInstance();

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                if (validate()) {

                    Endpoint endpoint = ApiClient.getClient().create(Endpoint.class);

                    Call<RespSignin> call = endpoint.authLogin(email, pass);
                    call.enqueue(new Callback<RespSignin>() {
                        @Override
                        public void onResponse(Call<RespSignin> call, Response<RespSignin> response) {

                            RespSignin resp = response.body();

                            if (resp != null) {
                                if (resp.getStatus().equals("success")) {
                                    UserSession userSession = new UserSession(ActivitySignin.this);
                                    userSession.createLoginSession(pass, email, resp.getData().getToken());
                                    Intent signin = new Intent(ActivitySignin.this, NavBar.class);
                                    startActivity(signin);
                                    finish();
                                } else {
                                    Toast.makeText(ActivitySignin.this, "Field kosong", Toast.LENGTH_LONG).show();
                                }
                            }


                        }

                        @Override
                        public void onFailure(Call<RespSignin> call, Throwable t) {

                        }
                    });

                }

//            @Override
//            public void onClick(View v) {
//                btn_signin.setOnClickListener(new View.OnClickListener() {


                /*String email = inputEmail.getText().toString();
                final String password = inputPassword.getText().toString();

                if (TextUtils.isEmpty(email)) {
                    Toast.makeText(getApplicationContext(), "Enter email address!", Toast.LENGTH_SHORT).show();
                    return;
                }

                if (TextUtils.isEmpty(password)) {
                    Toast.makeText(getApplicationContext(), "Enter password!", Toast.LENGTH_SHORT).show();
                    return;
                }

                progressBar.setVisibility(View.VISIBLE);

                //authenticate user
                auth.signInWithEmailAndPassword(email, password)
                        .addOnCompleteListener(ActivitySignin.this, new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                                // If sign in fails, display a message to the user. If sign in succeeds
                                // the auth state listener will be notified and logic to handle the
                                // signed in user can be handled in the listener.
                                progressBar.setVisibility(View.GONE);
                                if (!task.isSuccessful()) {
                                    // there was an error
                                    if (password.length() < 6) {
                                        inputPassword.setError(getString(R.string.minimum_password));
                                    } else {
                                        Toast.makeText(ActivitySignin.this, getString(R.string.auth_failed), Toast.LENGTH_LONG).show();
                                    }
                                } else {
                                    Intent intent = new Intent(ActivitySignin.this, NavBar.class);
                                    startActivity(intent);
                                    finish();
                                }
                            }
                        });
            }*/
            }

        });

    }

    public boolean validate() {
        if (inputEmail.getText().length() > 0) {
            email = inputEmail.getText().toString();
        } else {
            inputEmail.requestFocus();
            inputEmail.setError("Field belum diisi");
            return false;
        }
        if (inputPassword.getText().length() > 0) {
            pass = inputPassword.getText().toString();
        } else {
            inputPassword.requestFocus();
            inputPassword.setError("Field belum diisi");
            return false;
        }
        return true;
    }


    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }
}
