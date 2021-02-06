package com.example.health_evaluator;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.MultiAutoCompleteTextView;
import android.widget.TextView;

public class Activity2 extends AppCompatActivity {

    String name, symptoms;
    int age;

    MultiAutoCompleteTextView symptomInput;
    TextView displayGreeting, displayInstructions;
    private static final String[] COMMON_SYMPTOMS = new String[] {
            "cough", "fever", "diarrhea", "fatigue", "muscle aches", "headache", "hypothermia", "weight gain",
            "weight loss", "emaciation", "tremor", "confusion", "hallucinations", "phantom smells", "back pain",
            "neck pain", "lower-back pain", "chest pain", "dizziness", "hearing loss", "loss of hearing",
            "sleep deprivation", "shoulder pain", "ear pain", "tooth pain", "toothache", "pelvic pain",
            "constipation", "nausea", "vomiting", "snoring", "sneezing"
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_2);

        Intent intent = getIntent();
        name = intent.getStringExtra("user_name");

        displayGreeting = findViewById(R.id.display1);
        displayInstructions = findViewById(R.id.display2);

        if (name == "")
            displayGreeting.setText("Hello User");
        else
            displayGreeting.setText("Hello " + name);

        symptomInput = findViewById(R.id.mactv);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1, COMMON_SYMPTOMS);




        symptomInput.setAdapter(adapter);

        symptomInput.setTokenizer(new MultiAutoCompleteTextView.CommaTokenizer());


    }
}