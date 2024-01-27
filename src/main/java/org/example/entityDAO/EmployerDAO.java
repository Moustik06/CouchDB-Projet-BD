package org.example.entityDAO;

import org.example.entity.Agence;
import org.example.entity.Employer;
import org.apache.poi.ss.formula.functions.T;
import org.ektorp.CouchDbConnector;
import org.ektorp.support.DesignDocument;
import org.ektorp.ViewQuery;
import org.ektorp.support.View;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class EmployerDAO extends BaseDAO {

    public void createIndexes() {
        String designDocId = "_design/employer";
        DesignDocument designDoc;

        if (getDatabase().contains(designDocId)) {
            designDoc = getDatabase().get(DesignDocument.class, designDocId);
        } else {
            designDoc = new DesignDocument(designDocId);
        }

        DesignDocument.View view = new DesignDocument.View();
        view.setMap("function(doc) { if (doc.type === 'Employer' && doc.id_agence) { emit(doc.id_agence, null); } }");

        designDoc.getViews().put("byIdAgence", view);
        getDatabase().update(designDoc);
    }

    public List<Employer> getIdAgence(String idAgence) {
        ViewQuery query = new ViewQuery()
                .designDocId("_design/employer")
                .viewName("byIdAgence")
                .key(idAgence)
                .includeDocs(true);
        return getDatabase().queryView(query, Employer.class);
    }

    public List<T> findByCriteria(Class<T> entityClass, JSONObject criteria, String viewName) {
        // Convertir JSONObject en Map pour passer des paramètres de requête
        Map<String, Object> queryParameters = new HashMap<>();
        criteria.keys().forEachRemaining(key -> {
            queryParameters.put(key, criteria.get(key));
        });

        // Créer et exécuter la requête de vue
        ViewQuery query = new ViewQuery().designDocId("_design/" + entityClass.getSimpleName().toLowerCase())
                .viewName(viewName)
                .includeDocs(true)
                .keys(queryParameters.values());

        return getDatabase().queryView(query, entityClass);
    }

    public List<Employer> employesParAgence(int idAgence) {
        // Utiliser la vue créée pour trouver les employés par id_agence
        ViewQuery query = new ViewQuery().designDocId("_design/employer").viewName("byIdAgence").key(idAgence);
        return getDatabase().queryView(query, Employer.class);
    }

    public Map<String, Object> detailsEmployeParAgence(int idEmploye) {
        // Récupérer les détails de l'employé
        Employer employe = getDatabase().get(Employer.class, String.valueOf(idEmploye));
        Map<String, Object> details = new HashMap<>();

        if (employe != null && employe.getIdAgence() != null) {
            // Récupérer les détails de l'agence associée à l'employé
            Agence agence = getDatabase().get(Agence.class, employe.getIdAgence());

            // Combiner les informations de l'employé et de l'agence
            details.put("employe", employe);
            details.put("agence", agence);
        }

    public List<Employer> chefsAgences() {
        // Utiliser une vue CouchDB pour trouver les chefs de toutes les agences.
        ViewQuery query = new ViewQuery().designDocId("_design/employer").viewName("byEmploi").key("chef");
        return getDatabase().queryView(query, Employer.class);
    }

    // public List<Employer> employesPlusLocationsVendues() {
    // // Cette vue doit être définie dans CouchDB pour compter le nombre de
    // locations
    // // par employé
    // ViewQuery query = new
    // ViewQuery().designDocId("_design/employer").viewName("countLocationsByEmployer");
    // List<Map> results = getDatabase().queryView(query, Map.class);

    // // Utiliser une Map pour stocker le nombre de locations pour chaque employé
    // Map<String, Integer> locationCounts = new HashMap<>();
    // for (Map result : results) {
    // String employeId = (String) result.get("key");
    // Integer count = ((Number) result.get("value")).intValue();
    // locationCounts.put(employeId, count);
    // }

    // // // Récupérer tous les employés et enrichir avec le nombre de locations
    // // List<Employer> employes = findAll(Employer.class, "employer");
    // // for (Employer employe : employes) {
    // // Integer count = locationCounts.getOrDefault(employe.getId(), 0);
    // // employe.setNombreLocationsVendues(count);
    // // }

    // // Trier les employés par le nombre de locations vendues
    // employes.sort((e1, e2) -> Integer.compare(e2.getNombreLocationsVendues(),
    // e1.getNombreLocationsVendues()));

    // return employes;
    }

    public List<Employer> moyenneLocationsEmployeParAgence() {
        // Comme pour employesPlusLocationsVendues, cette méthode nécessiterait un
        // traitement côté application.
        return null; // Placeholder return statement
    }

    // ... autres méthodes ...
}
