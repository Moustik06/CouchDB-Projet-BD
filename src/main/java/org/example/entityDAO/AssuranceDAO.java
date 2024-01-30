package org.example.entityDAO;

import org.ektorp.ViewQuery;
import org.ektorp.ViewResult;
import org.example.entity.Assurance;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class AssuranceDAO extends BaseDAO {

    // _design/Assurance
    // _assurance

    // retourne les assurances en fonction du critère
    public List<Assurance> getAssuranceByCriteria(String criteria, String value) {
        ViewQuery query = new ViewQuery().designDocId("_design/Assurance").viewName("_assurance");
        ViewResult result = db.queryView(query);

        List<Assurance> assurances = new ArrayList<Assurance>();

        for (ViewResult.Row row : result.getRows()) {
            Assurance assurance = db.get(Assurance.class, row.getId());
            if (criteria.equals("nom_assurance")) {
                if (assurance.getNom_assurance().equals(value)) {
                    assurances.add(assurance);
                }
            } else if (criteria.equals("type")) {
                if (assurance.getType().equals(value)) {
                    assurances.add(assurance);
                }
            } else if (criteria.equals("prix_assurance")) {
                if (assurance.getPrix_assurance() == Integer.parseInt(value)) {
                    assurances.add(assurance);
                }
            } else if (criteria.equals("id")) {
                if (assurance.get_id() == Integer.parseInt(value)) {
                    assurances.add(assurance);
                }
            } else if (criteria.equals("id_vehicule")) {
                if (assurance.get_id_vehicule() == Integer.parseInt(value)) {
                    assurances.add(assurance);
                }
            }
        }

        return assurances;
    }

    // afficher les assurances
    public List<Assurance> getAllAssurance() {
        ViewQuery query = new ViewQuery().designDocId("_design/Assurance").viewName("_assurance");
        ViewResult result = db.queryView(query);

        List<Assurance> assurances = new ArrayList<Assurance>();

        for (ViewResult.Row row : result.getRows()) {
            Assurance assurance = db.get(Assurance.class, row.getId());
            assurances.add(assurance);
        }

        return assurances;
    }

    // afficher les assurances par ordre alphabétique

    public List<Assurance> getAllAssuranceAlpha() {
        ViewQuery query = new ViewQuery().designDocId("_design/Assurance").viewName("_assurance");
        ViewResult result = db.queryView(query);

        List<Assurance> assurances = new ArrayList<Assurance>();

        for (ViewResult.Row row : result.getRows()) {
            Assurance assurance = db.get(Assurance.class, row.getId());
            assurances.add(assurance);
        }

        assurances.sort(Comparator.comparing(Assurance::getNom_assurance));

        return assurances;
    }

    // afficher les assurances par prix croissant
    public List<Assurance> getAssuPrixCroissant() {
        ViewQuery query = new ViewQuery().designDocId("_design/Assurance").viewName("_assurance");
        ViewResult result = db.queryView(query);

        List<Assurance> assurances = new ArrayList<Assurance>();

        for (ViewResult.Row row : result.getRows()) {
            Assurance assurance = db.get(Assurance.class, row.getId());
            assurances.add(assurance);
        }

        assurances.sort(Comparator.comparing(Assurance::getPrix_assurance));

        return assurances;
    }

    // afficher assurance pour un type donne (ex: tier ou full)
    public List<Assurance> getAssuByType(String type) {
        ViewQuery query = new ViewQuery().designDocId("_design/Assurance").viewName("_assurance");
        ViewResult result = db.queryView(query);

        List<Assurance> assurances = new ArrayList<Assurance>();

        for (ViewResult.Row row : result.getRows()) {
            Assurance assurance = db.get(Assurance.class, row.getId());
            if (assurance.getType().equals(type)) {
                assurances.add(assurance);
            }
        }

        return assurances;
    }

    // afficher assurance pour un id donne
    public Assurance getAssuById(int id) {
        ViewQuery query = new ViewQuery().designDocId("_design/Assurance").viewName("_assurance");
        ViewResult result = db.queryView(query);

        Assurance assurance = new Assurance();

        for (ViewResult.Row row : result.getRows()) {
            assurance = db.get(Assurance.class, row.getId());
            if (assurance.get_id() == id) {
                break;
            }
        }

        return assurance;
    }

}
