package com.example.health_evaluator;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

public class Activity3 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        String yes;
        String no;
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_3);
        int yesC = 0;
        int noC = 0;

        Intent intent = getIntent();
        yes = intent.getStringExtra("yes");
        no = intent.getStringExtra("no");

        if (yes == "yes")
            yesC++;
        else
            noC++;


        if(yesC > 1){
            // displays Covid Positive
        }else{
            // displays Covid negative
        }
    }


}