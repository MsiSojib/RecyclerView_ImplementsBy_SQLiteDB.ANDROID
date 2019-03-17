package com.example.sirajulislamsojib.recyclerviewfromsqlitedb;

import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    MyDatabaseOpenHelper myDatabaseOpenHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        myDatabaseOpenHelper = new MyDatabaseOpenHelper(this);
        SQLiteDatabase db = myDatabaseOpenHelper.getWritableDatabase();

    }
}
