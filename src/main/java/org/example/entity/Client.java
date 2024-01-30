package org.example.entity;

import com.fasterxml.jackson.annotation.*;
import org.ektorp.support.CouchDbDocument;

import java.util.ArrayList;

public class Client extends CouchDbDocument {

    @JsonProperty("_id")
    private final int _id;
    @JsonProperty("nom")
    private final String nom;
    @JsonProperty("prenom")
    private final String prenom;
    @JsonProperty("adresse")
    private final String adresse;
    @JsonProperty("telephone")
    private final String telephone;
    @JsonProperty("email")
    private final String email;

    @JsonProperty("doc_type")
    private final String _type;

    public Client(int id, String nom, String prenom, String adresse, String telephone, String email) {
        this._id = id;
        this.nom = nom;
        this.prenom = prenom;
        this.adresse = adresse;
        this.telephone = telephone;
        this.email = email;
        this._type = "client";

        this.setId(String.valueOf(id));
    }

    public Client() {
        this._id = 0;
        this.nom = "";
        this.prenom = "";
        this.adresse = "";
        this.telephone = "";
        this.email = "";
        this._type = "client";
    }

    public ArrayList<String> getData() {
        ArrayList<String> data = new ArrayList<>();
        data.add(String.valueOf(this._id));
        data.add(this.nom);
        data.add(this.prenom);
        data.add(this.adresse);
        data.add(this.telephone);
        data.add(this.email);
        return data;
    }

    public String getNom() {
        return nom;
    }

    public String getEmail() {
        return email;
    }

    public String getPrenom() {
        return prenom;
    }

    public String getAdresse() {
        return adresse;
    }

    public String getTelephone() {
        return telephone;
    }
}
