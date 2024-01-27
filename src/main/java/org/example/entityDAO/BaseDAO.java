package org.example.entityDAO;

import org.apache.poi.ss.formula.functions.T;
import org.ektorp.*;
import org.ektorp.support.CouchDbDocument;
// import org.json.JSONObject;
import java.net.MalformedURLException;
import java.util.List;

import org.example.Connector;

// import javax.swing.text.html.parser.Entity;

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

    // La méthode findAll nécessite une vue générique pour chaque type d'entité.
    public List<T> findAll(Class<T> entityClass, String viewName) {
        ViewQuery query = new ViewQuery().designDocId("_design/" + entityClass.getSimpleName().toLowerCase())
                .viewName(viewName)
                .includeDocs(true);
        return db.queryView(query, entityClass);
    }
}