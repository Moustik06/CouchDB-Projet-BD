package org.example.entity;

import org.json.JSONObject;

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

    public Parking(int _id, int _idVehicule, int _idAgence, int nbPlace, int nbDispo) {
        this._id = _id;
        this._idVehicule = _idVehicule;
        this._idAgence = _idAgence;
        this.nombrePlace = nbPlace;
        this.nombrePlaceDispo = nbDispo;
    }

    public JSONObject generateDocument() {
        JSONObject doc = new JSONObject();
        doc.put("_id", this._id);
        doc.put("idVehicule", this._idVehicule);
        doc.put("idAgence", this._idAgence);
        doc.put("nbPlace", this.nombrePlace);
        doc.put("nbDispo", this.nombrePlaceDispo);
        return doc;
    }
}
