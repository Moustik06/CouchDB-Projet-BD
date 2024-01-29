package org.example.entityDAO;

import org.ektorp.*;
import org.ektorp.http.StdHttpClient;
import org.ektorp.impl.StdCouchDbConnector;
import org.ektorp.impl.StdCouchDbInstance;
import org.ektorp.support.CouchDbDocument;
import org.ektorp.support.CouchDbRepositorySupport;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.example.entity.Agence;
import org.example.entity.Vehicule;
import org.json.JSONObject;

public class VehiculeDAO extends BaseDAO {

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

    public List<Map<String, Object>> marqueModelePlusLoues() {
        ViewQuery query = new ViewQuery()
                .designDocId("_design/Location")
                .viewName("countByMarqueModele")
                .groupLevel(2); // Grouper par marque et modèle

        ViewResult result = db.queryView(query);
        List<Map<String, Object>> marqueModeleCounts = new ArrayList<>();

        for (ViewResult.Row row : result.getRows()) {
            Map<String, Object> marqueModeleCount = new HashMap<>();
            Object key = row.getKey();

            if (key instanceof List) {
                @SuppressWarnings("unchecked")
                List<String> keyList = (List<String>) key;

                if (keyList.size() >= 2) {
                    marqueModeleCount.put("marque", keyList.get(0));
                    marqueModeleCount.put("modele", keyList.get(1));
                    marqueModeleCount.put("count", row.getValueAsInt());
                    marqueModeleCounts.add(marqueModeleCount);
                }
            }
        }

        // Trier par le nombre de fois louées (count) en ordre décroissant
        marqueModeleCounts.sort((a, b) -> (Integer) b.get("count") - (Integer) a.get("count"));

        return marqueModeleCounts;
    }

    public List<Vehicule> vehiculesParPrixEtAgence(double prixMax, String nomAgence) {
        // Premièrement, récupérer l'ID de l'agence en fonction de son nom
        // Cela nécessite soit une requête supplémentaire, soit une structure de données
        // adaptée
        int idAgence = 0; // méthode pour récupérer l'ID de l'agence à partir du nom

        ViewQuery query = new ViewQuery()
                .designDocId("_design/vehicule")
                .viewName("byPriceAndAgenceId")
                .key(idAgence)
                .startKey(Arrays.asList(idAgence, 0))
                .endKey(Arrays.asList(idAgence, prixMax));

        List<Vehicule> vehicules = new ArrayList<>();
        ViewResult result = db.queryView(query);

        for (ViewResult.Row row : result.getRows()) {
            Vehicule vehicule = db.get(Vehicule.class, row.getId());
            if (vehicule.getPrix() <= prixMax && vehicule.getId_agence() == idAgence) {
                vehicules.add(vehicule);
            }
        }

        return vehicules;
    }
}