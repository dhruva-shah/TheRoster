package com.example.dshah2967.theroster;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import java.util.Date;

/**
 * Created by dshah2967 on 1/30/2017.
 */

public class InfoActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info);
        Intent intent=getIntent();
        SharedPreferences sharedPreferences=getSharedPreferences("preferences",MODE_PRIVATE);
        TextView nametextview=(TextView)findViewById(R.id.nametextView);
        TextView steadytextview=(TextView)findViewById(R.id.steadytext);
        TextView eyetext=(TextView)findViewById(R.id.eyecolorText);
        TextView bdaytextview=(TextView)findViewById(R.id.date);
        TextView radioshirttextview=(TextView)findViewById(R.id.radioshirtText);
        TextView panttextview=(TextView)findViewById(R.id.pantseekText);
        TextView shirttextview=(TextView)findViewById(R.id.shirtseekText);
        TextView shoetextview=(TextView)findViewById(R.id.shoeseekText);


        nametextview.setText(sharedPreferences.getString("namekey",null));
        steadytextview.setText(sharedPreferences.getString("steadykey",null));
        eyetext.setText(sharedPreferences.getString("eyekey","black"));
        bdaytextview.setText(sharedPreferences.getString("bdaykey", null));
        radioshirttextview.setText(sharedPreferences.getString("radioshirtkey","XS"));
        panttextview.setText(sharedPreferences.getString("pantkey","0"));
        shirttextview.setText(sharedPreferences.getString("shirtkey","0"));
        shoetextview.setText(sharedPreferences.getString("shoekey","4"));
    }
 }

