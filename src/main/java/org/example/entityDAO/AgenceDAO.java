package org.example.entityDAO;

import org.ektorp.ViewQuery;
import org.ektorp.support.CouchDbDocument;
import org.ektorp.support.View;
import org.example.entity.Agence;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class AgenceDAO extends BaseDAO {

    public ArrayList<JSONObject> sortAgencesByNom() {
        ViewQuery query = new ViewQuery().allDocs().includeDocs(true);
        List<JSONObject> entities = getDatabase().queryView(query, JSONObject.class);
        return new ArrayList<>(entities);
    }


}
