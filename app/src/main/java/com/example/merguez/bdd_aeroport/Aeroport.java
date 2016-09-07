package com.example.merguez.bdd_aeroport;

/**
 * Created by merguez on 06/09/2016.
 */

public class Aeroport {

    private int id;
    private String aita;
    private String nom;
    private String ville;
    private String pays;
    private double latitude;
    private double longitude;

    public Aeroport(){}

    public Aeroport(String aita, String nom, String ville, String pays, double latitude, double longitude) {
        this.aita = aita;
        this.nom = nom;
        this.ville = ville;
        this.pays = pays;
        this.latitude = latitude;
        this.longitude = longitude;
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
        return "ID : "+id+"\nAITA : "+ aita +"\nNom : "+ nom +"\nVille : " +ville
                +"\nPays : " + pays;
    }

    public String getVille() {
        return ville;
    }

    public void setVille(String ville) {
        this.ville = ville;
    }

    public String getPays() {
        return pays;
    }

    public void setPays(String pays) {
        this.pays = pays;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }
}
