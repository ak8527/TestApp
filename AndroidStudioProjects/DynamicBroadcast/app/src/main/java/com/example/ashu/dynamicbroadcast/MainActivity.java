package com.example.ashu.dynamicbroadcast;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    EditText emailEditText, passEditText;
   Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        emailEditText = findViewById(R.id.editText);
        passEditText = findViewById(R.id.editText);

        button = findViewById(R.id.postTv);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = emailEditText.getText().toString();
                String password = passEditText.getText().toString();
                User user = new User(email,password);
                Intent i = new Intent(getBaseContext(),MyBroadCastReceiver.class);
                i.putExtra("KEY",user);
                sendBroadcast(i);
            }
        });


    }


}
