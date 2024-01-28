package org.example.entity;

import com.fasterxml.jackson.annotation.*;
import org.ektorp.support.CouchDbDocument;
import org.json.JSONObject;
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

    public JSONObject generateDocument() {
        JSONObject doc = new JSONObject();
        doc.put("_id", this._id);
        doc.put("id_vehicule", this._id_vehicule);
        doc.put("type", this.type);
        doc.put("nom_assurance", this.nom_assurance);
        doc.put("prix_assurance", this.prix_assurance);
        return doc;
    }
}
