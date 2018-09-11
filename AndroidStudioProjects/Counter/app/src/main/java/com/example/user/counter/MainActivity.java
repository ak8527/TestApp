package com.example.user.counter;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    public int count = 0;

    public static final String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


    }


    @Override
    protected void onStart() {
        super.onStart();
        Log.e(TAG, "onStart: Onstart Call");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.e(TAG, "onResume: resume app");
    }

    @Override
    protected void onPause() {
        super.onPause();
    }
    public void reset(View view) {
        count = 0;
        Log.e(TAG, "reset: count = "+count);
        display(count);

    }

    public void decrement(View view) {
        if(count > 0)
        count--;
        Log.e(TAG, "decrement: count = "+count );
        display(count);

    }

    public void increment(View view) {
        count++;
        Log.e(TAG, "increment: count = "+count);
        display(count);
    }

    public void display(int count){
        TextView textView = findViewById(R.id.textview);
        textView.setText(String.valueOf(count));


    }
    public 
}
