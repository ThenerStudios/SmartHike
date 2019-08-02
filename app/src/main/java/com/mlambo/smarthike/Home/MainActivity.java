package com.mlambo.smarthike.Home;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.mlambo.smarthike.Authentication.PhoneAuth;
import com.mlambo.smarthike.Authentication.Profile;
import com.mlambo.smarthike.R;
import com.mlambo.smarthike.Walkthrough.Walkthrough;
import com.mlambo.smarthike.Walkthrough.Welcome;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    @Override
    protected void onStart() {
        super.onStart();

        startActivity(new Intent(this, Welcome.class));
    }
}
