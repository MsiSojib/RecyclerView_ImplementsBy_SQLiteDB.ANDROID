package com.example.sirajulislamsojib.recyclerviewfromsqlitedb;

import android.content.DialogInterface;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;

public class recyclerView extends AppCompatActivity {

    RecyclerView recyclerView;
    CustomAdapter adapter;
    ArrayList<DataModel> setData;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler_view);

        recyclerView = findViewById(R.id.recyclerview);

        setDataFromDatabase();
        adapter = new CustomAdapter(this,setData);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);
    }

    private void setDataFromDatabase() {
        MyDatabaseOpenHelper myDatabaseOpenHelper;
        myDatabaseOpenHelper = new MyDatabaseOpenHelper(this);
        SQLiteDatabase db = myDatabaseOpenHelper.getWritableDatabase();

        Cursor cursor = myDatabaseOpenHelper.getAllData();
        if(cursor.getCount()==0){
            setData = new ArrayList<>();
        }else{
            setData = new ArrayList<>();
            while(cursor.moveToNext()){
                setData.add(new DataModel(cursor.getString(0),
                        cursor.getString(1),
                        cursor.getString(2)));
            }
        }
    }
}
