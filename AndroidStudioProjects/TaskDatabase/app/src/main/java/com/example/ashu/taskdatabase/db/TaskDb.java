package com.example.ashu.taskdatabase.db;


import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import com.example.ashu.taskdatabase.Constants;
import com.example.ashu.taskdatabase.Model.Task;

import java.util.ArrayList;

import static com.example.ashu.taskdatabase.Constants.COLUMN_ID;
import static com.example.ashu.taskdatabase.Constants.COLUMN_TITLE;
import static com.example.ashu.taskdatabase.Constants.COMMA;
import static com.example.ashu.taskdatabase.Constants.CREATE;
import static com.example.ashu.taskdatabase.Constants.INTEGER;
import static com.example.ashu.taskdatabase.Constants.LBR;
import static com.example.ashu.taskdatabase.Constants.NOT_NULL;
import static com.example.ashu.taskdatabase.Constants.PRIMARY_KEY;
import static com.example.ashu.taskdatabase.Constants.RBR;
import static com.example.ashu.taskdatabase.Constants.TABLE_NAME;
import static com.example.ashu.taskdatabase.Constants.TERMINATION;
import static com.example.ashu.taskdatabase.Constants.TEXT;


public class TaskDb extends SQLiteOpenHelper{

    public TaskDb(Context context) {
        super(context, "taskdb", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        //Called when the db was created for the first time, or its version
        //was incremented.
        //You can use this callback to create as many tables as you want
        //or fill them with some random data for the first launch of your app.
        String query = CREATE + TABLE_NAME +
                RBR + COLUMN_ID + INTEGER + PRIMARY_KEY + COMMA
                + COLUMN_TITLE + TEXT + NOT_NULL + LBR
                + TERMINATION;

        Log.e("TAG", "onCreate: SQLiteOpenHelper" + query);
        sqLiteDatabase.execSQL(query);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        //perform table alterations here, or let the default implementation
        // happen which deletes the database and creates it again
    }

   public long insertTask(Task task) {
//        String insertQuery = "INSERT INTO task VALUES( " +
//                task.getId() +
//                ", ); DROP TABLE task;"
//                + " );";

        Log.e("TAG", "insertTask: "+task.getTitle());

        ContentValues contentValues = new ContentValues();
        contentValues.put(Constants.COLUMN_ID, task.getId());
        contentValues.put(Constants.COLUMN_TITLE, task.getTitle());

        //Store this to the database
        long position = getWritableDatabase()
                .insert(Constants.TABLE_NAME,
                        null,
                        contentValues);

        return  position;
    }

    public Task getTaskWithID(Long id) {
        //return a task with the given ID
        return null;
    }

    public ArrayList<Task> getAllTasks() {

        //return an arraylist of all the tasks stored in the db
        return null;
    }

}
