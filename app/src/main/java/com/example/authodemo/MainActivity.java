package com.example.authodemo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.auth0.android.Auth0;

public class MainActivity extends AppCompatActivity {

    private Auth0 auth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button loginButton = findViewById(R.id.logout);
        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                logOut();

            }
        });

        String accessTokens = getIntent().getStringExtra(Login.EXTRA_ACCESS_CREDENTISLS);
        TextView textView = findViewById(R.id.credentials);
        textView.setText(accessTokens);

    }


    private void logOut(){
        Intent intent  = new Intent(this, Login.class);
        intent.putExtra(Login.EXTRA_CLEAR_CREDENTIALS,true);
        startActivity(intent);
        finish();
    }


}
