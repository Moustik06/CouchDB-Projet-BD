package org.example.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeId;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.ektorp.support.CouchDbDocument;
import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;

public class Agence extends CouchDbDocument {

    @JsonProperty("_id")
    private final int _id;
    @JsonProperty("id_employer")
    private ArrayList<Integer> _id_employer;
    @JsonProperty("id_parking")
    private final int _id_parking;
    @JsonProperty("nom")
    private final String nom;
    @JsonProperty("adresse")
    private final String adresse;
    @JsonProperty("telephone")
    private final String telephone;

    public Agence(int id, ArrayList<Integer> id_employer, int id_parking, String nom, String adresse,
            String telephone) {
        this._id = id;
        this._id_employer = id_employer;
        this._id_parking = id_parking;
        this.nom = nom;
        this.adresse = adresse;
        this.telephone = telephone;

        this.setId(Integer.toString(id));
    }

    public JSONObject generateDocument() {
        JSONObject json = new JSONObject();
        json.put("_id", this._id);
        json.put("id_employer", this._id_employer);
        json.put("id_parking", this._id_parking);
        json.put("nom", this.nom);
        json.put("adresse", this.adresse);
        json.put("telephone", this.telephone);
        return json;
    }
}
