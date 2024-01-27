package org.example.entity;

import org.json.JSONObject;

public class Employer extends BaseEntity {

    private final int _id;
    private final int _id_agence;
    private final String nom;
    private final String prenom;
    private final String adresse;
    private final String tel;
    private final String emploi;

    public Employer(int _id, int _id_agence, String nom, String prenom, String adresse, String tel, String emploi) {
        this._id = _id;
        this._id_agence = _id_agence;
        this.nom = nom;
        this.prenom = prenom;
        this.adresse = adresse;
        this.tel = tel;
        this.emploi = emploi;
    }

    @Override
    public JSONObject generateDocument() {
        JSONObject doc = new JSONObject();
        doc.put("_id", this._id);
        doc.put("id_agence", this._id_agence);
        doc.put("nom", this.nom);
        doc.put("prenom", this.prenom);
        doc.put("adresse", this.adresse);
        doc.put("tel", this.tel);
        doc.put("emploi", this.emploi);
        return doc;
    }
}
