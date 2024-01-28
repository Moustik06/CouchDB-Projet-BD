package org.example.entity;

import com.fasterxml.jackson.annotation.*;
import org.ektorp.support.CouchDbDocument;
import org.json.JSONObject;

import java.util.ArrayList;

public class Assurance extends CouchDbDocument {

    @JsonProperty("_id")
    private final int _id;
    @JsonProperty("id_vehicule")
    private final int _id_vehicule;
    @JsonProperty("type")
    private final String type;
    @JsonProperty("nom_assurance")
    private final String nom_assurance;
    @JsonProperty("prix_assurance")
    private final double prix_assurance;

    @JsonProperty("doc_type")
    private final String _type;
    public Assurance(int _id, int _id_vehicule, String type, String nom_assurance, double prix_assurance) {
        this._id = _id;
        this._id_vehicule = _id_vehicule;
        this.type = type;
        this.nom_assurance = nom_assurance;
        this.prix_assurance = prix_assurance;

        this._type = "assurance";
        this.setId(String.valueOf(_id));
    }

    public Assurance(){
        this._type = "assurance";
        this._id = 0;
        this._id_vehicule = 0;
        this.type = "";
        this.nom_assurance = "";
        this.prix_assurance = 0;
    }

    public ArrayList<String> getData() {
        ArrayList<String> data = new ArrayList<String>();
        data.add(String.valueOf(_id));
        data.add(String.valueOf(_id_vehicule));
        data.add(type);
        data.add(nom_assurance);
        data.add(String.valueOf(prix_assurance));
        return data;
    }

    public <U> U getNom_assurance() {
        return (U) nom_assurance;
    }

    // getPrix_assurance cest un double
    public double getPrix_assurance() {
        return  prix_assurance;
    }

    public String getType() {
        return type;
    }

    public int get_id() {
        return _id;
    }
}
