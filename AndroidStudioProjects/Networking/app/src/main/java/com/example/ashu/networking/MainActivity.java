package com.example.ashu.networking;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Scanner;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final EditText editText = findViewById(R.id.etView);
        Button button = findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MyNetworkTask myNetworkTask = new MyNetworkTask();
                myNetworkTask.execute(editText.getText().toString());

            }
        });
    }



    class MyNetworkTask extends AsyncTask<String,Void,String>{

        @Override
        protected String doInBackground(String... strings) {

            String currentUrl = strings[0];
            String s = makeNetworkCall(currentUrl);
            return s;

        }

        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);
            TextView textView = findViewById(R.id.dataView1);
            textView.setText(s);
        }
    }

    private String makeNetworkCall(String currentUrl) {
        URL url = null;
        try {
            url = new URL(currentUrl);
            HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();

            InputStream inputStream = httpURLConnection.getInputStream();

            Scanner scanner = new Scanner(inputStream);
            String s = "";
            scanner.useDelimiter("\\A");

            if(scanner.hasNext()){
                s = scanner.next();
            }
            return s;
        } catch (MalformedURLException e) {
            e.printStackTrace();

        } catch (IOException e) {
            e.printStackTrace();
        }
        return "Something Gone Wrong";
    }
}
