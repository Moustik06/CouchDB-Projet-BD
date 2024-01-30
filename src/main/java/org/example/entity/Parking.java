package org.example.entity;

import com.fasterxml.jackson.annotation.*;
import org.ektorp.support.CouchDbDocument;
import org.json.JSONObject;

import java.util.ArrayList;

public class Parking extends CouchDbDocument {

    @JsonProperty("_id")
    private final int _id;
    @JsonProperty("idVehicule")
    private final int _idVehicule;
    @JsonProperty("idAgence")
    private final int _idAgence;
    @JsonProperty("nbPlace")
    private final int nombrePlace;
    @JsonProperty("nbDispo")
    private final int nombrePlaceDispo;

    @JsonProperty("doc_type")
    private final String _type;

    public Parking(int _id, int _idVehicule, int _idAgence, int nbPlace, int nbDispo) {
        this._id = _id;
        this._idVehicule = _idVehicule;
        this._idAgence = _idAgence;
        this.nombrePlace = nbPlace;
        this.nombrePlaceDispo = nbDispo;
        this._type = "parking";

        this.setId(String.valueOf(_id));
    }

    public Parking() {
        this._id = 0;
        this._idVehicule = 0;
        this._idAgence = 0;
        this.nombrePlace = 0;
        this.nombrePlaceDispo = 0;
        this._type = "parking";
    }

    public ArrayList<String> getData() {
        ArrayList<String> data = new ArrayList<>();
        data.add(String.valueOf(_id));
        data.add(String.valueOf(_idVehicule));
        data.add(String.valueOf(_idAgence));
        data.add(String.valueOf(nombrePlace));
        data.add(String.valueOf(nombrePlaceDispo));
        return data;
    }

    public int getIdAgence() {
        return _idAgence;
    }

    public int getIdVehicule() {
        return _idVehicule;
    }

    public int getNombrePlaceDispo() {
        return nombrePlaceDispo;
    }

    public int getNombrePlace() {
        return nombrePlace;
    }

    public int get_id() {
        return _id;
    }
}
