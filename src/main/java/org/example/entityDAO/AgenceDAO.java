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

    // Trier agences par nombre d'employés par ordre croisaant
    public ArrayList<Agence> sortAgencesByNombreEmploye() {
        ViewQuery query = new ViewQuery().allDocs().includeDocs(true);
        List<Agence> entities = getDatabase().queryView(query, Agence.class);

        // Trier les agences par nombre d'employés
        entities.sort(Comparator.comparing(Agence::getNombreEmploye));

        return new ArrayList<>(entities);
    }

    // Trier agences par nombre d'employés par ordre decroissant
    public ArrayList<Agence> sortAgencesByNombreEmployeDec() {
        ViewQuery query = new ViewQuery().allDocs().includeDocs(true);
        List<Agence> entities = getDatabase().queryView(query, Agence.class);

        // Trier les agences par nombre d'employés de manière décroissante
        entities.sort(Comparator.comparing(Agence::getNombreEmploye).reversed());

        return new ArrayList<>(entities);
    }

    // Trier agences par nombre de clients
    public ArrayList<Agence> sortAgencesByNombreClientDec() {
        // Récupérer toutes les agences
        ViewQuery query = new ViewQuery().allDocs().includeDocs(true);
        List<Agence> entities = getDatabase().queryView(query, Agence.class);

        // Parcourir chaque agence pour calculer le nombre de clients
        for (Agence agence : entities) {
            // Récupérer l'ID de l'agence
            int idAgence = agence.getId();

            // Effectuer une jointure avec la collection "location" sur le champ "_id_agence"
            ViewQuery locationQuery = new ViewQuery().designDocId("_design/location").viewName("by_agence").key(idAgence).includeDocs(true);
            List<Location> locations = getDatabase().queryView(locationQuery, Location.class);

            // Effectuer une jointure avec la collection "facture" sur le champ "_id_location"
            for (Location location : locations) {
                int idLocation = location.getId();
                ViewQuery factureQuery = new ViewQuery().designDocId("_design/facture").viewName("by_location").key(idLocation).includeDocs(true);
                List<Facture> factures = getDatabase().queryView(factureQuery, Facture.class);

                // Ajouter le nombre de clients pour cette agence
                agence.setNombreClients(agence.getNombreClients() + factures.size());
            }
        }

        // Trier les agences par nombre de clients en ordre décroissant
        entities.sort(Comparator.comparingInt(Agence::getNombreClients).reversed());

        return new ArrayList<>(entities);
    }
}
