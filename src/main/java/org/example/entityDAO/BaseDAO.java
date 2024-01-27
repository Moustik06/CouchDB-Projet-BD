package org.example.entityDAO;

import org.ektorp.CouchDbConnector;
import org.ektorp.CouchDbInstance;
import org.ektorp.http.StdHttpClient;
import org.ektorp.UpdateConflictException;
import org.ektorp.impl.StdCouchDbInstance;
import org.ektorp.support.CouchDbDocument;
import org.ektorp.support.CouchDbRepositorySupport;
import org.example.entity.Agence;
import org.json.JSONObject;
import java.net.MalformedURLException;
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




}