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

    // retourne les voitures en fonction du critère
    public List<Vehicule> getVehiculeByCriteria(String criteria, String value) {
        ViewQuery query = new ViewQuery().designDocId("_design/Vehicule").viewName("_vehicule");

        ViewResult result = db.queryView(query);

        List<Vehicule> vehicules = new ArrayList<Vehicule>();

        for (ViewResult.Row row : result.getRows()) {
            Vehicule vehicule = db.get(Vehicule.class, row.getId());
            if (criteria.equals("modele")) {
                if (vehicule.getModele().equals(value)) {
                    vehicules.add(vehicule);
                }
            } else if (criteria.equals("marque")) {
                if (vehicule.getMarque().equals(value)) {
                    vehicules.add(vehicule);
                }
            } else if (criteria.equals("imat")) {
                if (vehicule.getPlaque_imat().equals(value)) {
                    vehicules.add(vehicule);
                }
            } else if (criteria.equals("id_agence")) {
                if (vehicule.getId_agence() == Integer.parseInt(value)) {
                    vehicules.add(vehicule);
                }
            } else if (criteria.equals("prix")) {
                if (vehicule.getPrix() == Double.parseDouble(value)) {
                    vehicules.add(vehicule);
                }
            } else if (criteria.equals("id")) {
                if (vehicule.get_id() == Integer.parseInt(value)) {
                    vehicules.add(vehicule);
                }
            } else if (criteria.equals("id_agence")) {
                if (vehicule.getId_agence() == Integer.parseInt(value)) {
                    vehicules.add(vehicule);
                }
            }
        }

        return vehicules;
    }

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

    public List<Vehicule> vehiculesParPrixEtAgence(double prixMax, String nomAgence) {
        // Premièrement, récupérer l'ID de l'agence en fonction de son nom
        // Cela nécessite soit une requête supplémentaire, soit une structure de données
        // adaptée
        AgenceDAO agenceDAO = new AgenceDAO();
        String idAgence = agenceDAO.getAgenceByCriteria("nom", nomAgence).get(0).getId(); // méthode pour récupérer l'ID
        // de l'agence à partir du nom
        int idAgenceInt = Integer.parseInt(idAgence);

        ViewQuery query = new ViewQuery()
                .designDocId("_design/Vehicule")
                .viewName("byPriceAndAgenceId")
                .key(idAgenceInt)
                .startKey(Arrays.asList(idAgenceInt, 0))
                .endKey(Arrays.asList(idAgenceInt, prixMax));

        List<Vehicule> vehicules = new ArrayList<>();
        ViewResult result = db.queryView(query);

        for (ViewResult.Row row : result.getRows()) {
            Vehicule vehicule = db.get(Vehicule.class, row.getId());
            if (vehicule.getPrix() <= prixMax && vehicule.getId_agence() == Integer.parseInt(idAgence)) {
                vehicules.add(vehicule);
            }
        }

        return vehicules;
    }

    //marche pas celle la
    public List<Vehicule> marqueModelePlusLoues(){
        ViewQuery query = new ViewQuery()
                .designDocId("_design/Vehicule")
                .viewName("countByMarqueModele");

        List<Vehicule> vehicules = new ArrayList<>();
        ViewResult result = db.queryView(query);

        System.out.println(result.getRows()); // bon res

        for (ViewResult.Row row : result.getRows()) {
            // ici bug car dans les tests generer location possède un id_vehicule 1 2 3etc
            // alors que nos id de vehicule sont de 6100 à 7100

            // get the vehicule by id
            System.out.println(row.getId());
            Vehicule vehicule = db.get(Vehicule.class, row.getId());
            System.out.println(vehicule);
            vehicules.add(vehicule);
        }
        System.out.println(vehicules);

        return vehicules;
    }


}