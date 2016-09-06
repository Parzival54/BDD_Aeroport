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

        //Création d'une instance de ma classe AeroportsBDD
        AeroportsBDD aeroportsBDD = new AeroportsBDD(this);

        //On ouvre la base de données pour écrire dedans
        aeroportsBDD.open();
        aeroportsBDD.removeAll();

        //Création d'un aéroport
        Aeroport aeroport = new Aeroport("gerg", "grgerhfghfg");

        //On insère l'aéroport que l'on vient de créer
        aeroportsBDD.insertAeroport(aeroport);

        Aeroport aeroportFromBdd = aeroportsBDD.getAeroportWithNom(aeroport.getNom());
        TextView AeroTvAfficherBDD = (TextView) findViewById(R.id.AeroTvAfficherBDD);
        AeroTvAfficherBDD.setText("" + aeroportFromBdd.toString());

        aeroportsBDD.close();

    }

}
