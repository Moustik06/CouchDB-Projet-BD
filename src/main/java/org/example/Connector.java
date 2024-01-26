package org.example;
import org.ektorp.CouchDbConnector;
import org.ektorp.CouchDbInstance;
import org.ektorp.http.HttpClient;
import org.ektorp.http.StdHttpClient;
import org.ektorp.impl.StdCouchDbConnector;
import org.ektorp.impl.StdCouchDbInstance;

import java.net.MalformedURLException;

public class Connector {

    private static final String DB_URL = "http://localhost:5984";
    private static final String DB_NAME = "example";
    private static final String USERNAME = "nocap";
    private static final String PASSWORD = "HugoDtc20";

    public static CouchDbConnector connect() throws MalformedURLException {
        HttpClient httpClient = new StdHttpClient.Builder()
                .url(DB_URL)
                .username(USERNAME)
                .password(PASSWORD)
                .build();

        CouchDbInstance dbInstance = new StdCouchDbInstance(httpClient);
        CouchDbConnector db = new StdCouchDbConnector(DB_NAME, dbInstance);
        db.createDatabaseIfNotExists();
        return db;
    }
}
