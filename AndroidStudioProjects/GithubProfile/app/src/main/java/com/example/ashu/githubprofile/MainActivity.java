package com.example.ashu.githubprofile;

import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.Scanner;

public class MainActivity extends AppCompatActivity {
    String s;
    RecyclerView recyclerView;
    ArrayList<Items> result = new ArrayList<>();
    EditText editText1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText1 = findViewById(R.id.editText);
        Log.e("Content", "onCreate: "+s );
        Button button = findViewById(R.id.idBtn);
        recyclerView = findViewById(R.id.rvView);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                s = editText1.getText().toString();

                MyGithubTask myGithubTask = new MyGithubTask();
                String url = "https://api.github.com/search/users?q="+s;
                Log.e("Button On click", "onClick: "+s );
                myGithubTask.execute(url);
            }
        });
       // Log.e("RecyclerView", "onCreate: " + result.get(3).getmProfileUrl() );

    }


    class MyGithubTask extends AsyncTask<String, Void, String> {

        @Override
        protected String doInBackground(String... strings) {
             String githubUrl = strings[0];
            try {
                URL url = new URL(githubUrl);

                HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();

                InputStream inputStream = httpURLConnection.getInputStream();

                Scanner scanner = new Scanner(inputStream);
                scanner.useDelimiter("\\A");
                String result = "";
                if (scanner.hasNext()){
                    result = scanner.next();
                }

                return result;

            } catch (IOException e) {
                e.printStackTrace();
            }

            return "";
        }


        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);
            result = convertJsonToResponse(s);
            Log.e("PostExecute", "onPostExecute: "+result.get(0).getmProfileUrl() );
            recyclerView.setLayoutManager(new LinearLayoutManager(MainActivity.this));
            UserAdapter userAdapter = new UserAdapter(MainActivity.this,result);
            recyclerView.setAdapter(userAdapter);

        }
    }

    public ArrayList<Items> convertJsonToResponse(String json){
        try {
            JSONObject jsonObject = new JSONObject(json);

            JSONArray jsonArray = jsonObject.getJSONArray("items");

            ArrayList<Items> itemsArrayList = new ArrayList<>();

            for (int i = 0;i<jsonArray.length();i++){

                JSONObject itemObject = jsonArray.getJSONObject(i);
                String imageUrl = itemObject.getString("avatar_url");

                String name = itemObject.getString("login");
                String profileUrl = itemObject.getString("html_url");

                String bioUrl = itemObject.getString("url");


                Items items = new Items(name,profileUrl,imageUrl,bioUrl);

                itemsArrayList.add(items);
                Log.e("ArrayList", "convertJsonToResponse: Name "+ name  );

            }

            return itemsArrayList;

        } catch (JSONException e) {
            e.printStackTrace();
        }

        return null;

    }
}
