package com.mlambo.smarthike.Authentication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.mlambo.smarthike.Home.DriveActivity;
import com.mlambo.smarthike.R;

public class PasangerSignUp extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pasanger_sign_up);

        startActivity(new Intent(this, DriveActivity.class));
    }
}
