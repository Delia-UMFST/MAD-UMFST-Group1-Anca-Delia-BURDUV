package com.example.lab2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.button.MaterialButton;

public class MainActivity extends AppCompatActivity {
    private int count=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView count_view =findViewById(R.id.textview_counter);
        count_view.setText(String.valueOf(count));

        MaterialButton btn_message = findViewById(R.id.button_message);
        btn_message.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(),"Default message",Toast.LENGTH_LONG).show();
            }
        });

        MaterialButton btn_count = findViewById(R.id.button_counter);
        btn_count.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ++count;
                count_view.setText(String.valueOf(count));
            }
        });

    }

}