package org.example.entityDAO;

import org.ektorp.*;
import org.ektorp.support.CouchDbDocument;
import org.json.JSONObject;
import java.net.MalformedURLException;
import java.util.List;

import org.example.Connector;

import javax.swing.text.html.parser.Entity;

public abstract class BaseDAO {


    private static final CouchDbConnector db;

    static {
        try {
            db = Connector.connect();
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
    }

    public static CouchDbConnector getDatabase() {
        return db;
    }

    public static void closeConnection() {
        db.getConnection().shutdown();
    }

    public void insert(CouchDbDocument entity) {
        db.create(entity);
    }

    public void deleteAll() {
        ViewQuery query = new ViewQuery().allDocs().includeDocs(true);
        List<CouchDbDocument> entities = db.queryView(query, CouchDbDocument.class);
        for (CouchDbDocument entity : entities) {
            db.delete(entity);
        }
    }
}