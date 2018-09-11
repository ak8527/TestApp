package com.example.ashu.taskdatabase;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.ashu.taskdatabase.Model.Task;
import com.example.ashu.taskdatabase.db.TaskDb;

public class MainActivity extends AppCompatActivity {
    TaskDb taskDb;
    EditText editText;
    Button button;
    long position;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText = findViewById(R.id.titleView);
        button = findViewById(R.id.btnView);


        taskDb = new TaskDb(this);

        Task task = new Task(System.currentTimeMillis(), "Hello World");

         position = taskDb.insertTask(task);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String s = editText.getText().toString();
                Task task = new Task(System.currentTimeMillis(),s);
                position = taskDb.insertTask(task);
            }
        });

        Log.e("TAG", "onCreate: task inserted at position" + position );
    }




}
