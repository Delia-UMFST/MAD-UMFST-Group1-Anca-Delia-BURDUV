package com.example.ovbha;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.net.Uri;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements LocationListener {


    private ArrayList<String> diagnostics;
    private ArrayList<String> contacts;
    private LocationManager locationManager;
    private Location location;

    Button buttonSos;
    Button buttonMap;
    Button buttonAssist;
    Button buttonServices;
    Button buttonDiagnose;
    Button buttonWeather;
    Button buttonChecklist;

    TextView textViewLocation;
    TextView textViewDiagnostic;

    private static final int PERMISSION_SEND_SMS = 0;
    private static final int PERMISSIONS_LOCATION = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textViewLocation=findViewById(R.id.textViewLocation);
        textViewDiagnostic=findViewById(R.id.textViewDiagnostic);

        locationManager = (LocationManager) getSystemService(Context.LOCATION_SERVICE);
        initContacts();
        initDiagnostics();
        requestRuntimePermissions();

        buttonSos = findViewById(R.id.buttonSOS);
        buttonSos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(ActivityCompat.checkSelfPermission(MainActivity.this, Manifest.permission.ACCESS_FINE_LOCATION) == PackageManager.PERMISSION_GRANTED &&
                        ActivityCompat.checkSelfPermission(MainActivity.this, Manifest.permission.SEND_SMS) == PackageManager.PERMISSION_GRANTED)
                {
                    String message = "OVBHA SOS Service" + System.getProperty("line.separator") +
                            "Current location: " + location.getLatitude() + ", " + location.getLongitude() + System.getProperty("line.separator") +
                            " Issue: " + diagnostics.get(0);

                    for (String contact : contacts) {
                        try {
                            SmsManager smsManager = SmsManager.getDefault();
                            smsManager.sendTextMessage(contact, null, message, null, null);
                            Toast.makeText(MainActivity.this, "SOS sent to "+contact, Toast.LENGTH_SHORT).show();
                        } catch (Exception e) {
                            Toast.makeText(MainActivity.this, "Failed to send SMS", Toast.LENGTH_SHORT).show();
                        }
                    }
                }
            }
        });

        buttonMap = findViewById(R.id.buttonMap);
        buttonMap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse("geo:"+location.getLongitude()+","+location.getLatitude()));
                Intent chooser = Intent.createChooser(intent,"Launch Map");
                startActivity(chooser);
            }
        });

        buttonAssist = findViewById(R.id.buttonAssistance);
        buttonAssist.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //TO-DO: Assistance coordination(?)
                Toast.makeText(MainActivity.this, "Assistance requested", Toast.LENGTH_SHORT).show();
            }
        });

        buttonServices=findViewById(R.id.buttonServices);
        buttonServices.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, ServicesActivity.class);
                startActivity(intent);
            }
        });

        buttonDiagnose=findViewById(R.id.buttonDiagnostic);
        buttonDiagnose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textViewDiagnostic.setText(diagnostics.get(0));
            }
        });

        buttonWeather=findViewById(R.id.buttonWeather);
        buttonWeather.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, WeatherActivity.class);
                intent.putExtra("longitude",location.getLongitude());
                intent.putExtra("latitude",location.getLatitude());
                startActivity(intent);
            }
        });
        buttonChecklist=findViewById(R.id.buttonChecklist);
        buttonChecklist.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, ChecklistActivity.class);
                startActivity(intent);
            }
        });
    }

    private void requestRuntimePermissions() {
        if (ActivityCompat.checkSelfPermission(this, android.Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.ACCESS_FINE_LOCATION}, PERMISSIONS_LOCATION);
        }
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.SEND_SMS) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.SEND_SMS}, PERMISSION_SEND_SMS);
        }

        location = locationManager.getLastKnownLocation(LocationManager.GPS_PROVIDER);
        if(location==null){
            location=new Location(LocationManager.GPS_PROVIDER);
            location.setLongitude(46.53483011225801);
            location.setLatitude(24.58435446597514);
        }
        textViewLocation.setText(location.toString());
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (requestCode == PERMISSIONS_LOCATION) {
            if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
            } else {
                Toast.makeText(this, "Location needed for localisation", Toast.LENGTH_SHORT).show();
            }
        } else if (requestCode == PERMISSION_SEND_SMS) {
            if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
            } else {
                Toast.makeText(this, "Sending SMS needed for SOS messages", Toast.LENGTH_SHORT).show();
            }
        }
    }

    @Override
    public void onLocationChanged(@NonNull Location location) {
        this.location=location;
    }

    private void initContacts(){
        contacts = new ArrayList<>();
        contacts.add("+40740301882");
        //contacts.add("+40733045262");
        //contacts.add("+40744377727");
        //contacts.add("+40365426958");
    }

    private void initDiagnostics() {
        diagnostics = new ArrayList<>();
        diagnostics.add("Engine Failure");
        diagnostics.add("Brake Failure");
        diagnostics.add("Battery Failure");
        diagnostics.add("Out Of Fuel");
        diagnostics.add("No Issues Found");
    }

}