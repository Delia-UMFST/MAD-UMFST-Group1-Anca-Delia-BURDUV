package com.example.book;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        FragmentManager fragmentManager = getSupportFragmentManager();
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.fragmentContainerView, introduction.class, null)
                .setReorderingAllowed(true)
                .addToBackStack("name")
                .commit();

        Button ch1=findViewById(R.id.button2);
        ch1.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){

                FragmentManager fragmentManager = getSupportFragmentManager();
                getSupportFragmentManager().beginTransaction()
                        .replace(R.id.fragmentContainerView, Chapter1.class, null)
                        .setReorderingAllowed(true)
                        .addToBackStack("name")
                        .commit();

            }
        });
        Button ch2=findViewById(R.id.button3);
        ch2.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){

                FragmentManager fragmentManager = getSupportFragmentManager();
                getSupportFragmentManager().beginTransaction()
                        .replace(R.id.fragmentContainerView, Chapter2.class, null)
                        .setReorderingAllowed(true)
                        .addToBackStack("name")
                        .commit();

            }
        });
        Button ch3=findViewById(R.id.button4);
        ch3.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){

                FragmentManager fragmentManager = getSupportFragmentManager();
                getSupportFragmentManager().beginTransaction()
                        .replace(R.id.fragmentContainerView, Chapter3.class, null)
                        .setReorderingAllowed(true)
                        .addToBackStack("name")
                        .commit();

            }
        });
        Button ch4=findViewById(R.id.button5);
        ch4.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){

                FragmentManager fragmentManager = getSupportFragmentManager();
                getSupportFragmentManager().beginTransaction()
                        .replace(R.id.fragmentContainerView, Chapter4.class, null)
                        .setReorderingAllowed(true)
                        .addToBackStack("name")
                        .commit();

            }
        });
    }
}