package org.example.entity;

import com.fasterxml.jackson.annotation.*;
import org.ektorp.support.CouchDbDocument;

import java.util.ArrayList;

public class Location extends CouchDbDocument {

    @JsonProperty("_id")
    private final int _id;
    @JsonProperty("idClient")
    private final int _id_client;
    @JsonProperty("idVehicule")
    private final int _id_vehicule;
    @JsonProperty("idAgence")
    private final int _id_agence;
    @JsonProperty("idEmploye")
    private final int _id_employe;
    @JsonProperty("dateDebut")
    private final String date_debut;
    @JsonProperty("dateFin")
    private final String date_fin;
    @JsonProperty("id_parkingRecup")
    private final int _id_parkingRecup;
    @JsonProperty("id_parkingRendu")
    private final int _id_parkingRendu;
    @JsonProperty("prixTTC")
    private final double prix_ttc;

    @JsonProperty("doc_type")
    private final String _type;
    public Location(int _id, int _id_client, int _id_vehicule, int _id_agence, int _id_employe, String date_debut,
            String date_fin, int _id_parkingRecup, int _id_parkingRendu, double prix_ttc) {
        this._id = _id;
        this._id_client = _id_client;
        this._id_vehicule = _id_vehicule;
        this._id_agence = _id_agence;
        this._id_employe = _id_employe;
        this.date_debut = date_debut;
        this.date_fin = date_fin;
        this._id_parkingRecup = _id_parkingRecup;
        this._id_parkingRendu = _id_parkingRendu;
        this.prix_ttc = prix_ttc;
        this._type = "location";
        this.setId(String.valueOf(_id));

    }

    public Location(){
        this._id = 0;
        this._id_client = 0;
        this._id_vehicule = 0;
        this._id_agence = 0;
        this._id_employe = 0;
        this.date_debut = "";
        this.date_fin = "";
        this._id_parkingRecup = 0;
        this._id_parkingRendu = 0;
        this.prix_ttc = 0;
        this._type = "location";

    }

    public ArrayList<String> getData(){
        ArrayList<String> data = new ArrayList<String>();
        data.add(String.valueOf(this._id));
        data.add(String.valueOf(this._id_client));
        data.add(String.valueOf(this._id_vehicule));
        data.add(String.valueOf(this._id_agence));
        data.add(String.valueOf(this._id_employe));
        data.add(this.date_debut);
        data.add(this.date_fin);
        data.add(String.valueOf(this._id_parkingRecup));
        data.add(String.valueOf(this._id_parkingRendu));
        data.add(String.valueOf(this.prix_ttc));
        return data;
    }

    public int getIdClient() {
        return _id_client;
    }

    public int getIdVehicule() {
        return _id_vehicule;
    }

    public int getIdAgence() {
        return _id_agence;
    }

    public int getIdEmploye() {
        return _id_employe;
    }

    public double getPrixTTC() {
        return prix_ttc;
    }

    public String getDateDebut() {
        return date_debut;
    }
}
