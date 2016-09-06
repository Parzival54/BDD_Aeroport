package com.example.merguez.bdd_aeroport;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.annotation.Nullable;

/**
 * Created by merguez on 05/09/2016.
 */
public class AeroportBDD {

    private static final int VERSION_BDD = 1;
    private static final String NOM_BDD = "aeroports.db";
    private static final String TABLE_AEROPORTS = "table_aeroports";
    private static final String CODE_AITA = "Code_AITA";
    private static final int NUM_CODE_AITA = 0;
    private static final String NOM_AEROPORT = "Nom_Aeroport";
    private static final int NUM_NOM_AEROPORT = 1;

    private SQLiteDatabase bdd;

    private BaseSQLite BaseSQLite;

    public AeroportBDD(Context context){
        //On créer la BDD et sa table
        BaseSQLite = new BaseSQLite(context, NOM_BDD, null, VERSION_BDD);
    }

    public void open(){
        //on ouvre la BDD en écriture
        bdd = BaseSQLite.getWritableDatabase();
    }

    public void close(){
        //on ferme l'accès à la BDD
        bdd.close();
    }

    public SQLiteDatabase getBDD(){
        return bdd;
    }

    public long insertAeroport (Aeroport aeroport){
        //Création d'un ContentValues (fonctionne comme une HashMap)
        ContentValues values = new ContentValues();
        //on lui ajoute une valeur associé à une clé (qui est le nom de la colonne dans laquelle on veut mettre la valeur)
        values.put(CODE_AITA, aeroport.getCodeAita());
        values.put(NOM_AEROPORT, aeroport.getNomAeroport());
        //on insère l'objet dans la BDD via le ContentValues
        return bdd.insert(TABLE_AEROPORTS, null, values);
    }

    public int updateAeroport(String codeAita, Aeroport aeroport){
        //La mise à jour d'un livre dans la BDD fonctionne plus ou moins comme une insertion
        //il faut simple préciser quelle livre on doit mettre à jour grâce à l'ID
        ContentValues values = new ContentValues();
        values.put(CODE_AITA, aeroport.getCodeAita());
        values.put(NOM_AEROPORT, aeroport.getNomAeroport());
        return bdd.update(TABLE_AEROPORTS, values, CODE_AITA + " = " + codeAita, null);
    }

    public int removeAeroportWithAITA(String codeAita){
        //Suppression d'un livre de la BDD grâce à l'ID
        return bdd.delete(TABLE_AEROPORTS, CODE_AITA + " = " + codeAita, null);
    }

    public Aeroport getAeroportWithAita(String codeAita){
        //Récupère dans un Cursor les valeur correspondant à un livre contenu dans la BDD (ici on sélectionne le livre grâce à son titre)
        Cursor c = bdd.query(TABLE_AEROPORTS, new String[] {CODE_AITA, NOM_AEROPORT}, CODE_AITA + " LIKE \"" + codeAita +"\"", null, null, null, null);
        return cursorToAeroport(c);
    }

    //Cette méthode permet de convertir un cursor en un aeroport

    private Aeroport cursorToAeroport(Cursor c){
        //si aucun élément n'a été retourné dans la requête, on renvoie null
        if (c.getCount() == 0)
            return null;

        //Sinon on se place sur le premier élément
        c.moveToFirst();
        //On créé un aeroport
        Aeroport aeroport = new Aeroport();
        //on lui affecte toutes les infos grâce aux infos contenues dans le Cursor
        aeroport.setCodeAita(c.getString(NUM_CODE_AITA));
        aeroport.setNomAeroport(c.getString(NUM_NOM_AEROPORT));
        //On ferme le cursor
        c.close();

        //On retourne l'aeroport
        return aeroport;
    }

}
