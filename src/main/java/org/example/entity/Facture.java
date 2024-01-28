package org.example.entity;

import com.fasterxml.jackson.annotation.*;
import org.ektorp.support.CouchDbDocument;
import org.json.JSONObject;

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

    public JSONObject generateDocument() {
        JSONObject doc = new JSONObject();
        doc.put("_id", this._id);
        doc.put("idLocation", this._idLocation);
        doc.put("date", this.date);
        doc.put("totalTTC", this.totalTTC);
        doc.put("acquitte", this.acquitte);
        return doc;
    }
}
