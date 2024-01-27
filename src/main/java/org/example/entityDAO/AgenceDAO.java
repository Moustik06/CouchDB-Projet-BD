package org.example.entityDAO;

import org.ektorp.ViewQuery;
import org.ektorp.support.CouchDbDocument;
import org.ektorp.support.View;
import org.example.entity.Agence;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class AgenceDAO extends BaseDAO {

    //recuprer agence par id
    public Agence getAgenceById(int id) {
        return getDatabase().find(Agence.class, String.valueOf(id));
    }
    public ArrayList<Agence> sortAgencesByNom() {
        ViewQuery query = new ViewQuery().allDocs().includeDocs(true);
        List<Agence> entities = getDatabase().queryView(query, Agence.class);

        // Trier les agences par nom
        entities.sort(Comparator.comparing(Agence::getNom));

        return new ArrayList<>(entities);
    }

    // Trier agences par nombre d'employés
    // Trier agences par nombre d'employés
    public ArrayList<Agence> sortAgencesByNombreEmploye() {
        ViewQuery query = new ViewQuery().allDocs().includeDocs(true);
        List<Agence> entities = getDatabase().queryView(query, Agence.class);

        // Trier les agences par nombre d'employés
        entities.sort(Comparator.comparing(Agence::getNombreEmploye));

        return new ArrayList<>(entities);
    }

    //trier agence par nombre de client
    public ArrayList<JSONObject> sortAgencesByNombreClient() {
        ViewQuery query = new ViewQuery().allDocs().includeDocs(true);
        List<JSONObject> entities = getDatabase().queryView(query, JSONObject.class);
        return new ArrayList<>(entities);
    }

}
