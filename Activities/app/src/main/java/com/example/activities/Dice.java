package com.example.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Random;

public class Dice extends AppCompatActivity {
    private int random;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dice);

        ImageView img = findViewById(R.id.imageViewDiceRoll);
        TextView text = findViewById(R.id.textViewRollResult);

        roll(img, text);

        Button btnRoll = findViewById(R.id.buttonRoll);
        btnRoll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                roll(img, text);
            }
        });

        Button btnBack = findViewById(R.id.buttonBackDice);
        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Dice.this,MainActivity.class);
                startActivity(intent);
            }
        });

    }

    private void roll(ImageView img, TextView text){
        random = new Random().nextInt(6);
        switch (random){
            case 0:
                img.setBackgroundResource(R.drawable.dice_1);
                text.setText("Result: 1");
                break;
            case 1:
                img.setBackgroundResource(R.drawable.dice_2);
                text.setText("Result: 2");
                break;
            case 2:
                img.setBackgroundResource(R.drawable.dice_3);
                text.setText("Result: 3");
                break;
            case 3:
                img.setBackgroundResource(R.drawable.dice_4);
                text.setText("Result: 4");
                break;
            case 4:
                img.setBackgroundResource(R.drawable.dice_5);
                text.setText("Result: 5");
                break;
            default:
                img.setBackgroundResource(R.drawable.dice_6);
                text.setText("Result: 6");
                break;

        }
    }
}