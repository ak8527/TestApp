package com.example.ashu.anotes;

import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        FloatingActionButton floatingActionButton = findViewById(R.id.fab);
        floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getBaseContext(),EditActivity.class);
                startActivity(intent);

            }
        });

        ArrayList<NotesInfo> myGetList = new ArrayList<>();

        Log.e("MainActivity", "onCreate: "+myGetList.get(0).getmContent()+" "+ myGetList.get(0).getmTitle() );

        ListView listView = findViewById(R.id.list_view);

        listView.setAdapter(new NoteAdapter());
    }

    public class NoteAdapter extends BaseAdapter {
        ArrayList<NotesInfo> myNotes1;
        @Override
        public int getCount() {
            return myNotes1.size();
        }

        @Override
        public Object getItem(int position) {
            return null;
        }

        @Override
        public long getItemId(int position) {
            return 0;
        }

        @Override
        public View getView(int position, View view, ViewGroup viewGroup) {

            LayoutInflater li = (LayoutInflater)getBaseContext().getSystemService(LAYOUT_INFLATER_SERVICE);

            View inflatedView;
            if(view==null){
                inflatedView =  li.inflate(R.layout.list_notes,viewGroup,false);
            }else{
                inflatedView = view;
            }


            NotesInfo notesInfo = myNotes1.get(position);
            TextView titleTextView = inflatedView.findViewById(R.id.titleView);
            titleTextView.setText(notesInfo.getmTitle());
            TextView contentTextView = inflatedView.findViewById(R.id.contentView);
            contentTextView.setText(notesInfo.getmContent());
            return inflatedView;
        }
   }

}
