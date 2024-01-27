package org.example.entityDAO;

import org.ektorp.ViewQuery;
import org.ektorp.support.CouchDbDocument;
import org.ektorp.support.View;
import org.example.entity.Agence;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class AgenceDAO extends BaseDAO {

    //recuprer agence par id
    public Agence getAgenceById(int id) {
        return getDatabase().find(Agence.class, String.valueOf(id));
    }
    public ArrayList<JSONObject> sortAgencesByNom() {
        ViewQuery query = new ViewQuery().allDocs().includeDocs(true);
        List<JSONObject> entities = getDatabase().queryView(query, JSONObject.class);
        return new ArrayList<>(entities);
    }

    //trier agence par nombre d'mployer
    public ArrayList<JSONObject> sortAgencesByNombreEmployer() {
        ViewQuery query = new ViewQuery().allDocs().includeDocs(true);
        List<JSONObject> entities = getDatabase().queryView(query, JSONObject.class);
        return new ArrayList<>(entities);
    }

    //trier agence par nombre de client
    public ArrayList<JSONObject> sortAgencesByNombreClient() {
        ViewQuery query = new ViewQuery().allDocs().includeDocs(true);
        List<JSONObject> entities = getDatabase().queryView(query, JSONObject.class);
        return new ArrayList<>(entities);
    }


}
