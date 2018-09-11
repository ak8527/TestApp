package com.example.ashu.logcount;

import android.annotation.SuppressLint;
import android.os.AsyncTask;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    TextView textView;
    ProgressBar pb;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        int i = 0;
        Button button = findViewById(R.id.button);
        textView = findViewById(R.id.textView1);
         pb =findViewById(R.id.pb);
        final MyTask myTask = new MyTask();

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) { myTask.execute(10000);
            }
        });
        }



        class MyTask extends AsyncTask<Integer,String,Boolean>{



            @Override
            protected Boolean doInBackground(Integer... integers) {
                for(int i = 0;i<10000;i++){

                    Log.e("Button", "doInBackground: "+i );
                }
                return true;
                }

            @Override
            protected void onPostExecute(Boolean aBoolean) {
                super.onPostExecute(aBoolean);
                textView.setText("Task Complete");
            }

            @Override
            protected void onPreExecute() {

                super.onPreExecute();

            }
        }
}
