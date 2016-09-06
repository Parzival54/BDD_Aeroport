package com.example.merguez.bdd_aeroport;

/**
 * Created by merguez on 05/09/2016.
 */
public class Aeroport {
    private String codeAita;
    private String nomAeroport;

    public Aeroport(){}

    public Aeroport(String codeAita, String nomAeroport) {
        this.codeAita = codeAita;
        this.nomAeroport = nomAeroport;
    }

    public String getCodeAita() {
        return codeAita;
    }

    public String getNomAeroport() {
        return nomAeroport;
    }

    public void setCodeAita(String codeAita) {
        this.codeAita = codeAita;
    }

    public void setNomAeroport(String nomAeroport) {
        this.nomAeroport = nomAeroport;
    }


    public String toString() {
        return "\nCode AITA : " + codeAita + "\nNom aéroport : " + nomAeroport;
    }
}
