package com.example.commerce.views.auth;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.example.commerce.R;
import com.example.commerce.Session.UserSession;

public class MainActivity extends AppCompatActivity {


    Button btn_signin, btn_signup;
    /*ViewPager viewPager;
    int images[] = {R.drawable.home4, R.drawable.home5, R.drawable.home6};
    MyCustomPagerAdapter myCustomPagerAdapter;
    ViewPagerIndicator viewPagerIndicator;
    ViewPager.OnPageChangeListener mOnPageChangeListener;
*/
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn_signin = (Button) findViewById(R.id.btn_signin);
        btn_signup = (Button) findViewById(R.id.btn_signup);


        UserSession userSession = new UserSession(this);
        userSession.checkLogin();


        btn_signin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent signin = new Intent(MainActivity.this, ActivitySignin.class);
                startActivity(signin);

            }
        });
        btn_signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent signup = new Intent(MainActivity.this, ActivitySignup.class);
                startActivity(signup);


            }
        });
  /*      viewPager = (ViewPager) findViewById(R.id.viewPager);
        myCustomPagerAdapter = new MyCustomPagerAdapter(MainActivity.this, images);
        viewPagerIndicator = (ViewPagerIndicator) findViewById(R.id.indicator);
        viewPager.setAdapter(myCustomPagerAdapter);
        viewPagerIndicator.setupWithViewPager(viewPager);
        viewPagerIndicator.addOnPageChangeListener(mOnPageChangeListener);*/

    }

}
