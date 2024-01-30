package org.example.entity;

import com.fasterxml.jackson.annotation.*;
import org.ektorp.support.CouchDbDocument;
import org.json.JSONObject;

import java.util.ArrayList;

public class Employer extends CouchDbDocument {

    @JsonProperty("_id")
    private final int _id;
    @JsonProperty("id_agence")
    private final int _id_agence;
    @JsonProperty("nom")
    private final String nom;
    @JsonProperty("prenom")
    private final String prenom;
    @JsonProperty("adresse")
    private final String adresse;
    @JsonProperty("tel")
    private final String tel;
    @JsonProperty("emploi")
    private final String emploi;

    @JsonProperty("doc_type")
    private final String _type;

    public Employer(int _id, int _id_agence, String nom, String prenom, String adresse, String tel, String emploi) {
        this._id = _id;
        this._id_agence = _id_agence;
        this.nom = nom;
        this.prenom = prenom;
        this.adresse = adresse;
        this.tel = tel;
        this.emploi = emploi;
        this._type = "employer";
        this.setId(String.valueOf(_id));
    }

    public Employer() {
        this._id = 0;
        this._id_agence = 0;
        this.nom = "";
        this.prenom = "";
        this.adresse = "";
        this.tel = "";
        this.emploi = "";
        this._type = "employer";
    }

    public ArrayList<String> getData() {
        ArrayList<String> data = new ArrayList<>();
        data.add(String.valueOf(this._id));
        data.add(String.valueOf(this._id_agence));
        data.add(this.nom);
        data.add(this.prenom);
        data.add(this.adresse);
        data.add(this.tel);
        data.add(this.emploi);
        return data;
    }

    public String getJob() {
        return this.emploi;
    }

    public int getIdAgence() {
        return this._id_agence;
    }

    public String getNom() {
        return this.nom;
    }

    public String getPrenom() {
        return this.prenom;
    }

    public String getAdresse() {
        return this.adresse;
    }

    public String getTel() {
        return this.tel;
    }
}
