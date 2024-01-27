package org.example.entity;

import org.json.JSONObject;

public class Vehicule extends BaseEntity {

    private final int _id;
    private final int _id_agence;
    private final String marque;
    private final String modele;
    private final double prix;
    private final double caution;
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
    }

    @Override
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
