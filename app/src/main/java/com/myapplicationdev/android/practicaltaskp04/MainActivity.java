package com.myapplicationdev.android.practicaltaskp04;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    EditText etID,etName,etGpa;
    Button btnInsert , btnGet;
    TextView tvResults;
    ArrayList<Student> details;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etID = findViewById(R.id.etID);
        etName=findViewById(R.id.etName);
        etGpa=findViewById(R.id.etGPA);
        btnInsert=findViewById(R.id.btnInsert);
        btnGet=findViewById(R.id.btnRetreive);
        tvResults=findViewById(R.id.Result);

        btnInsert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                DBHelper db = new DBHelper(MainActivity.this);
                db.insertTask(etName.getText().toString(), Double.parseDouble(etGpa.getText().toString()));
                db.close();

            }
        });

        btnGet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Create the DBHelper object, passing in the
                // activity's Context
                DBHelper db = new DBHelper(MainActivity.this);

                // Insert a task
                ArrayList<String> data = db.getTaskContent();
                db.close();

                String txt = "";
                for (int i = 0; i < data.size(); i++) {
                    Log.d("Database Content", i +". "+data.get(i));
                    txt += i + ". " + data.get(i) + "\n";
                }


                tvResults.setText(txt);
            }
        });

    }
}