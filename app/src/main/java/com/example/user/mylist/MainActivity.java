package com.example.user.mylist;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private Button button;
    private TextView text;
    private ListView listView;
    private String[] data = new String[1];
    private  ArrayAdapter adapterList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //Button click
        button = findViewById(R.id.button);
        text = findViewById(R.id.text);
        listView = findViewById(R.id.listView);

        adapterList = new ArrayAdapter(this, android.R.layout.simple_list_item_1, data);
        listView.setAdapter(adapterList);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //if text is empty
                if (text.getText() == ""){
                    Toast toast = Toast.makeText(getApplicationContext(), "Введите текст", Toast.LENGTH_LONG);
                    toast.show();
                }
                //if not empty
                if (data.length >= 1){
                    String []newData = new String[data.length+5];
                    System.arraycopy(data,0, newData, 0, data.length);
                    data = newData;
                }

            }
        });
    }


}
