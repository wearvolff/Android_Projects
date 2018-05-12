package com.example.user.mylist;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
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


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //Button click
        button = findViewById(R.id.button);
        text = findViewById(R.id.editText);
        listView = findViewById(R.id.listView);

        adapterList = new ArrayAdapter(this, android.R.layout.simple_list_item_1, data);
        listView.setAdapter(adapterList);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //if text is empty
                if (text.getText().toString().matches("")){
                    Toast toast = Toast.makeText(getApplicationContext(), "Введите текст", Toast.LENGTH_LONG);
                    toast.show();
                }
                //if not empty
                data.add(text.getText().toString());
                adapterList.notifyDataSetChanged();
                //Clear input field
                text.setText("");
            }

        });
    }


}
