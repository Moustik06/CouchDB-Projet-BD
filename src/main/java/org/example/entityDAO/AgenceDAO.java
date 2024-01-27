package org.example.entityDAO;

import org.ektorp.ViewQuery;
import org.ektorp.ViewResult;
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

    // Trier agences par nombre de clients par ordre decroissant
    public ArrayList<Agence> sortAgencesByNombreClientDec() {
        // Utiliser une vue pour récupérer le nombre de clients par agence
        ViewQuery query = new ViewQuery().designDocId("_design/Agence").viewName("nombreClients").group(true);
        List<ViewResult.Row> rows = getDatabase().queryView(query, ViewResult.Row.class);

        // Créer une liste pour stocker les agences avec le nombre de clients
        List<Agence> agences = new ArrayList<>();

        // Parcourir les résultats de la vue et créer des objets Agence avec le nombre de clients
        for (ViewResult.Row row : rows) {
            //afficher row
            System.out.println(row);
            String agenceId = row.getKey();
            int nombreClients = row.getValueAsInt();

            // Créer un objet Agence avec l'ID et le nombre de clients
            Agence agence = new Agence();
            agence.setId(agenceId);
            agence.setNombreClients(nombreClients);

            // Ajouter l'objet Agence à la liste
            agences.add(agence);
        }

        // Trier les agences par nombre de clients en ordre décroissant
        agences.sort(Comparator.comparingInt(Agence::getNombreClients).reversed());

        return new ArrayList<>(agences);
    }


}
