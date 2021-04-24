package com.example.kujana_dashboard;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Welcome extends AppCompatActivity implements View.OnClickListener {

    Button WelBtnLog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);

        WelBtnLog = (Button)findViewById(R.id.btnWelLogin);
        WelBtnLog.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {

        Intent intent = new Intent(Welcome.this, LoginUI.class);
        startActivity(intent);
    }
}
