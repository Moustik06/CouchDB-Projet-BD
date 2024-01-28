package org.example.entityDAO;
import org.ektorp.*;
import org.ektorp.http.StdHttpClient;
import org.ektorp.impl.StdCouchDbConnector;
import org.ektorp.impl.StdCouchDbInstance;
import org.ektorp.support.CouchDbDocument;
import org.ektorp.support.CouchDbRepositorySupport;

import java.util.ArrayList;
import java.util.List;

import org.example.entity.Agence;
import org.example.entity.Vehicule;
import org.json.JSONObject;

public class VehiculeDAO extends BaseDAO{

    public List<Vehicule> getAllVehicule() {
        ViewQuery query = new ViewQuery().designDocId("_design/Vehicule").viewName("_vehicule");
        ViewResult result = db.queryView(query);

        List<Vehicule> vehicules = new ArrayList<Vehicule>();

        for (ViewResult.Row row : result.getRows()) {
            Vehicule vehicule = db.get(Vehicule.class, row.getId());
            vehicules.add(vehicule);
        }

        return vehicules;
    }

    public List<Vehicule> getVehiculeByModel(String modele) {
        ViewQuery query = new ViewQuery().designDocId("_design/Vehicule").viewName("_vehicule");

        ViewResult result = db.queryView(query);

        List<Vehicule> vehicules = new ArrayList<Vehicule>();

        for (ViewResult.Row row : result.getRows()) {
            Vehicule vehicule = db.get(Vehicule.class, row.getId());
            if (vehicule.getModele().equals(modele)) {
                vehicules.add(vehicule);
            }
        }

        return vehicules;

    }

    public List<Vehicule> getVehiculeByMarque(String marque) {
        ViewQuery query = new ViewQuery().designDocId("_design/Vehicule").viewName("_vehicule");

        ViewResult result = db.queryView(query);

        List<Vehicule> vehicules = new ArrayList<Vehicule>();

        for (ViewResult.Row row : result.getRows()) {
            Vehicule vehicule = db.get(Vehicule.class, row.getId());
            if (vehicule.getMarque().equals(marque)) {
                vehicules.add(vehicule);
            }
        }

        return vehicules;

    }

    public List<Vehicule> getVehiculeByAgence(int id_agence) {
        ViewQuery query = new ViewQuery().designDocId("_design/Vehicule").viewName("_vehicule");

        ViewResult result = db.queryView(query);

        List<Vehicule> vehicules = new ArrayList<Vehicule>();

        for (ViewResult.Row row : result.getRows()) {
            Vehicule vehicule = db.get(Vehicule.class, row.getId());
            if (vehicule.getId_agence() == id_agence) {
                vehicules.add(vehicule);
            }
        }

        return vehicules;

    }

    public List<Vehicule> getVehiculeByImat(String imat) {
        ViewQuery query = new ViewQuery().designDocId("_design/Vehicule").viewName("_vehicule");

        ViewResult result = db.queryView(query);

        List<Vehicule> vehicules = new ArrayList<Vehicule>();

        for (ViewResult.Row row : result.getRows()) {
            Vehicule vehicule = db.get(Vehicule.class, row.getId());
            if (vehicule.getPlaque_imat().equals(imat)) {
                vehicules.add(vehicule);
            }
        }

        return vehicules;

    }
}