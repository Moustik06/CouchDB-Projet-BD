package org.example.enitty;

import com.fasterxml.jackson.databind.JsonNode;
import org.ektorp.support.CouchDbDocument;

public class Agence extends CouchDbDocument {

    private String nom;
    private String adresse;


    public String getAdresse() {
        return adresse;
    }

    public String getNom() {
        return nom;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String toJson() {
        return "{\"nom\":\"" + nom + "\",\"adresse\":\"" + adresse + "\"}";
    }

}
