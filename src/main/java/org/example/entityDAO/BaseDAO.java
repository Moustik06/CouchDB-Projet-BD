package org.example.entityDAO;

import org.ektorp.*;
import org.ektorp.support.CouchDbDocument;
import org.json.JSONObject;
import java.net.MalformedURLException;
import java.util.List;

import org.example.Connector;

import javax.swing.text.html.parser.Entity;

public abstract class BaseDAO {


    protected static final CouchDbConnector db;

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

    //faire CRUD
    public void update(CouchDbDocument entity) {
        db.update(entity);
    }

    public void delete(CouchDbDocument entity) {
        db.delete(entity);
    }

    public CouchDbDocument find(Class<? extends CouchDbDocument> type, String id) {
        return db.get(type, id);
    }

}