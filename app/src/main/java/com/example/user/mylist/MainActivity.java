package com.example.user.mylist;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.PersistableBundle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private Button button;
    private EditText text;
    private ListView listView;
    private List<String> data = new ArrayList<>();
    private ArrayAdapter adapterList;
    public  DbHellper db;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Create Data Base
        db = new DbHellper(this);
        final SQLiteDatabase database = db.getWritableDatabase();
        final ContentValues contentValues = new ContentValues();

        //Button click
        button = findViewById(R.id.button);
        text = findViewById(R.id.editText);
        listView = findViewById(R.id.listView);


        adapterList = new ArrayAdapter(this, android.R.layout.simple_list_item_1, data);

        readDataFromDB(database);

        //Set to adaptivelist
        listView.setAdapter(adapterList);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //if text is empty
                if (text.getText().toString().matches("")){
                    Toast toast = Toast.makeText(getApplicationContext(), "Введите текст", Toast.LENGTH_LONG);
                    toast.show();
                }else {
                    //if not empty
                    String word = text.getText().toString();
                    //data.add(word)
                    //Insert into data base item
                    contentValues.put(db.KEY_WORD, word);
                    database.insert(db.DB_TABLE, null, contentValues);
                    //Read from db
                    readDataFromDB(database);

                    adapterList.notifyDataSetChanged();
                    //Clear input field
                    text.setText("");
                }
            }

        });
    }

    public void readDataFromDB(SQLiteDatabase database){
        //Read from dataBase
        Cursor cursor = database.query(db.DB_TABLE, null,null,null,null,null,null);
        if (cursor.moveToFirst()){
            int wordIndex = cursor.getColumnIndex(db.KEY_WORD);
            while (cursor.moveToNext()){
                Log.d("Data", cursor.getString(wordIndex));
                data.add(cursor.getString(wordIndex));
            }
        }
        cursor.close();
    }
    //Orientetion

}
