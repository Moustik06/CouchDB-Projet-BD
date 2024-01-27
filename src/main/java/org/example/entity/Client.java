package org.example.entity;

import org.json.JSONObject;

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

    public Client(int id, String nom, String prenom, String adresse, String telephone, String email) {
        this._id = id;
        this.nom = nom;
        this.prenom = prenom;
        this.adresse = adresse;
        this.telephone = telephone;
        this.email = email;
    }

    public JSONObject generateDocument() {
        JSONObject doc = new JSONObject();
        doc.put("_id", this._id);
        doc.put("nom", this.nom);
        doc.put("prenom", this.prenom);
        doc.put("adresse", this.adresse);
        doc.put("telephone", this.telephone);
        doc.put("email", this.email);
        return doc;
    }
}
