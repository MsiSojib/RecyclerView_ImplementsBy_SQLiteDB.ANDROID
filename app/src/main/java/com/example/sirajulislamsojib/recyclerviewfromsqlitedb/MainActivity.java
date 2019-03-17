package com.example.sirajulislamsojib.recyclerviewfromsqlitedb;

import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    MyDatabaseOpenHelper myDatabaseOpenHelper;

    EditText et_Id, et_Name, et_Text;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        et_Id = findViewById(R.id.et_id);
        et_Name = findViewById(R.id.et_name);
        et_Text = findViewById(R.id.et_text);

        myDatabaseOpenHelper = new MyDatabaseOpenHelper(this);
        SQLiteDatabase db = myDatabaseOpenHelper.getWritableDatabase();

    }

    public void saveToDB(View view) {
        long check = myDatabaseOpenHelper.insertData(et_Id.getText().toString(),
                et_Name.getText().toString(),et_Text.getText().toString());
        if(check==-1) Toast.makeText(this, "Data is Not inserted!",
                Toast.LENGTH_SHORT).show();
        else Toast.makeText(this, "Data is Inserted!", Toast.LENGTH_SHORT).show();

        //setting focus on the Enter Id EditText
        et_Id.setText("");
        et_Id.requestFocus();
        et_Name.setText("");
        et_Text.setText("");
    }

    public void showAllData(View view) {
        Cursor cursor = myDatabaseOpenHelper.getAllData();
        if(cursor.getCount()==0) Toast.makeText(this, "Database is Empty!",
                Toast.LENGTH_SHORT).show();
        else{
            StringBuffer stringBuffer = new StringBuffer();
            while(cursor.moveToNext()){
                stringBuffer.append("ID: "+cursor.getString(0)+"\n");
                stringBuffer.append("Name: "+cursor.getString(1)+"\n");
                stringBuffer.append("Text: "+cursor.getString(2)+"\n");
            }
            String data = stringBuffer.toString();

            //creating AlertDialog
            AlertDialog.Builder alertDialogBuilder;
            alertDialogBuilder = new AlertDialog.Builder(this);
            alertDialogBuilder.setTitle("All Data From Database");
            alertDialogBuilder.setMessage(data);
            alertDialogBuilder.setCancelable(false);
            alertDialogBuilder.setNegativeButton("Ok", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    dialog.cancel();
                }
            });
            AlertDialog alertDialog = alertDialogBuilder.create();
            alertDialog.show();
        }
    }

    public void recyclerViewList(View view) {
        Intent intent = new Intent(MainActivity.this,recyclerView.class);
        startActivity(intent);
    }
}
