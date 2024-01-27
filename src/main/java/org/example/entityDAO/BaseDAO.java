package org.example.entityDAO;

import org.ektorp.CouchDbConnector;
import org.ektorp.CouchDbInstance;
import org.ektorp.ViewQuery;
import org.ektorp.http.StdHttpClient;
import org.ektorp.UpdateConflictException;
import org.ektorp.impl.StdCouchDbInstance;
import org.ektorp.support.CouchDbDocument;
import org.ektorp.support.CouchDbRepositorySupport;
import org.example.entity.Agence;
import org.json.JSONObject;
import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.List;
import org.example.Connector;

public abstract class BaseDAO {

    private static final CouchDbConnector db;

    static {
        try {
            db = Connector.connect();
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
    }

    protected static CouchDbConnector getDatabase() {
        return db;
    }

    public static void closeConnection() {
        db.getConnection().shutdown();
    }

    public void insert(CouchDbDocument entity) {
        try {
            db.create(entity);
        } catch (UpdateConflictException e) {
            throw new RuntimeException(e);
        }
    }

    public JSONObject find(String id, String viewName) {
        return db.get(JSONObject.class, id);
    }

    public ArrayList<JSONObject> findAll(String viewName) {
        ViewQuery query = new ViewQuery().allDocs().includeDocs(true);
        List<JSONObject> entities = db.queryView(query, JSONObject.class);
        return new ArrayList<>(entities);
    }

    public void delete(String id) {
        db.delete(id, db.getCurrentRevision(id));
    }

    public void dropCollection(String viewName) {
        ViewQuery query = new ViewQuery().allDocs().includeDocs(true);
        List<JSONObject> entities = db.queryView(query, JSONObject.class);
        for (JSONObject entity : entities) {
            db.delete(entity);
        }
    }

    public void update(String id , JSONObject entity) {
        CouchDbDocument doc = db.get(CouchDbDocument.class, id);
        entity.put("_id", id);
        entity.put("_rev", db.getCurrentRevision(id));
        db.update(entity);
    }



}