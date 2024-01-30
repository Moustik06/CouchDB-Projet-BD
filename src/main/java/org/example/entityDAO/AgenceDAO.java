package org.example.entityDAO;

import org.ektorp.ViewQuery;
import org.ektorp.ViewResult;
import org.ektorp.support.CouchDbDocument;
import org.ektorp.support.View;
import org.example.entity.Agence;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class AgenceDAO extends BaseDAO {

    // -design/Agence
    // _agence

    // retourne les agences en fonction du critère
    public List<Agence> getAgenceByCriteria(String criteria, String value) {
        ViewQuery query = new ViewQuery().designDocId("_design/Agence").viewName("_agence");
        ViewResult result = db.queryView(query);

        List<Agence> agences = new ArrayList<Agence>();

        for (ViewResult.Row row : result.getRows()) {
            Agence agence = db.get(Agence.class, row.getId());
            if (criteria.equals("nom")) {
                if (agence.getNom().equals(value)) {
                    agences.add(agence);
                }
            } else if (criteria.equals("adresse")) {
                if (agence.getAdresse().equals(value)) {
                    agences.add(agence);
                }
            } else if (criteria.equals("nombreEmploye")) {
                if (agence.getNombreEmploye() == Integer.parseInt(value)) {
                    agences.add(agence);
                }
            } else if (criteria.equals("nombreClients")) {
                if (agence.getNombreClients() == Integer.parseInt(value)) {
                    agences.add(agence);
                }
            } else if (criteria.equals("id")) {
                if (agence.getId().equals(value)) {
                    agences.add(agence);
                }
            } else if (criteria.equals("telephone")) {
                if (agence.getTelephone().equals(value)) {
                    agences.add(agence);
                }
            }
        }

        return agences;
    }

    // afficher les agences
    public List<Agence> getAllAgence() {
        ViewQuery query = new ViewQuery().designDocId("_design/Agence").viewName("_agence");
        ViewResult result = db.queryView(query);

        List<Agence> agences = new ArrayList<Agence>();

        for (ViewResult.Row row : result.getRows()) {
            Agence agence = db.get(Agence.class, row.getId());
            agences.add(agence);
        }

        return agences;
    }

    // afficher les agences par ordre alphabétique
    public List<Agence> getAllAgenceByAlphabeticalOrder() {
        ViewQuery query = new ViewQuery().designDocId("_design/Agence").viewName("_agence");
        ViewResult result = db.queryView(query);

        List<Agence> agences = new ArrayList<Agence>();

        for (ViewResult.Row row : result.getRows()) {
            Agence agence = db.get(Agence.class, row.getId());
            agences.add(agence);
        }

        agences.sort(Comparator.comparing(Agence::getNom));

        return agences;
    }

    // afficher les agences par nombre d'employés ordre croissant
    public List<Agence> getAllAgenceByNbEmploye() {
        ViewQuery query = new ViewQuery().designDocId("_design/Agence").viewName("_agence");
        ViewResult result = db.queryView(query);

        List<Agence> agences = new ArrayList<Agence>();

        for (ViewResult.Row row : result.getRows()) {
            Agence agence = db.get(Agence.class, row.getId());
            agences.add(agence);
        }

        agences.sort(Comparator.comparing(Agence::getNombreEmploye));

        return agences;
    }

    // afficher les agences par nombre de clients ordre décroissant
    public List<Agence> getAllAgenceByNbClient() {
        ViewQuery query = new ViewQuery().designDocId("_design/Agence").viewName("_agence");
        ViewResult result = db.queryView(query);

        List<Agence> agences = new ArrayList<Agence>();

        for (ViewResult.Row row : result.getRows()) {
            Agence agence = db.get(Agence.class, row.getId());
            agences.add(agence);
        }

        agences.sort(Comparator.comparing(Agence::getNombreClients).reversed());

        return agences;
    }

    // afficher agence par un id donne
    public Agence getAgenceById(int id) {
        ViewQuery query = new ViewQuery().designDocId("_design/Agence").viewName("_agence");
        ViewResult result = db.queryView(query);

        Agence agence = new Agence();

        for (ViewResult.Row row : result.getRows()) {
            Agence agenceTemp = db.get(Agence.class, row.getId());
            if (agenceTemp.getId().equals(String.valueOf(id))) {
                agence = agenceTemp;
            }
        }

        return agence;
    }

}
