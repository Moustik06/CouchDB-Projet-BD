package org.example.entity;

import com.fasterxml.jackson.annotation.*;
import org.ektorp.support.CouchDbDocument;
import org.json.JSONObject;

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
