package com.example.sahayak;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class Questions extends AppCompatActivity {
    TextView tv;
    Button submitbutton;
    RadioGroup radio_g;
    RadioButton rb1,rb2,rb3;

    public String[] questions = {
            "What gender can you identify as?",
            "What is your age?",
            "Describe your marital status:",
            "Total number of kids:",
            "Select your highest education level:",
            "Do you get regular salary?",
            "What is the total number of members in family?",
            "How will you describe your living expenses?"

    };
     String[] choices = {
            "Male","Female","Other",
            "<=18","18<40",">40",
            "Married","Unmarried","Divorced",
            "Zero","1 or 2",">2",
            "<=5","between 5 and 10","More than 10",
            "No","Yes","I'm a student",
            "Around 4","Around 10","More than 10",
            "High","Low","Moderate"
    };
    int flag=0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_questions);
        submitbutton=(Button)findViewById(R.id.option4);
        tv=(TextView) findViewById(R.id.text2);

        radio_g=(RadioGroup)findViewById(R.id.answersgrp);
        rb1=(RadioButton)findViewById(R.id.option1);
        rb2=(RadioButton)findViewById(R.id.option2);
        rb3=(RadioButton)findViewById(R.id.option3);
        tv.setText(questions[flag]);
        rb1.setText(choices[0]);
        rb2.setText(choices[1]);
        rb3.setText(choices[2]);



submitbutton.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        //int color = mBackgroundColor.getColor();
        //mLayout.setBackgroundColor(color);

        if (radio_g.getCheckedRadioButtonId() == -1) {
            Toast.makeText(getApplicationContext(), "Please select one choice", Toast.LENGTH_SHORT).show();
            return;
        }


        flag++;
        if(flag<questions.length)
        {
            tv.setText(questions[flag]);
            rb1.setText(choices[flag*3]);
            rb2.setText(choices[flag*3 +1]);
            rb3.setText(choices[flag*3 +2]);
       }
        else
        {

            Intent in = new Intent(getApplicationContext(),ResultActivity.class);
            startActivity(in);
        }
        radio_g.clearCheck();

    }


});
    }
}