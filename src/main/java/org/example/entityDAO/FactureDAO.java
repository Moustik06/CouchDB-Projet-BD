package org.example.entityDAO;

import org.ektorp.ViewQuery;
import org.ektorp.ViewResult;
import org.example.entity.Facture;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FactureDAO extends BaseDAO {

    // retourne les factures en fonction du critère

    public List<Facture> getFactureByCriteria(String criteria, String value) {
        ViewQuery query = new ViewQuery().designDocId("_design/Facture").viewName("_facture");

        ViewResult result = db.queryView(query);

        List<Facture> factures = new ArrayList<Facture>();

        for (ViewResult.Row row : result.getRows()) {
            Facture facture = db.get(Facture.class, row.getId());
            if (criteria.equals("idLocation")) {
                if (facture.getIdLocation() == Integer.parseInt(value)) {
                    factures.add(facture);
                }
            } else if (criteria.equals("idAgence")) {
                if (facture.getIdAgence() == Integer.parseInt(value)) {
                    factures.add(facture);
                }
            } else if (criteria.equals("date")) {
                if (facture.getDate().equals(value)) {
                    factures.add(facture);
                }
            } else if (criteria.equals("prixTTC")) {
                if (facture.getPrixTTC() == Double.parseDouble(value)) {
                    factures.add(facture);
                }
            } else if (criteria.equals("id")) {
                if (facture.get_id() == Integer.parseInt(value)) {
                    factures.add(facture);
                }
            }
        }

        return factures;
    }

    public List<Facture> getAllFactures() {
        ViewQuery query = new ViewQuery().designDocId("_design/Facture").viewName("_facture");
        ViewResult result = db.queryView(query);

        List<Facture> factures = new ArrayList<Facture>();

        for (ViewResult.Row row : result.getRows()) {
            Facture facture = db.get(Facture.class, row.getId());
            factures.add(facture);
        }

        return factures;
    }

    public List<Facture> getFactureByLocation(int idLocation) {
        ViewQuery query = new ViewQuery().designDocId("_design/Facture").viewName("_facture");

        ViewResult result = db.queryView(query);

        List<Facture> factures = new ArrayList<Facture>();

        for (ViewResult.Row row : result.getRows()) {
            Facture facture = db.get(Facture.class, row.getId());
            if (facture.getIdLocation() == idLocation) {
                factures.add(facture);
            }
        }

        return factures;

    }

    public Facture getFactureById(int idFacture) {
        ViewQuery query = new ViewQuery().designDocId("_design/Facture").viewName("_facture");

        ViewResult result = db.queryView(query);

        Facture facture = new Facture();

        for (ViewResult.Row row : result.getRows()) {
            facture = db.get(Facture.class, row.getId());
            if (Integer.parseInt(facture.getId()) == idFacture) {
                break;
            }
        }

        return facture;
    }

    public List<Facture> getFacturesSortedByPrices() {
        ViewQuery query = new ViewQuery().designDocId("_design/Facture").viewName("_facture");

        ViewResult result = db.queryView(query);

        List<Facture> factures = new ArrayList<Facture>();

        for (ViewResult.Row row : result.getRows()) {
            Facture facture = db.get(Facture.class, row.getId());
            factures.add(facture);
        }

        factures.sort(Comparator.comparingDouble(Facture::getPrixTTC).reversed());

        return factures;
    }

    public List<Facture> getFacturesByDate(String date) {
        ViewQuery query = new ViewQuery().designDocId("_design/Facture").viewName("_facture");

        ViewResult result = db.queryView(query);

        List<Facture> factures = new ArrayList<Facture>();

        for (ViewResult.Row row : result.getRows()) {
            Facture facture = db.get(Facture.class, row.getId());
            if (facture.getDate().equals(date)) {
                factures.add(facture);
            }
        }

        return factures;
    }

    public List<Facture> getFacturesByDateAndAgence(String date, int idAgence) {
        ViewQuery query = new ViewQuery().designDocId("_design/Facture").viewName("_facture");

        ViewResult result = db.queryView(query);

        List<Facture> factures = new ArrayList<Facture>();

        for (ViewResult.Row row : result.getRows()) {
            Facture facture = db.get(Facture.class, row.getId());
            if (facture.getDate().equals(date) && facture.getIdAgence() == idAgence) {
                factures.add(facture);
            }
        }

        return factures;
    }

}
