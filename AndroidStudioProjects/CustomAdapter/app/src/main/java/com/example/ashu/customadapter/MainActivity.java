package com.example.ashu.customadapter;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    final ArrayList<studentInfo> studentArrayList = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        studentArrayList.add(new studentInfo("Ashutosh1 ","Android","Noida"));
        studentArrayList.add(new studentInfo("Ashutosh 2","Android","Noida"));
        studentArrayList.add(new studentInfo("Ashutosh 3","Android","Noida"));
        studentArrayList.add(new studentInfo("Ashutosh 4","Android","Noida"));
        studentArrayList.add(new studentInfo("Ashutosh 5","Android","Noida"));
        studentArrayList.add(new studentInfo("Ashutosh 6","Android","Noida"));
        studentArrayList.add(new studentInfo("Ashutosh 7","Android","Noida"));
        studentArrayList.add(new studentInfo("Ashutosh 8","Android","Noida"));
        studentArrayList.add(new studentInfo("Ashutosh 9","Android","Noida"));
        studentArrayList.add(new studentInfo("Ashutosh 10","Android","Noida"));
        studentArrayList.add(new studentInfo("Ashutosh ","Android","Noida"));
        studentArrayList.add(new studentInfo("Ashutosh ","Android","Noida"));

       // myclassAdapter myadapter = new myclassAdapter();
        ListView listView1 = findViewById(R.id.listView);
        listView1.setAdapter(new myClassAdapter());
        }
    class myClassAdapter extends BaseAdapter{


        @Override
        public int getCount() {
            return studentArrayList.size();
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
                inflatedView =  li.inflate(R.layout.custom_list,viewGroup,false);
            }else{
                inflatedView = view;
            }

            studentInfo currentStudent = studentArrayList.get(position);
            TextView studentname = inflatedView.findViewById(R.id.nameView);
            studentname.setText(currentStudent.getName());
            TextView studentName1 = inflatedView.findViewById(R.id.batchView);
            studentName1.setText(currentStudent.getBatch());
            TextView studentName2 = inflatedView.findViewById(R.id.location);
            studentName2.setText(currentStudent.getLocation());

            return inflatedView;



        }




    }

}
