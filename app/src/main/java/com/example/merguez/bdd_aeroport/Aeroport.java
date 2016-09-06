package com.example.merguez.bdd_aeroport;

/**
 * Created by merguez on 06/09/2016.
 */

public class Aeroport {

    private int id;
    private String aita;
    private String nom;

    public Aeroport(){}

    public Aeroport(String aita, String nom){
        this.aita = aita;
        this.nom = nom;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAita() {
        return aita;
    }

    public void setAita(String aita) {
        this.aita = aita;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String toString(){
        return "ID : "+id+"\nAITA : "+ aita +"\nNom : "+ nom;
    }
}
