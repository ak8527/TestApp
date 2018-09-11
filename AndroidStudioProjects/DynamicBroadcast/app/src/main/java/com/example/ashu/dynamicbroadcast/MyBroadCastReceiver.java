package com.example.ashu.dynamicbroadcast;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

import com.google.gson.Gson;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class MyBroadCastReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(final Context context, Intent intent) {

        User user = intent.getParcelableExtra("KEY");


        Gson gson = new Gson();

//        URL we will post the data to
        String postUrl = "http://ptsv2.com/t/bbqnt-1530789870/post";

        OkHttpClient okHttpClient = new OkHttpClient();

//        Define the type of file that the server should expect
        MediaType mediaType = MediaType.parse("application/json");

//        Create a RequestBody object with the data and the mediatype
        RequestBody requestBody = RequestBody.create(mediaType,gson.toJson(user));

        Request request = new Request.Builder()
                .url(postUrl)
                .post(requestBody)
                .build();

        Call call = okHttpClient.newCall(request);

        call.enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {

            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                Toast.makeText(context, response.body().string(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    }

