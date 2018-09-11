package com.example.ashu.workmanagertest;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.Observer;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.io.File;
import java.util.ArrayList;

import androidx.work.Data;
import androidx.work.OneTimeWorkRequest;
import androidx.work.State;
import androidx.work.WorkManager;
import androidx.work.WorkStatus;
import androidx.work.Worker;

public class MainActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    StorageAdaptor storageAdaptor;
    ArrayList<Storage> storageArrayList = new ArrayList<>();
    ArrayList<Storage> myStorageArrayList = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = findViewById(R.id.rvView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        storageAdaptor = new StorageAdaptor(this,myStorageArrayList);
        Data data = new Data.Builder()
                .putString("HELLO", "WORLD")
                .build();

        OneTimeWorkRequest oneTimeWorkRequest = new OneTimeWorkRequest
                .Builder(MyWorker.class)
                .setInputData(data)
                .build();

        WorkManager.getInstance().enqueue(oneTimeWorkRequest);

        LiveData<WorkStatus> liveData = WorkManager.getInstance()
                .getStatusById(oneTimeWorkRequest.getId());

        liveData.observe(this, new Observer<WorkStatus>() {
            @Override
            public void onChanged(@Nullable WorkStatus workStatus) {

                State state = workStatus.getState();
                if (state == State.FAILED) {

                } else if (state == State.SUCCEEDED) {

                    storageAdaptor.notifyDataSetChanged();
                    //Fetch data from the database and set it to the ArrayList
                }

            }
        });


    }

    public ArrayList<Storage> getMyStorageList(File directory) {
        getAllFilesOfDir(directory);
        return storageArrayList;
    }

    private void getAllFilesOfDir(File directory) {
        // Log.d(TAG, "Directory: " + directory.getAbsolutePath() + "\n");
        storageArrayList.add(new Storage(directory.getName(),directory.getAbsolutePath()));

        final File[] files = directory.listFiles();

        if ( files != null ) {
            for ( File file : files ) {
                if ( file != null ) {
                    if ( file.isDirectory() ) {  // it is a folder...
                        getAllFilesOfDir(file);
                    }
                    else {  // it is a file...
                        storageArrayList.add(new Storage(file.getName(),file.getAbsolutePath()));
                        //  Log.d(TAG, "File: " + file.getName() + "\n");
                    }
                }
            }
        }
    }


    public class MyWorker extends Worker{

        @NonNull
        @Override
        public Result doWork() {


            return null;
        }
    }

}