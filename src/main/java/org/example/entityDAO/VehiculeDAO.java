package org.example.entityDAO;
import org.ektorp.CouchDbConnector;
import org.ektorp.CouchDbInstance;
import org.ektorp.ViewQuery;
import org.ektorp.http.StdHttpClient;
import org.ektorp.UpdateConflictException;
import org.ektorp.impl.StdCouchDbInstance;
import org.ektorp.support.CouchDbDocument;
import org.ektorp.support.CouchDbRepositorySupport;

public class VehiculeDAO {
    @Override
    public void createIndexes() {
        CouchDbConnector db = new StdCouchDbConnector("vehicule", new StdCouchDbInstance(new StdHttpClient.Builder().url("http://admin:admin@localhost:5984").build()));
        db.createIndex("marque", "marque", "json");
        db.createIndex("modele", "modele", "json");
        db.createIndex("plaque_imat", "plaque_imat", "json");
    }
    public ArrayList<JSONObject> findByCriteria(String marque, String modele, String plaque_imat) {
        CouchDbConnector db = new StdCouchDbConnector("vehicule", new StdCouchDbInstance(new StdHttpClient.Builder().url("http://admin:admin@localhost:5984").build()));
        ViewQuery query = new ViewQuery().allDocs().includeDocs(true);
        if (marque != null) {
            query.designDocId("_design/vehicule").viewName("marque").key(marque);
        }
        if (modele != null) {
            query.designDocId("_design/vehicule").viewName("modele").key(modele);
        }
        if (plaque_imat != null) {
            query.designDocId("_design/vehicule").viewName("plaque_imat").key(plaque_imat);
        }
        List<CouchDbDocument> docs = db.queryView(query, CouchDbDocument.class);
        ArrayList<JSONObject> jsons = new ArrayList<>();
        for (CouchDbDocument doc : docs) {
            jsons.add(doc.getCurrentRevisionAsJson());
        }
        return jsons;
    }

    public ArrayList<JSONObject> vehiculesParAgence(int idAgence) {
        CouchDbConnector db = new StdCouchDbConnector("vehicule", new StdCouchDbInstance(new StdHttpClient.Builder().url("http://admin:admin@localhost:5984").build()));
        ViewQuery query = new ViewQuery().allDocs().includeDocs(true);
        query.designDocId("_design/vehicule").viewName("vehiculesParAgence").key(idAgence);
        List<CouchDbDocument> docs = db.queryView(query, CouchDbDocument.class);
        ArrayList<JSONObject> jsons = new ArrayList<>();
        for (CouchDbDocument doc : docs) {
            jsons.add(doc.getCurrentRevisionAsJson());
        }
        return jsons;
    }

    public ArrayList<JSONObject> vehiculesParMarqueAvecDetails(String marque) {
        CouchDbConnector db = new StdCouchDbConnector("vehicule", new StdCouchDbInstance(new StdHttpClient.Builder().url("http://admin:admin@localhost:5984").build()));
        ViewQuery query = new ViewQuery().allDocs().includeDocs(true);
        query.designDocId("_design/vehicule").viewName("vehiculesParMarqueAvecDetails").key(marque);
        List<CouchDbDocument> docs = db.queryView(query, CouchDbDocument.class);
        ArrayList<JSONObject> jsons = new ArrayList<>();
        for (CouchDbDocument doc : docs) {
            jsons.add(doc.getCurrentRevisionAsJson());
        }
        return jsons;
    }

    public ArrayList<JSONObject> vehiculesParPlaqueAvecDetails(String plaqueImat) {
        CouchDbConnector db = new StdCouchDbConnector("vehicule", new StdCouchDbInstance(new StdHttpClient.Builder().url("http://admin:admin@localhost:5984").build()));
        ViewQuery query = new ViewQuery().allDocs().includeDocs(true);
        query.designDocId("_design/vehicule").viewName("vehiculesParPlaqueAvecDetails").key(plaqueImat);
        List<CouchDbDocument> docs = db.queryView(query, CouchDbDocument.class);
        ArrayList<JSONObject> jsons = new ArrayList<>();
        for (CouchDbDocument doc : docs) {
            jsons.add(doc.getCurrentRevisionAsJson());
        }
        return jsons;
    }

    public void save(JSONObject json) {
        CouchDbConnector db = new StdCouchDbConnector("vehicule", new StdCouchDbInstance(new StdHttpClient.Builder().url("http://admin:admin@localhost:5984").build()));
        try {
            db.create(json);
        } catch (UpdateConflictException e) {
            CouchDbDocument doc = db.get(CouchDbDocument.class, json.getString("_id"));
            doc.put("marque", json.getString("marque"));
            doc.put("modele", json.getString("modele"));
            doc.put("plaque_imat", json.getString("plaque_imat"));
            db.update(doc);
        }
    }

}