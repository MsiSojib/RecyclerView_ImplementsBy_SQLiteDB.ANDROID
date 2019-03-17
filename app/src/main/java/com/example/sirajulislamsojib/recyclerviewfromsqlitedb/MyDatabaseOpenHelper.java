package com.example.sirajulislamsojib.recyclerviewfromsqlitedb;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

public class MyDatabaseOpenHelper extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "recyclerview";
    private static final String TABLE_NAME = "example";

    private static final String COL_ID = "id";
    private static final String COL_NAME = "name";
    private static final String COL_TEXT = "text";

    private static final String QUERY_CREATE_TABLE = "CREATE TABLE IF NOT EXISTS "+TABLE_NAME+
            "("+COL_ID+" VARCHAR PRIMARY KEY,"+COL_NAME+" VARCHAR,"+COL_TEXT+" VARCHAR);";

    private static final int VERSION = 1;
    private Context context;

    public MyDatabaseOpenHelper(Context context) {
        super(context, DATABASE_NAME, null, VERSION);
        this.context = context;  //copying activity where this class is called!
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        try{
            db.execSQL(QUERY_CREATE_TABLE);
            Toast.makeText(context, "Table is Created!", Toast.LENGTH_LONG).show();
        }catch(Exception e){
            Toast.makeText(context, "Table creation is Failed!\n"+e.getMessage(), Toast.LENGTH_LONG).show();
        }
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
