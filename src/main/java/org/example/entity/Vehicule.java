package org.example.entity;

import com.fasterxml.jackson.annotation.*;
import org.ektorp.support.CouchDbDocument;
import org.json.JSONObject;

import java.util.ArrayList;

public class Vehicule extends CouchDbDocument {

    @JsonProperty("_id")
    private final int _id;
    @JsonProperty("id_agence")
    private final int _id_agence;
    @JsonProperty("marque")
    private final String marque;
    @JsonProperty("modele")
    private final String modele;
    @JsonProperty("prix")
    private final double prix;
    @JsonProperty("caution")
    private final double caution;
    @JsonProperty("plaque_imat")
    private final String plaque_imat;

    @JsonProperty("doc_type")
    private final String _type;

    public Vehicule(int _id, int _id_agence, String marque, String modele, double prix, double caution,
            String plaque_imat) {
        this._id = _id;
        this._id_agence = _id_agence;
        this.marque = marque;
        this.modele = modele;
        this.prix = prix;
        this.caution = caution;
        this.plaque_imat = plaque_imat;
        this._type = "vehicule";
        this.setId(String.valueOf(_id));

    }

    public Vehicule() {
        this._id = 0;
        this._id_agence = 0;
        this.marque = "";
        this.modele = "";
        this.prix = 0;
        this.caution = 0;
        this.plaque_imat = "";
        this._type = "vehicule";

    }

    public ArrayList<String> getData() {
        ArrayList<String> data = new ArrayList<String>();
        data.add(String.valueOf(this._id));
        data.add(String.valueOf(this._id_agence));
        data.add(this.marque);
        data.add(this.modele);
        data.add(String.valueOf(this.prix));
        data.add(String.valueOf(this.caution));
        data.add(this.plaque_imat);
        return data;
    }

    public String getModele() {
        return modele;
    }

    public String getMarque() {
        return marque;
    }

    public int getId_agence() {
        return _id_agence;
    }

    public double getPrix() {
        return prix;
    }

    public String getPlaque_imat() {
        return plaque_imat;
    }
}
