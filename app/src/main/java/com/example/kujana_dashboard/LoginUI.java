package com.example.kujana_dashboard;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class LoginUI extends AppCompatActivity implements View.OnClickListener {

    Button LoginUI;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_u_i);

        LoginUI = (Button)findViewById(R.id.LoginUI);
        LoginUI.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        Intent intent = new Intent(LoginUI.this, MainActivity.class);
        startActivity(intent);
    }
}
