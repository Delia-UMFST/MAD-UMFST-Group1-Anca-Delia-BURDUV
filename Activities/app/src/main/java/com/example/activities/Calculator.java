package com.example.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Calculator extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculator);


        EditText num1=(EditText)findViewById(R.id.editTextNumber1);
        EditText num2=(EditText)findViewById(R.id.editTextNumber2);

        Button btnAdd=findViewById(R.id.buttonAdd);
        Button btnSub=findViewById(R.id.buttonSub);
        Button btnMul=findViewById(R.id.buttonMul);
        Button btnDiv=findViewById(R.id.buttonDiv);

        TextView result = (TextView)findViewById(R.id.textViewCalcResult);

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String s1=num1.getText().toString();
                String s2=num2.getText().toString();
                if(s1.isEmpty() || s2.isEmpty())
                {
                    result.setText("error");
                }
                else {

                    float n1 = Float.parseFloat(s1);
                    float n2 = Float.parseFloat(s2);
                    float res = n1 + n2;

                    result.setText(Float.toString(res));
                }
            }
        });
        btnSub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String s1=num1.getText().toString();
                String s2=num2.getText().toString();
                if(s1.isEmpty() || s2.isEmpty())
                {
                    result.setText("error");
                }
                else {

                    float n1 = Float.parseFloat(s1);
                    float n2 = Float.parseFloat(s2);
                    float res = n1 - n2;

                    result.setText(Float.toString(res));
                }
            }
        });
        btnMul.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String s1=num1.getText().toString();
                String s2=num2.getText().toString();
                if(s1.isEmpty() || s2.isEmpty())
                {
                    result.setText("error");
                }
                else {

                    float n1 = Float.parseFloat(s1);
                    float n2 = Float.parseFloat(s2);
                    float res = n1 * n2;

                    result.setText(Float.toString(res));
                }
            }
        });
        btnDiv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String s1=num1.getText().toString();
                String s2=num2.getText().toString();
                if(s1.isEmpty() || s2.isEmpty())
                {
                    result.setText("error");
                }
                else {

                    float n1 = Float.parseFloat(s1);
                    float n2 = Float.parseFloat(s2);
                    float res = n1 / n2;

                    result.setText(Float.toString(res));
                }
            }
        });

        Button btnBack = findViewById(R.id.buttonBackCalc);
        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Calculator.this,MainActivity.class);
                startActivity(intent);
            }
        });
    }
}