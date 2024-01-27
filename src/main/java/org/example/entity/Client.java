package org.example.entity;

import org.json.JSONObject;

public class Client extends BaseEntity {
    private final int _id;
    private final String nom;
    private final String prenom;
    private final String adresse;
    private final String telephone;
    private final String email;

    public Client(int id, String nom, String prenom, String adresse, String telephone, String email) {
        this._id = id;
        this.nom = nom;
        this.prenom = prenom;
        this.adresse = adresse;
        this.telephone = telephone;
        this.email = email;
    }

    @Override
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
