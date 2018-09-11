package com.example.ashu.spotconst;

import android.os.Bundle;
import android.provider.Settings;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final ArrayList<String> settingList = new ArrayList<>();

        Field[] fields = Settings.class.getDeclaredFields();

        for (Field field : fields){
            if (Modifier.isStatic(field.getModifiers())){
                String s = field.getName();
                settingList.add(s);
            }
        }

        Button btn = findViewById(R.id.permissionBtn);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }
}
