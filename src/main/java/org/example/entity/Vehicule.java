package org.example.entity;

import com.fasterxml.jackson.annotation.*;
import org.ektorp.support.CouchDbDocument;
import org.json.JSONObject;

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

    public Vehicule(int _id, int _id_agence, String marque, String modele, double prix, double caution,
            String plaque_imat) {
        this._id = _id;
        this._id_agence = _id_agence;
        this.marque = marque;
        this.modele = modele;
        this.prix = prix;
        this.caution = caution;
        this.plaque_imat = plaque_imat;
        this.setId(String.valueOf(_id));

    }

    public JSONObject generateDocument() {
        JSONObject doc = new JSONObject();
        doc.put("_id", this._id);
        doc.put("id_agence", this._id_agence);
        doc.put("marque", this.marque);
        doc.put("modele", this.modele);
        doc.put("prix", this.prix);
        doc.put("caution", this.caution);
        doc.put("plaque_imat", this.plaque_imat);
        return doc;
    }
}
