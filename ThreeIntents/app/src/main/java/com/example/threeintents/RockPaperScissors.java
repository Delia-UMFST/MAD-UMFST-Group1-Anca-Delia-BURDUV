package com.example.threeintents;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Random;

public class RockPaperScissors extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rock_paper_scissors);
        ImageView img = findViewById(R.id.imageView);
        TextView text = findViewById(R.id.textView);
        int random = new Random().nextInt(3);
        if(random==0) {
            img.setBackgroundResource(R.drawable.stone);
            text.setText("ROCK!");
        } else if (random==1) {
            img.setBackgroundResource(R.drawable.paper);
            text.setText("PAPER!");
        } else{
            img.setBackgroundResource(R.drawable.scissors);
            text.setText("SCISSORS!");
        }

        Button btnBack = findViewById(R.id.buttonBack);
        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(RockPaperScissors.this,MainActivity.class);
                startActivity(intent);
            }
        });

    }
}