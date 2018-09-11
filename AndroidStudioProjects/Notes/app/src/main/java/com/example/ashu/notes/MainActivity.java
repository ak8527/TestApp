package com.example.ashu.notes;

import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.SimpleTimeZone;

public class MainActivity extends AppCompatActivity {
    final ArrayList<NotesInfo> myNotes = new ArrayList<>();
    String title, content, date;
    ListView listView1;
    TextView saveText,delete;
    EditText getTitle,getContent;
    int setListViewColor,getColor1,colors;
    public String getDate() {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat();
        Date date = new Date();
        return simpleDateFormat.format(date);
    }



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        saveText = findViewById(R.id.saveId);

        getTitle = findViewById(R.id.titleView);
        getContent = findViewById(R.id.contentView);
        listView1 = findViewById(R.id.list_view);
        final NoteAdapter noteAdapter = new NoteAdapter();
        listView1.setAdapter(noteAdapter);

        saveText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myNotes.add(new NotesInfo(getTitle.getText().toString(),getContent.getText().toString(),getDate()));
                noteAdapter.notifyDataSetChanged();
            }
        });





    }
    public int setColor(int color){
        switch (color) {

            case Color.GREEN : setListViewColor= Color.YELLOW;
            case Color.YELLOW : setListViewColor= Color.RED;
            case Color.RED : setListViewColor= Color.WHITE;
            default:setListViewColor= Color.GREEN;
        }
        return setListViewColor ;
    }


    public class NoteAdapter extends BaseAdapter {
        int t;
        @Override
        public int getCount() {
            return myNotes.size();
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
        public View getView(final int position, View view, ViewGroup viewGroup) {

            LayoutInflater li = (LayoutInflater) getBaseContext().getSystemService(LAYOUT_INFLATER_SERVICE);

            final View inflatedView;
            if (view == null) {
                inflatedView = li.inflate(R.layout.list_item, viewGroup, false);
                ViewHolder viewHolder = new ViewHolder();
                viewHolder.noteTitle = inflatedView.findViewById(R.id.getTitleView);
                viewHolder.detail =  inflatedView.findViewById(R.id.getContentView);
                viewHolder.time =  inflatedView.findViewById(R.id.timeView);
                inflatedView.setTag(viewHolder);
            } else {
                inflatedView = view;
            }

            delete = inflatedView.findViewById(R.id.deleteView);
            delete.setTag(position);
            delete.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    int pos = (int)view.getTag();


                    myNotes.remove(pos);
                    notifyDataSetChanged();
                    Log.e("Ashutosh", "onClick: " + pos);
                }
            });


            final NotesInfo notesInfo = myNotes.get(position);
          ViewHolder vh =(ViewHolder) inflatedView.getTag();
                  vh.noteTitle.setText(notesInfo.getmTitle());
            vh.detail.setText(notesInfo.getmContent());
            vh.time.setText(notesInfo.getmDate());

            return inflatedView;

        }


        class ViewHolder {
            TextView noteTitle,detail,time;
        }
    }
}

