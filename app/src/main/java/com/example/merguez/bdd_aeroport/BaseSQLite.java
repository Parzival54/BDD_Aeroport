package com.example.merguez.bdd_aeroport;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by merguez on 05/09/2016.
 */
public class BaseSQLite extends SQLiteOpenHelper {

    private static final String TABLE_AEROPORTS = "table_aeroports";
    private static final String CODE_AITA = "Code_AITA";
    private static final String NOM_AEROPORT = "Nom_Aeroport";

    private static final String CREATE_BDD = "CREATE TABLE " + TABLE_AEROPORTS + " ("
            + CODE_AITA + " TEXT PRIMARY KEY NOT NULL, " + NOM_AEROPORT + " TEXT NOT NULL);";

    public BaseSQLite(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        //on créé la table à partir de la requête écrite dans la variable CREATE_BDD
        db.execSQL(CREATE_BDD);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        //On peut fait ce qu'on veut ici moi j'ai décidé de supprimer la table et de la recréer
        //comme ça lorsque je change la version les id repartent de 0
        db.execSQL("DROP TABLE " + TABLE_AEROPORTS + ";");
        onCreate(db);
    }

}
