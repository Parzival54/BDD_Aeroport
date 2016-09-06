package com.example.merguez.bdd_aeroport;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

            AeroportBDD aeroportBDD = new AeroportBDD(this);

            Aeroport aeroport = new Aeroport("LAX", "Los Angeles International Airport");

            aeroportBDD.open();

            aeroportBDD.insertAeroport(aeroport);

            TextView AeroTvAfficherBDD = (TextView) findViewById(R.id.AeroTvAfficherBDD);

            AeroTvAfficherBDD.setText("" + aeroport.toString());

            aeroportBDD.close();

    }
}
