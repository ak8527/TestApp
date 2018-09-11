package com.example.user.lesson3;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity
{
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
       setContentView(R.layout.activity_second);
        Intent i =getIntent();
        String eneterdValue = i.getStringExtra("Key");

        TextView textView1 = findViewById(R.id.textView);
       textView1.setText(eneterdValue);

    }

}
