package com.example.merguez.bdd_aeroport;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Création d'une instance de ma classe AeroportsBDD
        AeroportsBDD aeroportsBDD = new AeroportsBDD(this);

        //On ouvre la base de données pour écrire dedans
        aeroportsBDD.open();
        //Aeroport aeroport = new Aeroport("CDG","Charles De Gaulle","Paris","France",49.012779,2.55);
        //aeroportsBDD.insertAeroport(aeroport);
        aeroportsBDD.removeAll();
        //Log.w("TAG",""+aeroportsBDD.getFirstAeroport());
        ///////////////////////////////////////////////////

        InputStream fic = getResources().openRawResource(R.raw.aeroports);
        InputStreamReader streamReader = new InputStreamReader(fic);
        BufferedReader bufferedReader = new BufferedReader(streamReader);
        String line;
        StringBuilder text = new StringBuilder();

        try {
            while (( line = bufferedReader.readLine()) != null) {
                Aeroport aeroport = new Aeroport();
                text.append(line);
                text.append('\n');

                int index1 = line.indexOf(",");
                int index2 = line.indexOf(",",index1+1);
                int index3 = line.indexOf(",",index2+1);
                int index4 = line.indexOf(",",index3+1);
                int index5 = line.indexOf(",",index4+1);
                int index6 = line.indexOf(",",index5+1);
                int index7 = line.indexOf(",",index6+1);
                int index8 = line.indexOf(",",index7+1);
                int index9 = line.indexOf(",",index8+1);

                aeroport.setAita(line.substring(index4 + 2,index5 - 1));
                aeroport.setNom(line.substring(index1 + 2,index2 - 1));
                aeroport.setVille(line.substring(index2 + 2,index3 - 1));
                aeroport.setPays(line.substring(index3 + 2,index4 - 1));
                aeroport.setLatitude(Double.parseDouble(line.substring(index6 + 1,index7)));
                aeroport.setLongitude(Double.parseDouble(line.substring(index7 + 1,index8)));
                Log.w("TAG", "Nom : " + aeroport.getNom() + " /AITA : " + aeroport.getAita() + " /Ville : "
                + aeroport.getVille() + "\nPays : " + aeroport.getPays() + " /Lat : " + aeroport.getLatitude()
                + " /Long" + aeroport.getLongitude());
                aeroportsBDD.insertAeroport(aeroport);
            }
        } catch (IOException e) {
            e.getMessage();
        }


        ///////////////////////////////////////////////////
/*
        //Création d'un aéroport
        Aeroport aeroport = new Aeroport("gerg", "grgerhfghfg");

        //On insère l'aéroport que l'on vient de créer
        aeroportsBDD.insertAeroport(aeroport);

        Aeroport aeroportFromBdd = aeroportsBDD.getAeroportWithNom("Goroka");
        TextView AeroTvAfficherBDD = (TextView) findViewById(R.id.AeroTvAfficherBDD);
        AeroTvAfficherBDD.setText("" + aeroportFromBdd.getNom());
*/
        aeroportsBDD.close();

    }

}
