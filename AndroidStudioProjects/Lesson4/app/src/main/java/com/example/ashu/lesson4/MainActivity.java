package com.example.ashu.lesson4;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ArrayList<String> student = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        student.add("Ashu1");
        student.add("Ashu2");
        student.add("Ashu3");
        student.add("Ashu4");
        student.add("Ashu5");
        student.add("Ashu6");
        student.add("Ashu7");
        student.add("Ashu8");
        student.add("Ashu9");
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<>(this,R.layout.item_list,R.id.textView,student);
        final ListView listView =findViewById(R.id.ListView);
        listView.setAdapter(arrayAdapter);
      listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
          @Override
          public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
              String studentName = student.get(position);
              Toast.makeText(getBaseContext(), studentName, Toast.LENGTH_SHORT).show();
          }
      });
    }
}
