package org.example.entity;

import com.fasterxml.jackson.annotation.*;
import org.ektorp.support.CouchDbDocument;
import org.json.JSONObject;

import java.util.ArrayList;

public class Facture extends CouchDbDocument {

    @JsonProperty("_id")
    private final int _id;
    @JsonProperty("idLocation")
    private final int _idLocation;
    @JsonProperty("date")
    private final String date;
    @JsonProperty("totalTTC")
    private final double totalTTC;
    @JsonProperty("acquitte")
    private final boolean acquitte;
    @JsonProperty("doc_type")
    private final String _type;

    public Facture(int _id, int _idLocation, String date, double totalTTC, boolean acquitte) {
        this._id = _id;
        this._idLocation = _idLocation;
        this.date = date;
        this.totalTTC = totalTTC;
        this.acquitte = acquitte;
        this._type = "facture";
        this.setId(String.valueOf(_id));
    }

    public Facture() {
        this._id = 0;
        this._idLocation = 0;
        this.date = "";
        this.totalTTC = 0;
        this.acquitte = false;
        this._type = "facture";

    }

    public ArrayList<String> getData() {
        ArrayList<String> data = new ArrayList<>();
        data.add(String.valueOf(this._id));
        data.add(String.valueOf(this._idLocation));
        data.add(this.date);
        data.add(String.valueOf(this.totalTTC));
        data.add(String.valueOf(this.acquitte));
        return data;
    }

    public int getIdLocation() {
        return _idLocation;
    }

    public double getPrixTTC() {
        return totalTTC;
    }

    public String getDate() {
        return date;
    }

    public int getIdAgence() {
        return _idLocation;
    }

    public int get_id() {
        return _id;
    }
}
