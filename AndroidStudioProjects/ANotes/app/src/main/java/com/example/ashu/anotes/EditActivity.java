package com.example.ashu.anotes;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class EditActivity extends Activity {
    String TAG="EditActivity";
   String getTitle,getContent;
   int i = 0;
    ArrayList<NotesInfo> myNotes = new ArrayList<NotesInfo>();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit);
        final EditText getEditTitleView = findViewById(R.id.editTitleView);
        final EditText geteditcontentView = findViewById(R.id.editConetentView);
        TextView saveTextButton = findViewById(R.id.saveId);
        myNotes.add(new NotesInfo("Ashu","My First Notes") );
        saveTextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getTitle = getEditTitleView.getText().toString();
                getContent = geteditcontentView.getText().toString();
                myNotes.add(new NotesInfo(getTitle,getContent));
                Toast.makeText(getBaseContext(),getTitle +" "+ getContent,Toast.LENGTH_LONG).show();
                i++;
                Intent myIntent = new Intent(getBaseContext(),MainActivity.class);
                myIntent.putExtra("myList",myNotes);
                startActivity(myIntent);

            }
        });
String s = myNotes.get(i).getmTitle()+myNotes.get(i).getmContent();
        Log.e(TAG, "onCreate: "+s);
    }
}
