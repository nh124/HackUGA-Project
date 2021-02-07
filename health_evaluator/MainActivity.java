package com.example.health_evaluator;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.MultiAutoCompleteTextView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    String name;
    String gender;
    boolean male, female;
    int age;

    EditText nameInput;
    EditText ageInput;

    RadioGroup genderInput;
    RadioButton genderButton1;
    RadioButton genderButton2;
    Button submitButton;
    Button Test;
    Button SubmitTest;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        nameInput = findViewById(R.id.editTextName);
        ageInput = findViewById(R.id.editTextAge);

        genderButton1 = findViewById(R.id.maleButton);
        genderButton2 = findViewById(R.id.femaleButton);
        genderInput = findViewById(R.id.radioGroup);
        submitButton = findViewById(R.id.submitButton);
        Test = findViewById(R.id.submitButton);
        SubmitTest = findViewById(R.id.submitButton);
        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (validateFields()) {

                    name = nameInput.getText().toString();
                    age = Integer.valueOf(ageInput.getText().toString());

                    if (genderButton1.isChecked())
                        male = true;
                    else
                        female = true;

                    showResults();
                }
                else showErrorToast();
            }
        });
        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openActivity4();
            }
        });
        Test.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openActivity3();
            }
        });

    }

    private void showErrorToast(){
        Toast.makeText(MainActivity.this, "Please fill the form", Toast.LENGTH_SHORT).show();
    }

    public void showResults(){
        Intent intent = new Intent(this, Activity2.class);
        intent.putExtra("user_name", name);
        intent.putExtra("user_age", age);
        intent.putExtra("user_male", male);
        intent.putExtra("user_female", female);

        startActivity(intent);
    }
    public void openActivity3(){
        Intent intent = new Intent(this,Activity3.class);
        intent.putExtra("user_name", name);
        intent.putExtra("user_age", age);
        intent.putExtra("user_male", male);
        intent.putExtra("user_female", female);
        startActivity(intent);
    }

    public void openActivity4(){
        Intent intent = new Intent(this,Main4Activity.class);
        intent.putExtra("user_name", name);
        intent.putExtra("user_age", age);
        intent.putExtra("user_male", male);
        intent.putExtra("user_female", female);
        startActivity(intent);
    }


    public boolean validateFields(){

        if (TextUtils.isEmpty(nameInput.getText().toString())) {
            return false;
        }

        else if (TextUtils.isEmpty(ageInput.getText().toString())) {
            return false;
        }

        else if (genderInput.getCheckedRadioButtonId() == -1)
        {
            return false;
        }

        return true;
    }

}