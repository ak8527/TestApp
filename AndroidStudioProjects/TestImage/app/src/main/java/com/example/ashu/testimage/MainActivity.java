package com.example.ashu.testimage;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ImageView imageView = findViewById(R.id.iView);
        Picasso.get()
                .load("https://randomuser.me/api/portraits/women/88.jpg")
                .placeholder(R.mipmap.ic_launcher)
                .into(imageView);
    }
}
