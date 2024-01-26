package org.example.entityDAO;

import org.ektorp.CouchDbConnector;
import org.ektorp.support.CouchDbRepositorySupport;
import org.example.enitty.Agence;

public class AgenceDAO extends CouchDbRepositorySupport<Agence> {

    private static int id = 0;
    public AgenceDAO(Class<Agence> type, CouchDbConnector db) {
        super(type, db);
    }

    // Méthodes CRUD spécifiques à Agence
    public Agence findById(String id) {
        return db.get(Agence.class, id);
    }

    public void addAgence(Agence agence) {
        db.create(agence);
    }

    public void updateAgence(Agence agence) {
        db.update(agence);
    }

    public void deleteAgence(Agence agence) {
        db.delete(agence);
    }
}
