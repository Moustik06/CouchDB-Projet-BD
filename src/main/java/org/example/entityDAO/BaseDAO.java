package org.example.entityDAO;

import org.ektorp.*;
import org.ektorp.support.CouchDbDocument;
import org.json.JSONObject;
import java.net.MalformedURLException;

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
        System.out.println(entity);
        db.create(entity);
        System.out.println("ntm");
    }
}