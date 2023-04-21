package com.example.fastfashion_app;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.fastfashion_app.R;

public class MainActivity extends AppCompatActivity {

    Button btn_open_registerUserActivity;
    Button btn_open_viewUserActivity;
    Button btn_open_viewProductActivity;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn_open_registerUserActivity = findViewById(R.id.btn_open_registerUserActivity);
        btn_open_viewUserActivity = findViewById(R.id.btn_open_viewUserActivity);
        btn_open_viewProductActivity = findViewById(R.id.btn_open_viewProductActivity);

        btn_open_registerUserActivity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, RegisterUser.class));
            }
        });

        btn_open_viewUserActivity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, ViewUsers.class));
            }
        });

        btn_open_viewProductActivity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, ViewProducts.class));
            }
        });
    }
}