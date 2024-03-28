package com.example.ovbha;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class WeatherActivity extends AppCompatActivity {


    private double longitude=46.53483011225801;
    private double latitude=24.58435446597514;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_weather);

        TextView textViewTemp = (TextView) findViewById(R.id.textViewTemp);
        TextView textViewHum = findViewById(R.id.textViewHum);
        TextView textViewDesc = findViewById(R.id.textViewDesc);

        Intent intent = getIntent();
        longitude=intent.getDoubleExtra("longitude",46.53483011225801);
        latitude=intent.getDoubleExtra("latitude",24.58435446597514);

        String url = "https://api.openweathermap.org/data/2.5/weather?lat=" + longitude +
                "&lon=" + latitude + "&appid=57e9f68b4e3750478e12167189acd74d";

        RequestQueue queue = Volley.newRequestQueue(this);
        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.GET, url, null,
                response -> {
                   try {
                        JSONObject mainObject = response.getJSONObject("main");

                        double temp = mainObject.getDouble("temp")- 273.15;
                        textViewTemp.setText(String.format("%.2f", temp) + "°C");

                        double hum=mainObject.getDouble("humidity");
                        textViewHum.setText(String.format("%s", hum));

                        JSONArray weatherArray = response.getJSONArray("weather");
                        String weatherCondition = "";
                        if (weatherArray.length() > 0) {
                            JSONObject weatherObject = weatherArray.getJSONObject(0);
                            weatherCondition = weatherObject.getString("main");
                        }
                        textViewDesc.setText(weatherCondition);


                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }, Throwable::printStackTrace);

        queue.add(jsonObjectRequest);

    }

}