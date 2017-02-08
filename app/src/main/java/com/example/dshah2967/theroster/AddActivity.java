package com.example.dshah2967.theroster;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.SeekBar;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Date;

/**
 * Created by dshah2967 on 1/30/2017.
 */

public class AddActivity extends AppCompatActivity{
    Intent intent=getIntent();
    String name,check=null,radioshirtsize,eyecolor,selecteddate,pant,shirt,shoe;
    SplashScreen splashScreen=new SplashScreen();
    ArrayList<String> array=new ArrayList<String>();
    ArrayAdapter<String> myadapter;
    SharedPreferences sharedPreferences;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);
        this.getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN);
        final EditText nameEditText=(EditText)findViewById(R.id.name_editBox);
        final Spinner spinner=(Spinner)findViewById(R.id.eyecolorSpinner);
        final DatePicker datePicker=(DatePicker)findViewById(R.id.date);
        final RadioGroup radioGroup=(RadioGroup)findViewById(R.id.radio);
        final CheckBox yesCheck=(CheckBox)findViewById(R.id.yes_checkBox);
        final CheckBox noCheck=(CheckBox)findViewById(R.id.no_checkBox);
        RadioButton radioButtonXS = (RadioButton)findViewById(R.id.xs);
        RadioButton radioButtonS = (RadioButton)findViewById(R.id.s);
        RadioButton radioButtonM = (RadioButton)findViewById(R.id.m);
        RadioButton radioButtonL = (RadioButton)findViewById(R.id.l);
        RadioButton radioButtonXL = (RadioButton)findViewById(R.id.xl);
        RadioButton radioButtonXXL = (RadioButton)findViewById(R.id.xxl);
        final TextView textViewPant=(TextView)findViewById(R.id.pantseekText);
        SeekBar pantSeekBar=(SeekBar)findViewById(R.id.seekPant);
        final TextView textViewshirt=(TextView)findViewById(R.id.shirtseekText);
        SeekBar shirtSeekBar=(SeekBar)findViewById(R.id.seekShirt);
        final TextView textViewShoe=(TextView)findViewById(R.id.shoeseekText);
        SeekBar shoeSeekBar=(SeekBar)findViewById(R.id.seekShoe);
        Button addbutton=(Button)findViewById(R.id.addInfoButton);

        spinner.setBackgroundColor(Color.rgb(255,255,255));
        nameEditText.setBackgroundColor(Color.rgb(250,127,101));

        array.add("Black");
        array.add("Brown");
        array.add("Blue");
        array.add("Green");
        array.add("Hazel");
        myadapter=new ArrayAdapter<String>(this,android.R.layout.simple_spinner_dropdown_item,array);
        spinner.setAdapter(myadapter);
        myadapter.notifyDataSetChanged();


//name
        nameEditText.getText().toString().trim();
        if ( nameEditText.getText().toString().trim()==null|| nameEditText.getText().toString().trim()==""){
            nameEditText.setText("");
            nameEditText.setBackgroundColor(Color.rgb(250,127,101));
        }else{
            name=nameEditText.getText().toString().trim();
        }


//checkboxes
         yesCheck.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View v) {
              if(noCheck.isChecked()){
                     noCheck.setChecked(false);
                     check="yes";
                 }
             }
         });

        noCheck.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(noCheck.isChecked()){
                    yesCheck.setChecked(false);
                    check="no";
                }
            }
        });


//spinner
    spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
        @Override
        public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
            eyecolor=parent.getItemAtPosition(position).toString();
        }

        @Override
        public void onNothingSelected(AdapterView<?> parent) {
        }
    });



//datepicker
        int day=datePicker.getDayOfMonth();
        int month=datePicker.getMonth();
        int year=datePicker.getYear();
        selecteddate=(day+"-"+month+"-"+year).toString();




 //radio
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                radioshirtsize=((RadioButton)findViewById(radioGroup.getCheckedRadioButtonId())).getText().toString().toUpperCase();
            }
        });


//pant seek bar
        pantSeekBar.setMax(16);
        pantSeekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            int pantsize=0;
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {

                pantsize = seekBar.getProgress();
                pant = Integer.toString(pantsize);
                textViewPant.setText(pant);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });


//shirt seek bar

        shirtSeekBar.setMax(12);
        shirtSeekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            int shirtsize=0;
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                shirtsize=seekBar.getProgress();
                shirt=Integer.toString(shirtsize);
                textViewshirt.setText(shirt);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });


//shoe seek bar
        shoeSeekBar.setMax(12);
        shoeSeekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            int min=4;
            int shoesize=4;
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
            if(progress>=min){
                shoesize=seekBar.getProgress();
            }else{
                seekBar.setProgress(min);
            }
                shoe=Integer.toString(shoesize);
                textViewShoe.setText(shoe);
            }


            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

//add button
        addbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if ( nameEditText.getText().toString().trim().equals(null)|| nameEditText.getText().toString().trim().equals("")){
                    nameEditText.setText("");
                    nameEditText.setBackgroundColor(Color.rgb(250,127,101));
                }else{
                    name=nameEditText.getText().toString().trim();
                sharedPreferences=getSharedPreferences("preferences",MODE_PRIVATE);
                SharedPreferences.Editor editor= sharedPreferences.edit();
                editor.putString("namekey",name);
                editor.putString("steadykey",check);
                editor.putString("eyekey",eyecolor);
                editor.putString("bdaykey",selecteddate);
                editor.putString("radioshirtkey",radioshirtsize);
                editor.putString("pantkey",pant);
                editor.putString("shirtkey",shirt);
                editor.putString("shoekey",shoe);
                editor.commit();

                Toast toast=Toast.makeText(AddActivity.this,"Person added!",Toast.LENGTH_SHORT);
                toast.show();
                Intent intent=new Intent(AddActivity.this,MainActivity.class);
                startActivity(intent);

            }
        }
        });

 }
}
