package com.example.user.lesson3;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final Button button = findViewById(R.id.button);
        final EditText editText = findViewById(R.id.editText);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//               Toast t = Toast.makeText(MainActivity.this,"Hello Ashu",Toast.LENGTH_LONG);
//               t.setGravity(Gravity.BOTTOM|Gravity.END,0,0);
//               t.show();
//     String enteredText = editText.getText().toString();
//                Intent intent = new Intent(getBaseContext(),SecondActivity.class);
//                intent.putExtra("Key",enteredText);
//                startActivity(intent);

              //  finish();

                //Implicit Intent
                Intent i = new Intent();
                i.setAction(Intent.ACTION_DIAL);
                i.setData(Uri.parse("9868204472"));
                startActivity(i);


            }
        });

    }
}
