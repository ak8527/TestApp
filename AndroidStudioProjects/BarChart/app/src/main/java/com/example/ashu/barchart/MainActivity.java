package com.example.ashu.barchart;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        LinearLayout linearLayout = findViewById(R.id.linearLayout1);
        linearLayout.setWeightSum(65.0f);

        TextView textView = findViewById(R.id.textView);
        TextView textView1 = findViewById(R.id.textView2);
        textView.setWidth(0);
        TextView textView2 = linearLayout.addView(1,M);
        textView1.setWidth(35);
        textView1.setBackgroundColor(getResources().getColor(R.color.colorPrimary));
    }
}
