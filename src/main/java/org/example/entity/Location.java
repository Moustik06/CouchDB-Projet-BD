package org.example.entity;

import org.json.JSONObject;

public class Location extends BaseEntity {
    private final int _id;
    private final int _id_client;
    private final int _id_vehicule;
    private final int _id_agence;
    private final int _id_employe;
    private final String date_debut;
    private final String date_fin;
    private final int _id_parkingRecup;
    private final int _id_parkingRendu;
    private final double prix_ttc;

    public Location(int _id, int _id_client, int _id_vehicule, int _id_agence, int _id_employe, String date_debut,
            String date_fin, int _id_parkingRecup, int _id_parkingRendu, double prix_ttc) {
        this._id = _id;
        this._id_client = _id_client;
        this._id_vehicule = _id_vehicule;
        this._id_agence = _id_agence;
        this._id_employe = _id_employe;
        this.date_debut = date_debut;
        this.date_fin = date_fin;
        this._id_parkingRecup = _id_parkingRecup;
        this._id_parkingRendu = _id_parkingRendu;
        this.prix_ttc = prix_ttc;
    }

    @Override
    public JSONObject generateDocument() {
        JSONObject doc = new JSONObject();
        doc.put("_id", this._id);
        doc.put("id_client", this._id_client);
        doc.put("id_vehicule", this._id_vehicule);
        doc.put("id_agence", this._id_agence);
        doc.put("id_employe", this._id_employe);
        doc.put("date_debut", this.date_debut);
        doc.put("date_fin", this.date_fin);
        doc.put("id_parkingRecup", this._id_parkingRecup);
        doc.put("id_parkingRendu", this._id_parkingRendu);
        doc.put("prix_ttc", this.prix_ttc);
        return doc;
    }
}
