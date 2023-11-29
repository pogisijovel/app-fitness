package com.example.myapplication;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.myapplication.R;

public class BMICalculatorActivity extends AppCompatActivity {

    private EditText editWeight, editHeight;
    private Button btnCalculateBMI;
    private TextView textBMIResult;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bmicalculator);

        editWeight = findViewById(R.id.editTextWeight);
        editHeight = findViewById(R.id.editTextHeight);
        btnCalculateBMI = findViewById(R.id.buttonCalculate);
        textBMIResult = findViewById(R.id.textViewResult);

        btnCalculateBMI.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculateBMI();
            }
        });
    }

    private void calculateBMI() {
        String weightStr = editWeight.getText().toString().trim();
        String heightStr = editHeight.getText().toString().trim();

        if (weightStr.isEmpty() || heightStr.isEmpty()) {
            Toast.makeText(this, "Please enter weight and height values", Toast.LENGTH_SHORT).show();
            return;
        }

        double weight = Double.parseDouble(weightStr);
        double height = Double.parseDouble(heightStr) / 100;

        if (height <= 0) {
            Toast.makeText(this, "Invalid height value", Toast.LENGTH_SHORT).show();
            return;
        }

        double bmi = weight / (height * height);

        String bmiResult = String.format("Your BMI: %.1f", bmi);
        textBMIResult.setText(bmiResult);
        textBMIResult.setVisibility(View.VISIBLE);
    }

}



