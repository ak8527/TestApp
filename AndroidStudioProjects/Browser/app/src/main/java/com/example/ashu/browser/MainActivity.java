package com.example.ashu.browser;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final EditText editText = findViewById(R.id.editText);
        Button button = findViewById(R.id.idBtn);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                WebView webView = findViewById(R.id.wbView);
                webView.loadUrl(editText.getText().toString());
                webView.getSettings().setJavaScriptEnabled(true);
                webView.getSettings().

            }
        });

        //Not Completed



       Intent intent = getIntent();
        if(intent == null)
            return;
        else{
            WebView webView = findViewById(R.id.wbView);
            //webView.loadUrl(intent.);
        }

    }
}
