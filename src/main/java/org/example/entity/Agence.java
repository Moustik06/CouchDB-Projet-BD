package org.example.entity;

import org.json.JSONObject;
import java.util.ArrayList;

public class Agence extends BaseEntity {

    private final int _id;
    private ArrayList<Integer> _id_employer;
    private final int _id_parking;
    private final String nom;
    private final String adresse;
    private final String telephone;

    public Agence(int id, ArrayList<Integer> id_employer, int id_parking, String nom, String adresse,
            String telephone) {
        this._id = id;
        this._id_employer = id_employer;
        this._id_parking = id_parking;
        this.nom = nom;
        this.adresse = adresse;
        this.telephone = telephone;
    }

    public JSONObject generateDocument() {
        JSONObject doc = new JSONObject();
        doc.put("_id", this._id);
        doc.put("id_employer", this._id_employer);
        doc.put("id_parking", this._id_parking);
        doc.put("nom", this.nom);
        doc.put("adresse", this.adresse);
        doc.put("telephone", this.telephone);
        return doc;
    }
}
