package com.example.dshah2967.theroster;

import android.app.Activity;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

import static java.util.logging.Logger.global;

public class MainActivity extends AppCompatActivity {
   SharedPreferences sharedPreferences;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Intent i=getIntent();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TextView textView = (TextView) findViewById(R.id.list);
        sharedPreferences=getSharedPreferences("preferences",MODE_PRIVATE);
        if(sharedPreferences==null){
            textView.setText("Please add a person");
        }else{
        String name=sharedPreferences.getString("namekey",null);
            textView.setText(name);
            textView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent infointent=new Intent(MainActivity.this,InfoActivity.class);
                    startActivity(infointent);
                }
            });
        }
        Button addbutton=(Button) findViewById(R.id.addButton);
        addbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent addintent=new Intent(MainActivity.this,AddActivity.class);
                startActivity(addintent);
            }
        });
    }
}

