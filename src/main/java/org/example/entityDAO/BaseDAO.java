package org.example.entityDAO;

import org.ektorp.CouchDbConnector;
import org.ektorp.CouchDbInstance;
import org.ektorp.http.StdHttpClient;
import org.ektorp.UpdateConflictException;
import org.ektorp.impl.StdCouchDbInstance;
import org.ektorp.support.CouchDbDocument;
import org.ektorp.support.CouchDbRepositorySupport;
import org.json.JSONObject;
import java.net.MalformedURLException;
import java.util.List;

public abstract class BaseDAO<T extends CouchDbDocument> {
    private static final CouchDbInstance dbInstance;
    private static CouchDbConnector dbConnector;

    static {
        CouchDbInstance tempDbInstance = null;
        try {
            // Initialize the CouchDB connection
            tempDbInstance = new StdCouchDbInstance(new StdHttpClient.Builder().url("http://localhost:5984").build());
            dbConnector = tempDbInstance.createConnector("projetdb", true);
        } catch (Exception e) {
            e.printStackTrace(); // Handle the exception according to your needs
        }
        dbInstance = tempDbInstance;
    }

    protected static CouchDbConnector getConnector() {
        return dbConnector;
    }

    public static void closeConnection() {
        // Not typically needed with CouchDB but can be implemented if necessary.
    }

    public void insert(T entity) {
        try {
            // Convert the entity to a JSONObject
            JSONObject doc = new JSONObject(entity);

            // Create a repository to manage database operations
            CouchDbRepositorySupport<T> repository = new CouchDbRepositorySupport<T>(getEntityClass(), dbConnector) {
            };

            // Add the document to the database
            repository.add(entity);
        } catch (UpdateConflictException e) {
            System.err.println("Conflict during insertion: " + e.getMessage());
        } catch (Exception e) {
            System.err.println("Error during insertion: " + e.getMessage());
        }
    }

    public T find(String id, String collectionName) {
        CouchDbRepositorySupport<T> repository = new CouchDbRepositorySupport<T>(getEntityClass(), dbConnector) {
        };
        return repository.get(id);
    }

    public List<T> findAll(String collectionName) {
        CouchDbRepositorySupport<T> repository = new CouchDbRepositorySupport<T>(getEntityClass(), dbConnector) {
        };
        return repository.getAll();
    }

    public void delete(String id, String collectionName) {
        T entity = find(id, collectionName);
        if (entity != null) {
            CouchDbRepositorySupport<T> repository = new CouchDbRepositorySupport<T>(getEntityClass(), dbConnector) {
            };
            repository.remove(entity);
        }
    }

    public void update(String id, JSONObject updatedFields, String collectionName) {
        T entity = find(id, collectionName);
        if (entity != null) {
            updateEntityWithJson(entity, updatedFields);
            CouchDbRepositorySupport<T> repository = new CouchDbRepositorySupport<T>(getEntityClass(), dbConnector) {
            };
            repository.update(entity);
        }
    }

    protected abstract Class<T> getEntityClass();

    protected abstract void updateEntityWithJson(T entity, JSONObject json);

    public abstract void createIndexes();

    public abstract List<T> findByCriteria(JSONObject criteria);
}