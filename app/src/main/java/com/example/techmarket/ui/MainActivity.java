package com.example.techmarket.ui;
import android.content.Intent;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import butterknife.ButterKnife;

import androidx.appcompat.app.AppCompatActivity;

import com.example.techmarket.R;

import butterknife.BindView;

public class MainActivity extends AppCompatActivity {
   @BindView(R.id.loginButton) Button mLoginButton;
@BindView(R.id.registerTextView)
TextView registerTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        mLoginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(MainActivity.this, ChoiceActivity.class);
                startActivity(intent);

            }
        });
        registerTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, CreateAccountActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }
}