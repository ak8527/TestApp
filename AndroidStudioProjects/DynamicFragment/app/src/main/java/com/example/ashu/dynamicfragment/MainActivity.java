package com.example.ashu.dynamicfragment;

import android.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Fragment FragmentA = new FragmentA();
        getSupportFragmentManager()
                .beginTransaction()
                .add(R.id.fragmentAcontainer,FragmentA)
                .commit();

    }
}
